package pt.europeia.eda;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class TestArrayUtilities {

    // Running main() generates files akin to the ones distributed to the
    // students:
    public static void main(final String[] arguments) {
        generateTestFilesUpTo(1 << 3);
        // testInversionCounter();
        // testWorstCaseMergeIndicesGenerator();
    }

    // Returns the number of inversions in an array:
    public static <Item extends Comparable<? super Item>> int numberOfInversionsIn(
            final Item[] values) {
        final Item[] copyOfValues = values.clone();
        @SuppressWarnings("unchecked")
        final Item[] auxiliary = (Item[]) Array.newInstance(values.getClass()
                .getComponentType(), values.length);

        return sort(copyOfValues, auxiliary, 0, copyOfValues.length - 1);
    }

    // Shuffles the contents of an array (Knuth shuffle):
    public static void shuffle(final Object[] values) {
        for (int i = 0; i != values.length; i++) {
            final int r = generator.nextInt(i + 1);
            swap(values, i, r);
        }
    }

    // Partially shuffles and array until the number of inversions attains a
    // certain proportion of the array length (approximated by above):
    public static <Item extends Comparable<? super Item>> int partiallyShuffle(
            final Item[] values, final double desiredRatioOfInversions) {
        int desiredInversions = (int) Math.ceil(desiredRatioOfInversions
                * values.length);

        for (int inversion = 0; inversion != desiredInversions; inversion++) {
            int i;
            do
                i = generator.nextInt(values.length - 1);
            while (!isLess(values[i], values[i + 1]));

            swap(values, i, i + 1);
        }

        return numberOfInversionsIn(values);
    }

    // Generates an array of integers which are a worst case for the vanilla
    // merge sort (these integers may be used as indices to a sorted array of
    // any type to generate a new array of that type which is also a worst case
    // for merge sort):
    public static int[] worstCaseMergeIndices(final int size) {
        final int[] indices = new int[size];
        final int[] auxiliary = new int[size];

        for (int i = 0; i != size; i++)
            indices[i] = i;

        worstCaseMergeIndices(indices, auxiliary, 0, size - 1);

        return indices;
    }

    private static final Random generator = new Random(1234);

    // A small set of tests for the inversion counter:
    private static void testInversionCounter() {
        assert numberOfInversionsIn(new Double[] {}) == 0;
        assert numberOfInversionsIn(new Double[] { 0.0 }) == 0;
        assert numberOfInversionsIn(new Double[] { 0.0, 1.0 }) == 0;
        assert numberOfInversionsIn(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0,
            6.0, 7.0 }) == 0;
        assert numberOfInversionsIn(new Double[] { 1.0, 0.0 }) == 1;
        assert numberOfInversionsIn(new Double[] { -1.0, 6.0, 3.0, 4.0, 7.0,
            4.0 }) == 4;
        assert numberOfInversionsIn(new Double[] { 1.0, 20.0, 6.0, 4.0, 5. }) == 5;
        assert numberOfInversionsIn(new Double[] { 5.0, 4.0, 3.0, 2.0, 1.0 }) == 10;
    }

    //
    private static void testWorstCaseMergeIndicesGenerator() {
        assert Arrays.equals(worstCaseMergeIndices(0), new int[] {});
        assert Arrays.equals(worstCaseMergeIndices(8), new int[] { 0, 4, 2, 6,
            1, 5, 3, 7 });
        assert Arrays.equals(worstCaseMergeIndices(10), new int[] { 0, 8, 4, 2,
            6, 1, 9, 5, 3, 7 });
    }

    // Generates test files akin to the ones distributed to the students:
    private static void generateTestFilesUpTo(final int maximumSize) {
        for (int size = 2; size <= maximumSize; size *= 2) {
            final Double[] items = new Double[size];
            final Double[] sorted_items = new Double[size];

            for (int i = 0; i != size; i++)
                sorted_items[i] = items[i] = generator.nextDouble();

            Arrays.sort(sorted_items);

            final Double[] partially_sorted_items = new Double[size];

            for (int i = 0; i != size; i++)
                partially_sorted_items[i] = sorted_items[i];

            int inversions = partiallyShuffle(partially_sorted_items, 0.2);

            out.println("Length: " + size + ", Inversions: " + inversions
                    + " (" + inversions * 100.0 / size + "%%)\n");

            store(items, "shuffled");
            store(sorted_items, "sorted");
            store(partially_sorted_items, "partially_sorted");
        }
    }

    // Stores an array in an appropriately named file:
    private static void store(final Double[] items, final String orderType) {
        final String fileName = "data/" + orderType + "_" + items.length
                + ".txt";

        try {
            PrintStream file = new PrintStream(new FileOutputStream(fileName));
            for (int i = 0; i != items.length; i++)
                file.printf("%.16f\n", items[i]);

            file.close();
        } catch (final FileNotFoundException exception) {
            out.println("Could not write to file " + fileName + ".");
        }
    }

    // A version of merge sort that returns the number of inversions found (and
    // eliminated) while sorting:
    private static <Item extends Comparable<? super Item>> int sort(
            final Item[] values, final Item[] auxiliary, final int first,
            final int last) {
        if (first >= last)
            return 0;

        final int middle = first + (last - first) / 2;

        int numberOfInversions = sort(values, auxiliary, first, middle);
        numberOfInversions += sort(values, auxiliary, middle + 1, last);

        numberOfInversions += merge(values, auxiliary, first, middle, last);

        return numberOfInversions;
    }

    // A version of the merge algorithm that returns the number of inversions
    // found (and eliminated) while merging:
    private static <Item extends Comparable<? super Item>> int merge(
            final Item[] values, final Item[] auxiliary, final int first,
            final int middle, final int last) {
        int numberOfInversions = 0;

        int i = first;
        int j = middle + 1;
        int k = first;
        for (; i <= middle && j <= last; k++)
            if (!isLess(values[j], values[i])) {
                auxiliary[k] = values[i];
                i++;
            } else {
                auxiliary[k] = values[j];
                j++;
                numberOfInversions += middle - i + 1;
            }

        for (; i <= middle; k++, i++)
            auxiliary[k] = values[i];

        for (i = first; i < j; i++)
            values[i] = auxiliary[i];

        return numberOfInversions;
    }

    private static void worstCaseMergeIndices(final int[] indices,
            final int[] auxiliary, final int first, final int last) {
        if (last <= first)
            return;

        final int middle = first + (last - first) / 2;

        mergeWorstCaseMergeIndices(indices, auxiliary, first, middle, last);

        worstCaseMergeIndices(indices, auxiliary, first, middle);
        worstCaseMergeIndices(indices, auxiliary, middle + 1, last);
    }

    private static void mergeWorstCaseMergeIndices(final int[] indices,
            final int[] auxiliary, final int first, final int middle,
            final int last) {

        for (int i = first; i <= last; i++)
            auxiliary[i] = indices[i];

        int i = first;
        int j = middle + 1;
        final int firstSegmentSize = middle - first + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                indices[j] = auxiliary[k];
                j++;
            } else if (j > last) {
                indices[i] = auxiliary[k];
                i++;
            } else if (i + firstSegmentSize <= j) {
                indices[i] = auxiliary[k];
                i++;
            } else {
                indices[j] = auxiliary[k];
                j++;
            }
    }

    private static void swap(final Object[] values, final int firstPosition,
            final int secondPosition) {
        final Object temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

}

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * Copyright 2015, Robert Sedgewick and Kevin Wayne.
 * 
 * This file is in part a derivative work of the code which accompanies the
 * textbook
 * 
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 * 
 * Part of the code derives also from:
 * http://www.geeksforgeeks.org/counting-inversions/
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