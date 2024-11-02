package org.kazeneko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonFunctions {
    public static ArrayList<Integer> getTask() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("file.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Integer> task = new ArrayList<>();
        while (scanner.hasNextInt()) task.add(scanner.nextInt());
        return task;
    }
}
