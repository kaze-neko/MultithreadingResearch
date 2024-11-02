package org.kazeneko;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SequentialComputing {
    public static void run(int coefficient, ArrayList<Integer> task, MathOperations operation) {
        Instant start = Instant.now();
        switch (operation) {
            case MULT :
                for (Integer number : task) {
                    long temp = MathOperations.multiplication(number, coefficient);
                }
                break;
            case EXP:
                for (Integer number : task) {
                    BigInteger temp = MathOperations.exponentiation(number, coefficient);
                }
                break;
            case FACT:
                for (Integer number : task) {
                    BigInteger temp = MathOperations.factorialisation(number);
                }
                break;
            case FIB:
                for (Integer number : task) {
                    BigInteger temp = MathOperations.getFibonacciNumber(number);
                }
                break;
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println(elapsed);
    }
}
