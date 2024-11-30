package org.kazeneko.controllers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.MissingOptionException;
import org.kazeneko.model.mathoperations.*;
import org.kazeneko.model.task.NumericalTask;

import java.util.Arrays;
import java.util.List;

public interface MathOperationHandler {
    long compute(List<MathOperation> mathOperations);    // this method realisations return computation time
    default MathOperation getMathOperation(CommandLine cmd, NumericalTask task) throws MissingOptionException {
        if (!cmd.hasOption("operation")) {
            throw new MissingOptionException("You have to provide the type of the math operation that will be used " +
                    "for the computations!");
        }
        if (!cmd.hasOption("k") && Arrays.asList("MULT","EXP").contains(cmd.getOptionValue("operation"))) {
            throw new MissingOptionException("You have to provide the value of the parameter n which defines the " +
                    "coefficient k that is required for multiplication and exponentiation!");
        }
        switch (cmd.getOptionValue("operation")) {
            case "MULT" : return new Multiplication(task, Integer.parseInt(cmd.getOptionValue("k")));
            case "EXP"  : return new Exponentiation(task, Integer.parseInt(cmd.getOptionValue("k")));
            case "FACT" : return new Factorialisation(task);
            case "FIB"  : return new GettingFibonacciNumber(task);
            default:
                throw new RuntimeException("Invalid value for the command line option \"--operation\" (\"-o\")! " +
                        "To define whether multiplication, exponentiation, factorialisation or getting Fibonacci" +
                        " number will be used for computations, pass the value MULT, EXP, FACT or FIB respectively.");
        }
    }
}
