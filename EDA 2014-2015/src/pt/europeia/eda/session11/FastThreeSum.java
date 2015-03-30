package pt.europeia.eda.session11;

import static java.lang.System.out;
import static java.util.Arrays.sort;

import edu.princeton.cs.introcs.In;

public class FastThreeSum {

    public static int binarySearch(final int[] values, final int key) {
        int first = 0;
        int last = values.length - 1;
        while (first <= last) {
            final int middle = first + (last - first) / 2;
            if (key < values[middle])
                last = middle - 1;
            else if (key > values[middle])
                first = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    public static void printAll(final int[] numbers) {
        sort(numbers);
        for (int i = 0; i != numbers.length; i++)
            for (int j = i + 1; j != numbers.length; j++) {
                final int k = binarySearch(numbers, -(numbers[i] + numbers[j]));
                if (k > j)
                    out.println(numbers[i] + " " + numbers[j] + " "
                            + numbers[k]);
            }
    }

    public static int numberOfZeroSumTriplesIn(final int[] numbers) {
        sort(numbers);
        int numberOfZeroSumTrios = 0;
        for (int i = 0; i != numbers.length; i++)
            for (int j = i + 1; j != numbers.length; j++) {
                int k = binarySearch(numbers, -(numbers[i] + numbers[j]));
                if (k > j)
                    numberOfZeroSumTrios++;
            }
        return numberOfZeroSumTrios;
    }

    public static void main(final String[] arguments) {
        final In in = new In(arguments[0]);
        final int[] numbers = in.readAllInts();
        final Stopwatch stopwatch = new Stopwatch();
        final int numberOfTriples = numberOfZeroSumTriplesIn(numbers);
        out.println("Elapsed time = " + stopwatch.elapsedTime());
        out.println(numberOfTriples);
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