package pt.europeia.eda.session14;

public class Insertion {

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        for (int numberOfSortedItems = 1; numberOfSortedItems < values.length; numberOfSortedItems++)
            for (int i = numberOfSortedItems; i != 0
                    && isLess(values[i], values[i - 1]); i--)
                swap(values, i - 1, i);
        
        assert isIncreasing(values) : "Array should be increasing after sorting.";
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static <Item extends Comparable<? super Item>> void swap(
            final Item[] values, final int i, final int j) {
        final Item temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        for (int i = 1; i < values.length; i++)
            if (isLess(values[i], values[i - 1]))
                return false;
        return true;
    }

}