package org.kazeneko.model.mathoperations;

import org.kazeneko.model.task.NumericalTask;

import java.math.BigInteger;

public class Factorialisation implements MathOperation {
    private final NumericalTask task;
    public Factorialisation(NumericalTask task) { this.task = task; }

    @Override
    public void execute() {
        for (Integer n : task.getNumbers()) {
            BigInteger factorial = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++) { factorial = factorial.multiply(BigInteger.valueOf(i)); }
            BigInteger result = factorial;
        }
    }
}
