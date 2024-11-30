package org.kazeneko.controllers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingOptionException;
import org.kazeneko.model.mathoperations.MathOperation;
import org.kazeneko.model.task.NumericalTask;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ParallelComputingController implements MathOperationHandler {
    @Override
    public long compute(List<MathOperation> mathOperations) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (MathOperation mathOperation : mathOperations) {
            threads.add(new Thread(new MathThread(mathOperation)));
        }
        Instant start = Instant.now();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }
    @Override
    public MathOperation getMathOperation(CommandLine cmd, NumericalTask task) throws MissingOptionException {
        return MathOperationHandler.super.getMathOperation(cmd, task);
    }
    public ArrayList<MathOperation> getAllMathOperations(CommandLine cmd, NumericalTask task) throws MissingOptionException {
        if (Integer.parseInt(cmd.getOptionValue("parallel")) <= 1) {
            throw new RuntimeException("Invalid value for the command line option \"--parallel\" (\"-p\")! To define " +
                    "the number of threads pass an integer in the range from 2 to 100.");
        }
        ArrayList<NumericalTask> subtasks = task.split(Integer.parseInt(cmd.getOptionValue("parallel")));
        ArrayList<MathOperation> suboperations = new ArrayList<>();
        for (NumericalTask subtask : subtasks) {
            suboperations.add(getMathOperation(cmd, subtask));
        }
        return suboperations;
    }
}
