package org.kazeneko.model.task;

import java.io.*;
import java.util.ArrayList;

public class NumericalTask implements BinaryWriteable, BinaryReadable, Splittable<NumericalTask> {
    private int[] numbers;
    public NumericalTask() { }
    public NumericalTask(int size) {
        if (size <= 0) throw new IllegalArgumentException("The size of the numerical task must be positive!");
        numbers = new int[size];
        for (int i = 1; i <= size; i++) { numbers[i-1] = i; }
    }
    public int[] getNumbers() { return numbers; }
    @Override
    public void binWrite(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for (Integer number : numbers) { dataOutputStream.writeInt(number); }
            fileOutputStream.close();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to write binary task file due to invalid filepath!", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void binRead(String filePath, int size) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            numbers = new int[size];
            for (int i = 0; i < size; i++) { numbers[i] = dataInputStream.readInt(); }
            fileInputStream.close();
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to read binary task file due to invalid filepath!", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList<NumericalTask> split(int numberOfParts) {
        ArrayList<NumericalTask> subtasks = new ArrayList<>();
        for (int i = 0; i < numberOfParts; i++) {
            int subtaskSize = 0;
            for (int j = i; j < numbers.length; j += numberOfParts) { subtaskSize++; }
            NumericalTask subtask = new NumericalTask(subtaskSize);
            for (int j = i; j < numbers.length; j += numberOfParts) { subtask.numbers[j/numberOfParts] = numbers[j]; }
            subtasks.add(subtask);
        }
        return subtasks;
    }
}
