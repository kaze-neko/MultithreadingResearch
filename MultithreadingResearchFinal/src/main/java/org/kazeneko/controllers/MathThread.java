package org.kazeneko.controllers;

import org.kazeneko.model.mathoperations.MathOperation;

public class MathThread implements Runnable {
    private MathOperation operation;
    public MathThread(MathOperation operation) { this.operation = operation; }
    @Override
    public void run() {
        operation.execute();
    }
}
