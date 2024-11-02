package org.kazeneko;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public static void writeFileWithSequenceOfNaturalNumbers(int N) {
        int currentNaturalNumber = 1;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
            while (currentNaturalNumber <= N) {
                String nextNaturalNumber = currentNaturalNumber++ + " ";
                writer.write(nextNaturalNumber);
            }
            writer.close();
        } catch (IOException exception) {
            System.out.println("Problem with file writing!");
        }
    }
}
