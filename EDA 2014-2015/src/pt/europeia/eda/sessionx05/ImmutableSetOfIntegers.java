package pt.europeia.eda.sessionx05;

import static java.lang.System.out;

import java.util.Arrays;

public class ImmutableSetOfIntegers {

    public final int[] elements;

    public ImmutableSetOfIntegers(final int[] elements) {
        // elements = elements.clone();
        this.elements = elements.clone();

        Arrays.sort(this.elements);

        // Notice < instead of !=. Original exam version had a bug.
        for (int i = 1; i < this.elements.length; i++)
            if (this.elements[i] == this.elements[i - 1])
                throw new IllegalArgumentException(
                        "Argument contains duplicate set elements.");
    }

    public boolean contains(final int element) {
        return rankOf(element) != -1;
    }

    public int rankOf(final int element) {
        int first = 0;
        int last = elements.length - 1;

        while (first <= last) {
            final int middle = first + (last - first) / 2;

            if (element < elements[middle])
                last = middle - 1;
            else if (element > elements[middle])
                first = middle + 1;
            else
                return middle;
        }

        return -1;
    }

    public int[] elements() {
        // return elements;
        return elements.clone();
    }

    public static void main(final String[] arguments) {
        final ImmutableSetOfIntegers empty = new ImmutableSetOfIntegers(
                new int[] {});
        int[] numbers = { 5, 4, 3, 2, 1 };
        final ImmutableSetOfIntegers set = new ImmutableSetOfIntegers(numbers);

        numbers = set.elements();

        numbers[2] = 1;
        // numbers[4] = 6;

        out.println(set.rankOf(1));
        out.println(set.rankOf(5));
        out.println(set.rankOf(6));
        out.println(Arrays.toString(set.elements()));
    }

}