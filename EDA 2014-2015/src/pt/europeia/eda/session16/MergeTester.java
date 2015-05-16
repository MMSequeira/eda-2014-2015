package pt.europeia.eda.session16;

import static java.lang.System.out;

public class MergeTester {

    public static void main(final String[] arguments) {
//        final Integer[] numbers = { 5, 1, 7, 3, 6, 2, 8, 4 };
        final Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };

        InstrumentedMerge.sort(numbers);

        out.println("Comparisons: "
                + InstrumentedMerge.getNumberOfComparisons());
        out.println("Array accesses: "
                + InstrumentedMerge.getNumberOfArrayAccesses());
    }

}

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
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
 */