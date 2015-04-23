package pt.europeia.eda.session02;

import static java.lang.System.out;

public class CodeExamples {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }

    // Integer types, such as byte, have a limited range (-128 to 127):
    public static void example1() {
        byte number = 0;
        for (int i = 0; i != 256; i++) {
            out.println(number);
            // If number is the largest byte (127), it is "incremented" to -128:
            number++;
        }
    }

    // Array items are implicitly initialized with a null value:
    public static void example2() {
        final int[] values = new int[5];
        out.println("values[2]: " + values[2]);
    }

    // Array items may be explicitly initialized:
    public static void example3() {
        // final int[] values = new int[] {1, 2, 4, 8, 16};
        final int[] values = { 1, 2, 4, 8, 16 };
        out.println("values[2]: " + values[2]);
    }

    // Another, more verbose, way of explicitly initializing an array:
    public static void example4() {
        // Verbose (don't use):
        final int[] values = new int[] { 1, 3, 9, 27, 81 };
        out.println("values[2]: " + values[2]);
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