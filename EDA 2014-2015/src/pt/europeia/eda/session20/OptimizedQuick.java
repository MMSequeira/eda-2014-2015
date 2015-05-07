package pt.europeia.eda.session20;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public final class OptimizedQuick {

    private static final int cutoff = 8;

    private OptimizedQuick() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        sort(values, 0, values.length - 1);
        
        assert isIncreasing(values) : "Array should be increasing after sorting.";
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final int first, final int last) {
        final int length = last - first + 1;

        if (length <= cutoff) {
            insertionSort(values, first, last);
            return;
        } else if (length <= 40) {
            int positionOfMedian = positionOfMedianOf3(values, first, first
                    + length / 2, last);
            swap(values, positionOfMedian, first);
        } else {
            final int spacing = length / 8;
            final int middle = first + length / 2;
            final int positionOfMedian1 = positionOfMedianOf3(values, first,
                    first + spacing, first + spacing + spacing);
            final int positionOfMedian2 = positionOfMedianOf3(values, middle
                    - spacing, middle, middle + spacing);
            final int positionOfMedian3 = positionOfMedianOf3(values, last
                    - spacing - spacing, last - spacing, last);
            final int positionOfNinther = positionOfMedianOf3(values,
                    positionOfMedian1, positionOfMedian2, positionOfMedian3);
            swap(values, positionOfNinther, first);
        }

        int i = first;
        int j = last + 1;
        int p = first;
        int q = last + 1;
        
        while (true) {
            final Item pivot = values[first];
            do
                i++;
            while (isLess(values[i], pivot) && i != last);
            do
                j--;
            while (isLess(pivot, values[j]) && j != first);
            if (i >= j)
                break;
            swap(values, i, j);
            if (isEqual(values[i], pivot)) {
                p++;
                swap(values, p, i);
            }
            if (isEqual(values[j], pivot)) {
                q--;
                swap(values, q, j);
            }
        }
        swap(values, first, j);
        i = j + 1;
        j = j - 1;
        for (int k = first + 1; k <= p; k++) {
            swap(values, k, j);
            j--;
        }
        for (int k = last; k >= q; k--) {
            swap(values, k, i);
            i++;
        }
        sort(values, first, j);
        sort(values, i, last);
    }

    private static <Item extends Comparable<? super Item>> void insertionSort(
            final Item[] values, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            for (int j = i; j > first && isLess(values[j], values[j - 1]); j--)
                swap(values, j, j - 1);
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static <Value extends Comparable<? super Value>> boolean isEqual(
            final Value first, final Value second) {
        return first.compareTo(second) == 0;
    }

    private static void swap(final Object[] values, final int i, final int j) {
        final Object temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    private static <Item extends Comparable<? super Item>> int positionOfMedianOf3(
            final Item[] values, final int i, final int j, final int k) {
        if (isLess(values[i], values[j]))
            if (isLess(values[j], values[k]))
                return j;
            else if (isLess(values[i], values[k]))
                return k;
            else
                return i;
        else if (isLess(values[k], values[j]))
            return j;
        else if (isLess(values[k], values[i]))
            return k;
        else
            return i;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        return isIncreasing(values, 0, values.length - 1);
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] a, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            if (isLess(a[i], a[i - 1]))
                return false;
        return true;
    }

    private static void show(final Object[] values) {
        for (Object value : values) {
            StdOut.println(value);
        }
    }

    public static void main(final String[] arguments) {
        final In in = new In(arguments[0]);
        final String[] words = in.readAllStrings();
        OptimizedQuick.sort(words);
        show(words);
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