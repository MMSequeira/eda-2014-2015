package pt.europeia.eda.session14;

public class Selection {

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        for (int numberOfSortedItems = 0; numberOfSortedItems < values.length - 1; numberOfSortedItems++) {
            int indexOfMinimum = numberOfSortedItems;
            
            for (int i = indexOfMinimum + 1; i != values.length; i++)
                if (isLess(values[i], values[indexOfMinimum]))
                    indexOfMinimum = i;
            
            swap(values, numberOfSortedItems, indexOfMinimum);
        }
        
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