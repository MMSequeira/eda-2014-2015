package pt.europeia.eda.piazza.week01;

import static java.lang.System.out;

import java.util.Arrays;

public class IntArrays {

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

    public static void swap(final int[] numbers, final int i, final int j) {
        final int temporary = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temporary;
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
        final int[] fusion = new int[someNumbers.length + someOtherNumbers.length];
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
}
