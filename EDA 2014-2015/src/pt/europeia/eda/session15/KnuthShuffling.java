package pt.europeia.eda.session15;

import static java.lang.System.out;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdRandom;

public class KnuthShuffling {

    public static void shuffle(final Object[] values) {
        for (int i = 0; i != values.length; i++) {
            final int r = StdRandom.uniform(i + 1);
            swap(values, i, r);
        }
    }

    private static void swap(final Object[] values, final int firstPosition,
            final int secondPosition) {
        final Object temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    public static void main(final String[] arguments) {
        final int numberOfShuffles = 10;

        for (int n = 0; n != numberOfShuffles; n++) {
            final Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };

            shuffle(numbers);

            out.println(Arrays.toString(numbers));
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