package org.kazeneko;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // reading N env and generating file
        String numberOfNaturalNumbers = System.getenv("LAB_2_N");
        if (numberOfNaturalNumbers != null && !numberOfNaturalNumbers.isBlank()) {
            FileGenerator.writeFileWithSequenceOfNaturalNumbers(Integer.parseInt(numberOfNaturalNumbers));
        } else {
            System.out.println("You have to set environment variable LAB_2_N, which specifies the length of the file!");
            System.exit(1);
        }
        // reading OPERATION env
        String mathOperation = System.getenv("LAB_2_OPERATION");
        MathOperations operation = null;
        if (mathOperation != null && !mathOperation.isBlank()) {
            switch (mathOperation) {
                case "MULT" : operation = MathOperations.MULT; break;
                case "EXP" : operation = MathOperations.EXP; break;
                case "FACT" : operation = MathOperations.FACT; break;
                case "FIB" : operation = MathOperations.FIB; break;
                default:
                    System.out.println("To set the environment variable LAB_2_OPERATION, which specifies whether " +
                            "multiplication, exponentiation, factorialisation or getting Fibonacci number will be " +
                            "used for computing, use the values MULT, EXP, FACT or FIB respectively.");
                    System.exit(1);
            }
        } else {
            System.out.println("You have to set the environment variable LAB_2_OPERATION, which specifies whether " +
                    "multiplication, exponentiation, factorialisation or getting Fibonacci number will be used for " +
                    "computing, use the values MULT, EXP, FACT or FIB respectively.");
            System.exit(1);
        }
        // reading COEFFICIENT env
        int coefficient = 1;
        if (operation == MathOperations.MULT || operation == MathOperations.EXP) {
            String coefficientString = System.getenv("LAB_2_COEFFICIENT");
            if (coefficientString != null && !coefficientString.isBlank()) {
                coefficient = Integer.parseInt(coefficientString);
            } else {
                System.out.println("You have to set environment variable LAB_2_COEFFICIENT, which specifies the " +
                        "coefficient for math operations!");
                System.exit(1);
            }
        }
        // reading MODE env
        String computingMode = System.getenv("LAB_2_MODE");
        if (computingMode != null && !computingMode.isBlank()) {
            switch (computingMode) {
                case "SEQ":
                    SequentialComputing.run(coefficient, CommonFunctions.getTask(), operation);
                    break;
                case "PAR":
                    String numberOfThreads = System.getenv("LAB_2_M");
                    int m = 0;
                    if (numberOfThreads != null && !numberOfThreads.isBlank()) {
                        m = Integer.parseInt(numberOfThreads);
                    } else {
                        System.out.println("You have to set environment variable LAB_2_M, which specifies the " +
                                "number of threads");
                        System.exit(1);
                    }
                    ParallelComputing.run(coefficient, CommonFunctions.getTask(), operation, m);
                    break;
                default:
                    System.out.println("To set the environment variable LAB_2_MODE, which specifies whether the " +
                            "calculations will be sequential or parallel, use the values SEQ or PAR respectively.");
                    System.exit(1);
            }
        } else {
            System.out.println("You have to set the environment variable LAB_2_MODE, which specifies whether the " +
                    "calculations will be sequential or parallel. Use the values SEQ or PAR respectively.");
            System.exit(1);
        }
    }
}