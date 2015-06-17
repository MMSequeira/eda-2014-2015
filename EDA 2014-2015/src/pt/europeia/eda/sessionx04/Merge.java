package pt.europeia.eda.sessionx04;

import static java.lang.System.out;

import java.util.Arrays;

// Instrumented (and complete) version of the class in Question 5 of the
// 2014-06-03 10:00 exam:
public final class Merge {

    private Merge() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    private static int numberOfComparisons = 0;

    private static void merge(final double[] values, final double[] auxiliary,
            final int first, final int middle, final int last) {
        for (int i = first; i <= last; i++)
            auxiliary[i] = values[i];

        int i = first;
        int j = middle + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                values[k] = auxiliary[j];
                j++;
            } else if (j > last) {
                values[k] = auxiliary[i];
                i++;
            } else if (isLess(auxiliary[j], auxiliary[i])) {
                values[k] = auxiliary[j];
                j++;
            } else {
                values[k] = auxiliary[i];
                i++;
            }
    }

    private static void sort(final double[] values, final double[] auxiliary,
            final int first, final int last) {
        if (last <= first)
            return;

        final int middle = first + (last - first) / 2;

        sort(values, auxiliary, first, middle);
        sort(values, auxiliary, middle + 1, last);

        // These lines are the answer to Question 5 of the 2014-06-03 10:00
        // exam:
        if (!isLess(values[middle + 1], values[middle]))
            return;

        merge(values, auxiliary, first, middle, last);
    }

    public static void sort(final double[] values) {
        sort(values, new double[values.length], 0, values.length - 1);
    }

    private static boolean isLess(final double first, final double second) {
        numberOfComparisons++;
        return first < second;
    }

    /*
     * N = 8 = 2³ = 2ⁿ with n = lg N = 3 [1 2 3 4 5 6 7 8] / \ [1 2 3 4] [5 6 7
     * 8] / \ / \ [1 2] [3 4] [5 6] [7 8] / \ / \ / \ / \ [1] [2] [3] [4] [5]
     * [6] [7] [8] \C/ \C/ \C/ \C/ = 4 = 2² comparisons [1 2] [3 4] [5 6] [7 8]
     * \ C / \ C / = 2 = 2¹ comparisons [1 2 3 4] [5 6 7 8] \ C / = 2 = 2⁰
     * comparisons [1 2 3 4 5 6 7 8]
     * 
     * n-1 NC: 4 + 2 + 1 = ∑ 2ⁱ = 2ⁿ - 1 = N - 1 i=0
     */
    public static void main(final String[] arguments) {
        final double[] values = { 1, 2, 3, 4, 5, 6, 7, 8 };

        out.println("values before sorting = " + Arrays.toString(values));

        sort(values);

        out.println("values after sorting =  " + Arrays.toString(values));

        out.println("Number of comparisons: " + numberOfComparisons);
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