package pt.europeia.eda.piazza.week13;

import static pt.europeia.eda.piazza.week13.Utilities.isIncreasing;
import static pt.europeia.eda.piazza.week13.Utilities.isLess;

public final class MergeSort {

    private static final int cutoff = 7;

    private MergeSort() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        final Item[] auxiliary = values.clone();

        sort(auxiliary, values, 0, values.length - 1);

        assert isIncreasing(values) : "Array should be increasing after sorting.";
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] source, final Item[] destination, final int first,
            final int last) {
        if (last - first < cutoff) {
            InsertionSort.sort(destination, first, last);

            return;
        }

        final int middle = first + (last - first) / 2;

        sort(destination, source, first, middle);
        sort(destination, source, middle + 1, last);

        if (!isLess(source[middle + 1], source[middle])) {
            System.arraycopy(source, first, destination, first, last - first
                    + 1);

            return;
        }

        merge(source, destination, first, middle, last);
    }

    private static <Item extends Comparable<? super Item>> void merge(
            final Item[] source, final Item[] destination, final int first,
            final int middle, final int last) {
        assert isIncreasing(source, first, middle) : "Can only merge increasing segments.";
        assert isIncreasing(source, middle + 1, last) : "Can only merge increasing segments.";

        int i = first;
        int j = middle + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                destination[k] = source[j];
                j++;
            } else if (j > last) {
                destination[k] = source[i];
                i++;
            } else if (isLess(source[j], source[i])) {
                destination[k] = source[j];
                j++;
            } else {
                destination[k] = source[i];
                i++;
            }

        assert isIncreasing(destination, first, last) : "Merged segment should be increasing.";
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