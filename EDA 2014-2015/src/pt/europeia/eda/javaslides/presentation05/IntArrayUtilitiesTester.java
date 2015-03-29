package pt.europeia.eda.javaslides.presentation05;

import static java.lang.System.out;
import static pt.europeia.eda.javaslides.presentation05.IntArrayUtilities.*;

public class IntArrayUtilitiesTester {

    public static void main(final String[] arguments) {
        final int[] numbers = {9, 2, 6, 5, 8, 2};

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