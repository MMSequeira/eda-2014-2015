package pt.europeia.eda.sessionx04;

import static java.lang.System.out;

import java.util.Arrays;

//Instrumented (and complete) version of the class in Question 6 of the
//2014-06-03 10:00 exam:
public final class Quick {

    private Quick() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    private static int numberOfComparisons = 0;
    private static int numberOfSwaps = 0;
    private static int numberOfPartitions = 0;

    private static int partition(final double[] values, final int first,
            final int last) {
        numberOfPartitions++;

        int i = first;
        int j = last + 1;

        final double pivot = values[first];

        while (true) {
            do
                ++i;
            while (isLess(values[i], pivot) && i != last);

            do
                --j;
            while (isLess(pivot, values[j]) && j != first);

            if (i >= j)
                break;

            swap(values, i, j);
        }

        swap(values, first, j);

        return j;
    }

    private static void sort(final double[] values, final int first,
            final int last) {
        if (last <= first)
            return;

        final int j = partition(values, first, last);

        out.println("values after partition " + numberOfPartitions + " = "
                + Arrays.toString(values));

        sort(values, first, j - 1);
        sort(values, j + 1, last);
    }

    public static void sort(final double[] values) {
        sort(values, 0, values.length - 1);
    }

    private static boolean isLess(final double first, final double second) {
        numberOfComparisons++;

        return first < second;
    }

    private static void swap(final double[] values, final int firstPosition,
            final int secondPosition) {
        numberOfSwaps++;

        final double temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    /*
     * N = 7
     *   0  1  2  3  4  5  6
     * [10  4  5  6  7  8  9]
     * 
     * pivot = 10, NC = 6 + 1 = 7 = N, NS = 1
     *   0  1  2  3  4  5  6
     * [ 9  4  5  6  7  8 10]
     *                    --
     * pivot = 9, NC = 5 + 1 = 6 = N - 1, NS = 1
     *   0  1  2  3  4  5  6
     * [ 8  4  5  6  7  9 10]
     *                  - --
     * pivot = 8, NC = 4 + 1 = 5 = N - 2, NS = 1
     *   0  1  2  3  4  5  6
     * [ 7  4  5  6  8  9 10]
     *               -  - --
     * pivot = 7, NC = 3 + 1 = 4 = N - …, NS = 1
     *   0  1  2  3  4  5  6
     * [ 6  4  5  7  8  9 10]
     *            -  -  - --
     * pivot = 6, NC = 2 + 1 = 3 = 3, NS = 1
     *   0  1  2  3  4  5  6
     * [ 5  4  6  7  8  9 10]
     *         -  -  -  - --
     * pivot = 5, NC = 1 + 1 = 2 = 2, NS = 1
     *   0  1  2  3  4  5  6
     * [ 4  5  6  7  8  9 10]
     *      -  -  -  -  - --  
     * NP = 6 = N - 1 ~ N                  N
     * NC = 7 + 6 + 5 + 4 + 3 + 2 = 27 = ( ∑ i ) - 1 = N (N + 1) / 2 - 1 ~ ½ N²
     * NS = 6 = N - 1 ~ N                 i=1
     */
    public static void main(final String[] arguments) {
        final double[] values = { 10, 4, 5, 6, 7, 8, 9 };

        out.println("values before sorting    = " + Arrays.toString(values));
        sort(values);

        out.println("Number of partitions: " + numberOfPartitions);
        out.println("Number of comparisons: " + numberOfComparisons);
        out.println("Number of swaps: " + numberOfSwaps);
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