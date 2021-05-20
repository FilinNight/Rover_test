package com.arthurTest.helperClasses;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class RecordToFile {
    public static void recordToTXT(Path path, int steps, int fuel, boolean errorStart,
        boolean errorFinish, boolean error) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("path-plan.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (error) {
            writer.println("path-plan.txt");
            writer.println("Error: Error in the correctness of the map");
            writer.println("Сheck the correctness of the map");
        } else if (errorStart) {
            writer.println("path-plan.txt");
            writer.println("Error: CannotStartMovement");
            writer.println(
                "Cannot start a movement because start or finish coordinate not available!");
        } else if (errorFinish) {
            writer.println("path-plan.txt");
            writer.println("Error: CannotFinishMovement");
            writer.println("it's impossible to get to the finish line");
        } else {
            writer.println("path-plan.txt");
            writer.println(path);
            writer.println("steps: " + steps);
            writer.println("fuel: " + fuel);
        }
        writer.close();
    }
}



