package pt.europeia.eda.javaslides.presentation05;

import static java.lang.System.out;
import static pt.europeia.eda.javaslides.presentation05.IntArrayUtilities.maximumOf;
import static pt.europeia.eda.javaslides.presentation05.IntArrayUtilities.minimumOf;
import static pt.europeia.eda.javaslides.presentation05.IntArrayUtilities.sortedCopyOf;
import static pt.europeia.eda.javaslides.presentation05.IntArrayUtilities.thereAreDuplicatesIn;

public class IntArrayUtilitiesTester {

    public static void main(final String[] arguments) {
        final int[] numbers = { 9, 2, 6, 5, 8, 2 };

        out.println("Maximum of numbers is " + maximumOf(numbers));

        out.println("Minimum of numbers is " + minimumOf(numbers));

        final int[] sortedNumbers = sortedCopyOf(numbers);

        out.println("The sorted numbers are:");
        for (int number : sortedNumbers)
            out.println("\t" + number);

        if (thereAreDuplicatesIn(numbers))
            out.println("There are duplicate numbers.");
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