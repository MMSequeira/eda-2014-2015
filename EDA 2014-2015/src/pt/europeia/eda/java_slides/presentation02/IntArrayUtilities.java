package pt.europeia.eda.java_slides.presentation02;

import java.util.Arrays;

public final class IntArrayUtilities {

    private IntArrayUtilities() {
        throw new RuntimeException("Attempt to instantiate " + 
                                   "package-class");
    }

    public static int maximumOf(final int[] array) {
        int maximum = array[0];

        for (int i = 1; i != array.length; i++)
            if (maximum < array[i])
                maximum = array[i];

        return maximum;
    }

    public static int minimumOf(final int[] array) {
        int minimum = array[0];

        for (int i = 1; i != array.length; i++)
            if (array[i] < minimum)
                minimum = array[i];

        return minimum;
    }

    public static int[] sortedCopyOf(final int[] array) {
        final int[] copyOfArray = array.clone();
        Arrays.sort(copyOfArray);
        return copyOfArray;
    }

    public static boolean thereAreDuplicatesIn(final int[] array) {
        final int[] sortedArray = sortedCopyOf(array);
        
        if (sortedArray.length < 2)
            return false;
        
        for (int i = 0; i != sortedArray.length - 1; i++)
            if (sortedArray[i] == sortedArray[i + 1])
                return true;
        
        return false;
    }

    // TODO Add more utilities.
}
