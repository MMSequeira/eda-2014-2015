package pt.europeia.eda.java_slides.presentation11;

import java.util.Scanner;

import static java.lang.System.out;

public class CodeExamples {

    public enum Command {
        SAVE, LOAD, EXIT;
    }

    public static void main(final String[] arguments) {
        testIntegers();
        testSwitch();
    }
    
    public static void testSwitch() {
        final Scanner inputScanner = new Scanner(System.in);
        
        out.print("Introduza um comando: ");
        final String commandText = inputScanner.nextLine();
        final Command command = Command.valueOf(commandText);
        
        switch (command) {
        case SAVE:
            out.println("Perform save.");
            break;
        case LOAD:
            out.println("Perform load.");
            break;
        case EXIT:
            out.println("Perform exit.");
            break;
        }
        
        inputScanner.close();
    }
    
    public static void testIntegers() {
        final int minimum = Integer.MIN_VALUE;
        final int maximum = Integer.MAX_VALUE;

        out.println(minimum);
        out.println(maximum);
    }

}
