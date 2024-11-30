package org.kazeneko;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.kazeneko.controllers.ParallelComputingController;
import org.kazeneko.controllers.SequentialComputingController;
import org.kazeneko.controllers.TaskController;
import org.kazeneko.model.mathoperations.MathOperation;
import org.kazeneko.model.task.NumericalTask;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws ParseException {
        CLIInstruments cliInstruments = new CLIInstruments();
        CommandLine cmd = cliInstruments.getCommandLine(cliInstruments.getOptions(),args);

        TaskController taskController = new TaskController();
        NumericalTask task = taskController.getTask(cmd);
        long time;
        if (!cmd.hasOption("parallel")) {
            SequentialComputingController sequentialComputingController = new SequentialComputingController();
            MathOperation mathOperation = sequentialComputingController.getMathOperation(cmd, task);
            time = sequentialComputingController.compute(Collections.singletonList(mathOperation));
        } else {
            ParallelComputingController parallelComputingController = new ParallelComputingController();
            ArrayList<MathOperation> mathOperations = parallelComputingController.getAllMathOperations(cmd, task);
            time = parallelComputingController.compute(mathOperations);
        }
        System.out.println(time);
    }
}
