package org.kazeneko;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class ParallelComputing {
    private static ArrayList<Integer> getSubtask(int threadIndex, int M, ArrayList<Integer> task) {
        ArrayList<Integer> subtask = new ArrayList<>();
        for (int i = threadIndex; i < task.size(); i += M) {
            subtask.add(task.get(i));
        }
        return subtask;
    }
    public static void run(int coefficient, ArrayList<Integer> task, MathOperations operation, int M) {
        MathThread.operation = operation;
        MathThread.coefficient = coefficient;
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            threads.add(new Thread(new MathThread(i,getSubtask(i,M,task))));
        }
        Instant start = Instant.now();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println(elapsed);
    }
}
