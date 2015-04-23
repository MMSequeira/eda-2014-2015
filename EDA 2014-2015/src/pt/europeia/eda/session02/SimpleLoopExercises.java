package pt.europeia.eda.session02;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class SimpleLoopExercises {

    public static Scanner inputScanner = new Scanner(in);

    public static void main(String[] args) {
        exercise1();
        exercise2();
        exercise3();
        exercise4();
    }

    // Print sequences of numbers:
    public static void exercise1() {
        out.println("From 1 to 10:");
        for (int number = 1; number != 11; number++)
            out.println(number);

        out.println("From 1 to 10 (step 2):");
        for (int number = 1; number != 11; number += 2)
            out.println(number);

        out.println("From 1 to 10 (step 3):");
        for (int number = 1; number <= 10; number += 3)
            out.println(number);
    }

    // Print a triangle of stars (size 3):
    public static void exercise2() {
        for (int line = 0; line != 3; line++) {
            for (int star = 0; star != line + 1; star++)
                out.print('*');
            out.println();
        }
    }

    // Print a series of 4 triangles of increasing size:
    public static void exercise3() {
        for (int triangle = 0; triangle != 4; triangle++)
            for (int line = 0; line != triangle + 1; line++) {
                for (int star = 0; star != line + 1; star++)
                    out.print('*');
                out.println();
            }
    }

    // Ask user for an integer and search its position in an array:
    public static void exercise4() {
        // The array of numbers:
        final int[] numbers = { 10, 40, -1, 5, 6 };

        // Get the number to search:
        out.print("Insert the number to search: ");
        final int numberToSearch = inputScanner.nextInt();

        // Search:
        int index = 0;
        while (index != numbers.length && numbers[index] != numberToSearch)
            index++;

        // If the loop ended because we exhausted the array, the number was not
        // found:
        if (index == numbers.length)
            out.println("Not found!");
        else
            out.println("Found in position " + (index + 1));
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