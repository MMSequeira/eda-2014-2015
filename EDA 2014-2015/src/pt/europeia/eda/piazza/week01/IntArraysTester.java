package pt.europeia.eda.piazza.week01;

import java.util.Arrays;

import static java.lang.System.out;
import static pt.europeia.eda.piazza.week01.IntArrays.*;

public class IntArraysTester {

    public static void main(final String[] arguments) {
        final int[] numbers = { 1, 2, 3, 4 };

        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));

        reverse(numbers);

        out.println("numbers is " + Arrays.toString(numbers));
        out.println("isNonDecreasing(numbers) is " + isNonDecreasing(numbers));
        out.println("isNonDecreasing(new int[] { 1, 1, 1 }) is "
                + isNonDecreasing(new int[] { 1, 1, 1 }));
        out.println("isNonDecreasing(new int[] { 1, 2, 1 }) is "
                + isNonDecreasing(new int[] { 1, 2, 1 }));

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
    }

}
