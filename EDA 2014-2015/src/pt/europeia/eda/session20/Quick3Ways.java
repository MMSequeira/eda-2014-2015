package pt.europeia.eda.session20;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public final class Quick3Ways {

    private Quick3Ways() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        StdRandom.shuffle(values);

        sort(values, 0, values.length - 1);

        assert isIncreasing(values) : "Array should be increasing after sorting.";
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final int first, final int last) {
        if (last <= first)
            return; 

        int lowest = first;
        int greatest = last;
        
        int i = first + 1;
        
        final Item pivot = values[first];
        
        while (i <= greatest) { 
            final int comparison = values[i].compareTo(pivot);
            
            if (comparison < 0) {
                swap(values, lowest, i);
                lowest++;
                i++;
            } else if (comparison > 0) {
                swap(values, i, greatest); 
                greatest--;
            } else
                i++; 
        }

        sort(values, first, lowest - 1); 
        sort(values, greatest + 1, last); 

        assert isIncreasing(values, first, last) : "Array segment should be increasing after sorting.";
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static void swap(final Object[] values, final int i, final int j) {
        final Object temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
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
        for (Object value : values)
            StdOut.println(value);
    }

    public static void main(final String[] arguments) {
        final In in = new In(arguments[0]);
        final String[] words = in.readAllStrings();
        Quick3Ways.sort(words);
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