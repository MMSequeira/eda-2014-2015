package pt.europeia.eda.exams.exam201406031000;

import static java.lang.System.out;

import java.util.Arrays;

public final class ArrayUtilities {

    private ArrayUtilities() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    // Naive answer to Question 11 of the 2014-06-03 10:00 exam:
    public static double[] naiveItemsInBothOf(final double[] firstValues,
            final double[] secondValues) {
        final double[] itemsInBoth = new double[Math.min(firstValues.length,
                secondValues.length)];

        int numberOfItemsInBoth = 0;
        for (double firstValue : firstValues)
            for (double secondValue : secondValues)
                if (firstValue == secondValue) {
                    itemsInBoth[numberOfItemsInBoth] = firstValue;
                    numberOfItemsInBoth++;
                }

        final double[] finalItemsInBoth = new double[numberOfItemsInBoth];
        for (int i = 0; i != numberOfItemsInBoth; i++)
            finalItemsInBoth[i] = itemsInBoth[i];

        return finalItemsInBoth;
    }

    // Less naive answer to Question 11 of the 2014-06-03 10:00 exam:
    public static double[] itemsInBothOf(final double[] originalFirstValues,
            final double[] originalSecondValues) {
        final double[] firstValues = originalFirstValues.clone();
        final double[] secondValues = originalSecondValues.clone();

        Quick.sort(firstValues);
        Quick.sort(secondValues);

        final double[] itemsInBoth = new double[Math.min(firstValues.length,
                secondValues.length)];

        int numberOfItemsInBoth = 0;
        for (int i = 0, j = 0; i != firstValues.length
                && j != secondValues.length;)
            if (firstValues[i] < secondValues[j])
                i++;
            else if (firstValues[i] > secondValues[j])
                j++;
            else {
                itemsInBoth[numberOfItemsInBoth] = firstValues[i];
                numberOfItemsInBoth++;
                i++;
                j++;
            }

        final double[] finalItemsInBoth = new double[numberOfItemsInBoth];
        for (int i = 0; i != numberOfItemsInBoth; i++)
            finalItemsInBoth[i] = itemsInBoth[i];

        return finalItemsInBoth;
    }

    public static void main(final String[] arguments) {
        final double[] firstValues = { 3.0, 2.0, 1.0, 4.0, 10.0, 5.0 };
        final double[] secondValues = { 5.0, 3.0, 4.0 };

        out.println("Items in both "
                + Arrays.toString(firstValues)
                + " and "
                + Arrays.toString(secondValues)
                + " are "
                + Arrays.toString(naiveItemsInBothOf(firstValues, secondValues)));

        out.println("Items in both "
                + Arrays.toString(firstValues)
                + " and "
                + Arrays.toString(secondValues)
                + " are "
                + Arrays.toString(itemsInBothOf(firstValues, secondValues)));
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