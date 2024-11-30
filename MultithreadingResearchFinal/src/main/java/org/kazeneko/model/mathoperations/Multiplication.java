package org.kazeneko.model.mathoperations;

import org.kazeneko.model.task.NumericalTask;

public class Multiplication implements MathOperation {
    private final NumericalTask task;
    private final int k;    // multiplication coefficient
    public Multiplication(NumericalTask task, int k) {
        this.task = task;
        this.k = k;
    }
    @Override
    public void execute() {
        int[] ints = task.getNumbers();
        for (int i : ints) { long result = (long) i * k; }
    }
}
