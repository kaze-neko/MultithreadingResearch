package org.kazeneko.model.mathoperations;

import org.kazeneko.model.task.NumericalTask;

import java.math.BigInteger;

public class GettingFibonacciNumber implements MathOperation {
    private final NumericalTask task;
    public GettingFibonacciNumber(NumericalTask task) { this.task = task; }
    @Override
    public void execute() {
        for (Integer n : task.getNumbers()) {
            BigInteger nBI = BigInteger.valueOf(n);
            BigInteger n0 = BigInteger.valueOf(0);
            if (nBI.compareTo(n0) == 0) { BigInteger result = n0; }
            BigInteger n1 = BigInteger.valueOf(1);
            for (var i = BigInteger.valueOf(2); i.compareTo(nBI) <= 0; i = i.add(BigInteger.valueOf(1))) {
                var n2 = n0.add(n1);
                n0 = n1;
                n1 = n2;
            }
            BigInteger result = n1;
        }
    }
}
