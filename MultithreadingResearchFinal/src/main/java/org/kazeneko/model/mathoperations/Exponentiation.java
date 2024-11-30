package org.kazeneko.model.mathoperations;

import org.kazeneko.model.task.NumericalTask;

import java.math.BigInteger;

public class Exponentiation implements MathOperation {
    private final NumericalTask task;
    private final int k;    // exponentiation coefficient
    public Exponentiation(NumericalTask task, int k) {
        this.task = task;
        this.k = k;
    }
    @Override
    public void execute() {
        int[] ints = task.getNumbers();
        for (int i : ints) { BigInteger result = BigInteger.valueOf(i).pow(k);}
    }
}
