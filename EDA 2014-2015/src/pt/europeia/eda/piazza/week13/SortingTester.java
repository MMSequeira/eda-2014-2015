package pt.europeia.eda.piazza.week13;

import static java.lang.System.out;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Arrays;

public class SortingTester {

    public static void test(final Sorter sorter) {
        out.println("Testing " + sorter.name + ":");
        
        final int size = 1 << 4;
        
        final Integer[] values = new Integer[size];
        for (int i = 0; i != size; i++)
            values[i] = i;
        StdRandom.shuffle(values);
        
        out.println("\tBefore: " + Arrays.toString(values));
        
        sorter.sort(values);
        
        out.println("\tAfter:  " + Arrays.toString(values));
    }

    public static void main(final String[] arguments) {
        final Sorter[] sorters = {
            new Sorter((values) -> QuickSort.sort(values), "Quicksort"),
            new Sorter((values) -> MergeSort.sort(values), "Merge sort"),
            new Sorter((values) -> InsertionSort.sort(values), "Insertion sort") };

        for (Sorter sorter : sorters)
            test(sorter);
    }

    private static class Sorter {

        private final Sort<Integer> sort;
        private final String name;

        public Sorter(final Sort<Integer> sort, final String name) {
            this.sort = sort;
            this.name = name;
        }

        public void sort(final Integer[] values) {
            sort.sort(values);
        }

    }

}
