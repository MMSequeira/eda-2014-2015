package pt.europeia.eda.piazza.week13;

import static pt.europeia.eda.piazza.week13.Utilities.isIncreasing;
import static pt.europeia.eda.piazza.week13.Utilities.isLess;
import static pt.europeia.eda.piazza.week13.Utilities.swap;

public final class InsertionSort {

    private InsertionSort() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        for (int i = 1; i < values.length; i++)
            for (int j = i; j != 0 && isLess(values[j], values[j - 1]); j--)
                swap(values, j - 1, j);

        assert isIncreasing(values) : "Array should be increasing after sorting.";
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values, final int first, final int last) {
        for (int i = first + 1; i <= last; i++)
            for (int j = i; j != first && isLess(values[j], values[j - 1]); j--)
                swap(values, j, j - 1);
        
        assert isIncreasing(values, first, last) : "Array segment should be increasing after sorting.";
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