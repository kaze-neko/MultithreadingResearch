package org.kazeneko.controllers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingOptionException;
import org.kazeneko.model.mathoperations.MathOperation;
import org.kazeneko.model.task.NumericalTask;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class SequentialComputingController implements MathOperationHandler {
    @Override
    public long compute(List<MathOperation> mathOperations) {
        Instant start = Instant.now();
        mathOperations.get(0).execute();
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }
    @Override
    public MathOperation getMathOperation(CommandLine cmd, NumericalTask task) throws MissingOptionException {
        return MathOperationHandler.super.getMathOperation(cmd, task);
    }
}
