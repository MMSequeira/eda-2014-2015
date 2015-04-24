package pt.europeia.eda.piazza.week01;

public class IntArrays {

    public static void swap(final int[] numbers, final int firstPosition,
            final int secondPosition) {
        final int temporary = numbers[firstPosition];
        numbers[firstPosition] = numbers[secondPosition];
        numbers[secondPosition] = temporary;
    }

    public static void reverse(final int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--)
            swap(numbers, i, j);
    }

    public static boolean isNonDecreasing(final int[] numbers) {
        if (numbers.length == 0)
            return true;

        for (int i = 1; i != numbers.length; i++)
            if (numbers[i - 1] > numbers[i])
                return false;
        return true;
    }

    public static int[] fusionOf(final int[] someNumbers,
            final int[] someOtherNumbers) {
        final int[] fusion = new int[someNumbers.length
                + someOtherNumbers.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; i != someNumbers.length && j != someOtherNumbers.length; k++)
            if (someNumbers[i] < someOtherNumbers[j]) {
                fusion[k] = someNumbers[i];
                i++;
            } else {
                fusion[k] = someOtherNumbers[j];
                j++;
            }

        for (; i != someNumbers.length; i++, k++)
            fusion[k] = someNumbers[i];

        for (; j != someOtherNumbers.length; j++, k++)
            fusion[k] = someOtherNumbers[j];

        return fusion;
    }

    // Inefficient solution:
    public static boolean thereAreDuplicatesIn(final int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[i] == numbers[j])
                    return true;

        return false;
    }

    public static int maximumSpanBetweenEqualItemsOf(final int[] numbers) {
        int maximumSpan = 0;

        for (int i = 0; i + maximumSpan < numbers.length; i++)
            for (int j = i + maximumSpan; j < numbers.length; j++)
                if (numbers[i] == numbers[j] && maximumSpan < j - i + 1)
                    maximumSpan = j - i + 1;

        return maximumSpan;
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