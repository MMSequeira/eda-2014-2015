package pt.europeia.eda.piazza.week01;

import static java.lang.System.out;

import java.util.Arrays;

public class IntArrays {

    public static void main(final String[] arguments) {
        final int[] numbers = {1, 2, 3, 4};
        out.println(isNonDecreasing(numbers));
        reverse(numbers);
        out.println(Arrays.toString(numbers));
        out.println(isNonDecreasing(numbers));
        out.println(isNonDecreasing(new int[] {1, 1, 1}));
        out.println(isNonDecreasing(new int[] {1, 2, 1}));
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
    
}
