package pt.europeia.eda.javaslides.presentation04;

import static java.lang.System.out;

public class CodeExamples {

    // Suppress warnings due to this code not being intended to run:
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Declaration of variable with initialization:
        int i = 1;

        // Assignment for incrementation:
        i = i + 1;

        // Declaration of constants:
        final int m = 20;
        final int n = 25;

        // Declaration of variable:
        int minimum;

        // Alternative initializations:
        if (m < n) {
            minimum = m;
        } else {
            minimum = n;
        }

        // Brackets are not necessary if they envelop a single statement:
        if (m < n)
            minimum = m;
        else
            minimum = n;

        out.println("The minimum of " + m + " and " + n + " is " + minimum
                + ".");

        // Calls the function minimumOf() to obtain the minimum of two ints:
        minimum = minimumOf(m, n);

        out.println("The minimum of " + m + " and " + n + " is " + minimum
                + ".");

        final int grade = 14;

        if (grade < 10) {
            out.println("F");
        } else if (grade < 12) {
            out.println("D");
        } else {
            out.println("A, B, or C");
        }

        // Prints some text and adds a line ending:
        System.out.println("A line.");

        // Also prints some text and adds a line ending (see import static at
        // the top of the file):
        out.println("Also a line.");

        // Prints some text:
        out.print("Yet ");

        // Prints more text and adds a line ending:
        out.println("another line.");
    }

    // Calculates and returns the minimum of its two arguments:
    public static int minimumOf(final int m, final int n) {
        if (m < n)
            return m;
        else
            return n;
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