package pt.europeia.eda.javaslides.presentation11;

import static java.lang.System.out;

import java.util.Scanner;

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

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 */