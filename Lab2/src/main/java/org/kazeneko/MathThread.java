package org.kazeneko;

import java.math.BigInteger;
import java.util.ArrayList;

public class MathThread implements Runnable {
    public static MathOperations operation;
    public static int coefficient;
    private int threadIndex;
    private ArrayList<Integer> task;
    public MathThread(int threadIndex, ArrayList<Integer> task) {
        this.threadIndex = threadIndex;
        this.task = task;
    }
    @Override
    public void run() {
        long tempL;
        BigInteger tempBI;
        for (Integer i : task) {
            switch (operation) {
                case MULT :
                    tempL = MathOperations.multiplication(i, coefficient);
                    break;
                case EXP:
                    tempBI = MathOperations.exponentiation(i, coefficient);
                    break;
                case FACT:
                    tempBI = MathOperations.factorialisation(i);
                    break;
                case FIB:
                    tempBI = MathOperations.getFibonacciNumber(i);
                    break;
            }
        }
    }
}
