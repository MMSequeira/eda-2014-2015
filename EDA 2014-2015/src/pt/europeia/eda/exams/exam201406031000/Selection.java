package pt.europeia.eda.exams.exam201406031000;

import static java.lang.System.out;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Arrays;

public final class Selection {

    private Selection() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static void sort(final double[] values) {
        for (int n = 0; n < values.length - 1; n++) {
            int indexOfMinimum = n;

            for (int i = indexOfMinimum + 1; i != values.length; i++)
                if (isLess(values[i], values[indexOfMinimum]))
                    indexOfMinimum = i;

            // This line is the answer to Question 10 of the 2014-06-03 10:00
            // exam:
            if (n != indexOfMinimum && values[n] != values[indexOfMinimum])
                swap(values, n, indexOfMinimum);
        }
    }

    private static boolean isLess(final double firstValue,
            final double secondValue) {
        return firstValue < secondValue;
    }

    private static void swap(final double[] values, final int firstPosition,
            final int secondPosition) {
        final double temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    public static void main(final String[] arguments) {
        final int numberOfTests = 100;

        for (int size = 1; size != 1 << 16; size *= 2) {
            out.println("Sorting " + size + " items.");

            final double[] values = new double[size];

            for (int i = 0; i != values.length; i++)
                values[i] = i / 4;

            for (int test = 0; test != numberOfTests; test++) {
                final double[] valuesToSort = values.clone();

                StdRandom.shuffle(valuesToSort);

                sort(valuesToSort);

                if (!Arrays.equals(values, valuesToSort))
                    out.println("\tError sorting: " + Arrays.toString(values));
            }
        }
    }

}

/*
 * Copyright 2015, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This file is a derivative work of the code which accompanies the textbook
 * 
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
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
 * 
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */