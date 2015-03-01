package pt.europeia.eda.piazza.week01;

public class IntArrays {

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
