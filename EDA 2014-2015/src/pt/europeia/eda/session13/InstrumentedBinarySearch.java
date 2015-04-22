package pt.europeia.eda.session13;

import static java.lang.System.out;

// Example of an instrumented binary search method counting the number of
// comparisons involving at least on array item (three-way comparisons are
// implemented as two chained two-way comparisons):
public final class InstrumentedBinarySearch {
    
    private InstrumentedBinarySearch() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    // Instrumentation code:
    private static int numberOfTwoWayComparisons = 0;
    private static int numberOfThreeWayComparisons = 0;

    public static int binarySearch(final int[] values, final int key) {
        int first = 0;
        int last = values.length - 1;
        while (first <= last) {
            final int middle = first + (last - first) / 2;

            // Instrumentation code:
            numberOfThreeWayComparisons++;
            numberOfTwoWayComparisons++;

            if (key < values[middle])
                last = middle - 1;
            else {
                // Instrumentation code:
                numberOfTwoWayComparisons++;

                if (key > values[middle])
                    first = middle + 1;
                else
                    return middle;
            }
        }
        return -1;
    }

    // Instrumentation code:
    public static int getNumberOfTwoWayComparisons() {
        return numberOfTwoWayComparisons;
    }

    // Instrumentation code:
    public static int getNumberOfThreeWayComparisons() {
        return numberOfThreeWayComparisons;
    }

    public static void main(final String[] arguments) {
        final int length = 1 << 20; // 2²⁰ = 1024 x 1024
        final int[] numbers = new int[length];

        for (int i = 0; i != length; i++)
            numbers[i] = i;

        // Search for item in last position of an array containing 2²⁰ items
        // requires 20 + 1 three-way comparisons. All other items require 20
        // comparisons.
        final int position = binarySearch(numbers, length - 1);

        out.println("Length: " + length);
        out.println("Found at: " + position);
        out.println("Number of three-way comparisons: "
                + numberOfThreeWayComparisons);
        out.println("Number of one-way comparisons: "
                + numberOfTwoWayComparisons);

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