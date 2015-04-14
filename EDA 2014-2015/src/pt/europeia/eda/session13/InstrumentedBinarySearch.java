package pt.europeia.eda.session13;

import static java.lang.System.out;

// Example of an instrumented binary search method counting the number of
// comparisons involving at least on array item (three-way comparisons are
// implemented as two chained two-way comparisons):
public class InstrumentedBinarySearch {

    // Instrumentation code:
    private static int numberOfTwoWayComparisons = 0;
    private static int numberOfThreeWayComparisons = 0;

    public static int binarySearch(final int[] values, final int key) {
        int first = 0;
        int last = values.length - 1;
        while (first <= last) {
            final int middle = first + (last - first) / 2;

            // Instrumentation code:
            numberOfThreeWayComparisons++;
            numberOfTwoWayComparisons++;

            if (key < values[middle])
                last = middle - 1;
            else {
                // Instrumentation code:
                numberOfTwoWayComparisons++;

                if (key > values[middle])
                    first = middle + 1;
                else
                    return middle;
            }
        }
        return -1;
    }

    // Instrumentation code:
    public static int getNumberOfTwoWayComparisons() {
        return numberOfTwoWayComparisons;
    }

    // Instrumentation code:
    public static int getNumberOfThreeWayComparisons() {
        return numberOfThreeWayComparisons;
    }

    public static void main(final String[] arguments) {
        final int length = 1 << 20; // 2²⁰ = 1024 x 1024
        final int[] numbers = new int[length];

        for (int i = 0; i != length; i++)
            numbers[i] = i;

        // Search for item in last position of an array containing 2²⁰ items
        // requires 20 + 1 three-way comparisons. All other items require 20
        // comparisons.
        final int position = binarySearch(numbers, length - 1);

        out.println("Length: " + length);
        out.println("Found at: " + position);
        out.println("Number of three-way comparisons: "
                + numberOfThreeWayComparisons);
        out.println("Number of one-way comparisons: "
                + numberOfTwoWayComparisons);

    }

}
