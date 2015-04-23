package pt.europeia.eda.session17;

import java.util.Comparator;

public final class OptimizedMerge {

    private static final int cutoff = 7;

    private OptimizedMerge() {
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
            insertionSort(destination, first, last);

            return;
        }

        final int middle = first + (last - first) / 2;

        sort(destination, source, first, middle);
        sort(destination, source, middle + 1, last);

        if (!isLess(source[middle + 1], source[middle])) {
            // for (int i = first; i <= last; i++)
            // destination[i] = source[i];
            // using System.arraycopy() is a bit faster than the above loop
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

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        return isIncreasing(values, 0, values.length - 1);
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            if (isLess(values[i], values[i - 1]))
                return false;
        
        return true;
    }

    public static <Item> void sort(final Item[] values,
            final Comparator<? super Item> comparator) {
        final Item[] auxiliary = values.clone();

        sort(auxiliary, values, 0, values.length - 1, comparator);

        assert isIncreasing(values, comparator) : "Array should be increasing after sorting.";
    }

    private static <Item> void sort(final Item[] source,
            final Item[] destination, final int first, final int last,
            final Comparator<? super Item> comparator) {
        if (last - first < cutoff) {
            insertionSort(destination, first, last, comparator);

            return;
        }
        
        final int middle = first + (last - first) / 2;

        sort(destination, source, first, middle, comparator);
        sort(destination, source, middle + 1, last, comparator);

        if (!isLess(source[middle + 1], source[middle], comparator)) {
            System.arraycopy(source, first, destination, first, last - first
                    + 1);

            return;
        }

        merge(source, destination, first, middle, last, comparator);
    }

    private static <Item> void merge(final Item[] source,
            final Item[] destination, final int first, final int middle,
            final int last, final Comparator<? super Item> comparator) {

        assert isIncreasing(source, first, middle, comparator) : "Can only merge increasing segments.";
        assert isIncreasing(source, middle + 1, last, comparator) : "Can only merge increasing segments.";

        int i = first;
        int j = middle + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                destination[k] = source[j];
                j++;
            } else if (j > last) {
                destination[k] = source[i];
                i++;
            } else if (isLess(source[j], source[i], comparator)) {
                destination[k] = source[j];
                j++;
            } else {
                destination[k] = source[i];
                i++;
            }

        assert isIncreasing(destination, first, last, comparator) : "Merged segment should be increasing.";
    }

    private static <Item> void insertionSort(final Item[] values,
            final int first, final int last,
            final Comparator<? super Item> comparator) {
        for (int i = first + 1; i <= last; i++)
            for (int j = i; j > first
                    && isLess(values[j], values[j - 1], comparator); j--)
                swap(values, j, j - 1);
    }

    private static <Value> boolean isLess(final Value first,
            final Value second, final Comparator<? super Value> comparator) {
        return comparator.compare(first, second) < 0;
    }

    private static <Item> boolean isIncreasing(final Item[] values,
            final Comparator<? super Item> comparator) {
        return isIncreasing(values, 0, values.length - 1, comparator);
    }

    private static <Item> boolean isIncreasing(final Item[] values,
            final int first, final int last,
            final Comparator<? super Item> comparator) {
        for (int i = first + 1; i <= last; i++)
            if (isLess(values[i], values[i - 1], comparator))
                return false;
        
        return true;
    }

    private static void swap(final Object[] values, final int firstPosition,
            final int secondPosition) {
        final Object temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
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