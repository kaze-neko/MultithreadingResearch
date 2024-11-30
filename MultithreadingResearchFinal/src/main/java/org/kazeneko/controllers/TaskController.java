package org.kazeneko.controllers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingOptionException;
import org.kazeneko.model.task.NumericalTask;

public class TaskController {
    public NumericalTask getTask(CommandLine cmd) throws MissingOptionException {
        if (!cmd.hasOption("n")) {
            throw new MissingOptionException("You have to provide the value of the parameter n which defines the " +
                    "size of the task!");
        }
        NumericalTask numericalTask = null;
        if (cmd.hasOption("read")) {
            numericalTask = new NumericalTask();
            numericalTask.binRead(cmd.getOptionValue("read"), Integer.parseInt(cmd.getOptionValue("n")));
        } else { numericalTask = new NumericalTask(Integer.parseInt(cmd.getOptionValue("n"))); }
        if (cmd.hasOption("write")) { numericalTask.binWrite(cmd.getOptionValue("write")); }
        return numericalTask;
    }
}
