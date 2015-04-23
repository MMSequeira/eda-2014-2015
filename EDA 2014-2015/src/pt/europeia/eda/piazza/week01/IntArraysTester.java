package pt.europeia.eda.piazza.week01;

import static java.lang.System.out;
import static pt.europeia.eda.piazza.week01.IntArrays.fusionOf;
import static pt.europeia.eda.piazza.week01.IntArrays.isNonDecreasing;
import static pt.europeia.eda.piazza.week01.IntArrays.maximumSpanBetweenEqualItemsOf;
import static pt.europeia.eda.piazza.week01.IntArrays.reverse;
import static pt.europeia.eda.piazza.week01.IntArrays.thereAreDuplicatesIn;

import java.util.Arrays;

public class IntArraysTester {

    public static void printCall(final String methodName, final int[] argument,
            final boolean result) {
        out.println(methodName + "(" + Arrays.toString(argument) + ") is "
                + result);
    }

    public static void printCall(final String methodName, final int[] argument,
            final int result) {
        out.println(methodName + "(" + Arrays.toString(argument) + ") is "
                + result);
    }

    public static void main(final String[] arguments) {
        int[] numbers = { 1, 2, 3, 4 };

        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));

        reverse(numbers);

        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));

        numbers = new int[] { 1, 1, 1 };
        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));

        numbers = new int[] { 1, 2, 1 };
        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));

        final int[] noNumbers = new int[] {};
        final int[] numbers1 = new int[] { 10, 13, 20, 24, 100 };
        final int[] numbers2 = new int[] { -1, 0, 10, 50 };

        out.println("noNumbers is " + Arrays.toString(noNumbers));
        out.println("numbers1 is " + Arrays.toString(numbers1));
        out.println("numbers2 is " + Arrays.toString(numbers2));

        out.println("fusionOf(noNumbers, noNumbers) is "
                + Arrays.toString(fusionOf(noNumbers, noNumbers)));
        out.println("fusionOf(numbers1, noNumbers) is "
                + Arrays.toString(fusionOf(numbers1, noNumbers)));
        out.println("fusionOf(noNumbers, numbers2) is "
                + Arrays.toString(fusionOf(noNumbers, numbers2)));
        out.println("fusionOf(numbers1, numbers2) is "
                + Arrays.toString(fusionOf(numbers1, numbers2)));

        numbers = new int[] { 1, 1, 1 };
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));
        numbers = new int[] { 1, 2, 1 };
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));
        numbers = new int[] { 1, 2, 3 };
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));
        numbers = new int[] { 1, 1 };
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));
        numbers = new int[] { 1 };
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));
        numbers = new int[] {};
        printCall("thereAreDuplicatesIn", numbers,
                thereAreDuplicatesIn(numbers));

        numbers = new int[] {};
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 3 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 2 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 3, 2, 3, 2 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 5, 1, 2, 5, 3, 2, 3, 2 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 3, 4, 5, 1, 7, 8, 9 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 2, 1, 4, 5, 6, 7, 8, 8 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
        numbers = new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 7 };
        printCall("maximumSpanBetweenEqualItemsOf", numbers,
                maximumSpanBetweenEqualItemsOf(numbers));
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