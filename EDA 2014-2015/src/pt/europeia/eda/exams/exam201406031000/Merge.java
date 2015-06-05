package pt.europeia.eda.exams.exam201406031000;

import static java.lang.System.out;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Arrays;

public final class Merge {

    private Merge() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static void sort(final double[] values) {
        sort(values, new double[values.length], 0, values.length - 1);
    }

    private static void sort(final double[] values, final double[] auxiliary,
            final int first, final int last) {
        if (last <= first)
            return;

        final int middle = first + (last - first) / 2;

        sort(values, auxiliary, first, middle);
        sort(values, auxiliary, middle + 1, last);

        // This line is the answer to Question 5 of the 2014-06-03 10:00 exam:
        if (isLess(values[middle + 1], values[middle]))
            merge(values, auxiliary, first, middle, last);
    }

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

    private static boolean isLess(final double firstValue,
            final double secondValue) {
        return firstValue < secondValue;
    }

    public static void main(final String[] arguments) {
        final int numberOfTests = 100;

        for (int size = 1; size != 1 << 18; size *= 2) {
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