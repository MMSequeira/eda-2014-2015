package pt.europeia.eda.session16;

import java.lang.reflect.Array;

public final class Merge {

    private Merge() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        @SuppressWarnings("unchecked")
        final Item[] auxiliary = (Item[]) Array.newInstance(values.getClass()
                .getComponentType(), values.length);

        sort(values, auxiliary, 0, values.length - 1);
        
        assert isIncreasing(values);
    }

    private static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final Item[] auxiliary, final int first,
            final int last) {
        if (last <= first)
            return;

        final int middle = first + (last - first) / 2;

        sort(values, auxiliary, first, middle);
        sort(values, auxiliary, middle + 1, last);
        
        merge(values, auxiliary, first, middle, last);
    }

    private static <Item extends Comparable<? super Item>> void merge(
            final Item[] values, final Item[] auxiliary, final int first,
            final int middle, final int last) {
        assert isIncreasing(values, first, middle);
        assert isIncreasing(values, middle + 1, last);

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

        assert isIncreasing(values, first, last);
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        for (int i = 1; i < values.length; i++)
            if (isLess(values[i], values[i - 1]))
                return false;
        
        return true;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            if (isLess(values[i], values[i - 1]))
                return false;

        return true;
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