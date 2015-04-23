package pt.europeia.eda.session16;

import static java.lang.System.out;

public class MergeTester {

    public static void main(final String[] arguments) {
//        final Integer[] numbers = { 5, 1, 7, 3, 6, 2, 8, 4 };
        final Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };

        InstrumentedMerge.sort(numbers);

        out.println("Comparisons: "
                + InstrumentedMerge.getNumberOfComparisons());
        out.println("Array accesses: "
                + InstrumentedMerge.getNumberOfArrayAccesses());
    }

}
