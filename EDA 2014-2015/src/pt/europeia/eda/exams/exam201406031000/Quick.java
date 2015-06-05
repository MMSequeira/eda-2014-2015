package pt.europeia.eda.exams.exam201406031000;

import static java.lang.System.out;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Arrays;

public class Quick {

    public static void sort(final double[] values) {
        // This line is the answer to Question 6 of the 2014-06-03 10:00 exam:
        StdRandom.shuffle(values);
        
        sort(values, 0, values.length - 1);
    }

    private static void sort(final double[] values, final int first,
            final int last) {
        if (last <= first)
            return;

        final int j = partition(values, first, last);

        sort(values, first, j - 1);
        sort(values, j + 1, last);
    }

    private static int partition(final double[] values, final int first,
            final int last) {
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