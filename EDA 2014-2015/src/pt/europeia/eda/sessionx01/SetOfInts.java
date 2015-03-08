package pt.europeia.eda.sessionx01;

import java.util.Arrays;

public class SetOfInts {

    private static final int initialCapacity = 1;
    private int[] elements;
    private int numberOfElements;

    public SetOfInts() {
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    public int cardinality() {
        return numberOfElements;
    }

    public int[] getItems() {
        return Arrays.copyOf(elements, numberOfElements);
    }

    public boolean contains(final int element) {
        return indexOf(element) != numberOfElements;
        // if (indexOf(element) != numberOfElements)
        // return true;
        // else
        // return false;
    }

    public void add(final int newElement) {
        if (contains(newElement))
            return;

        if (numberOfElements == elements.length)
            changeCapacityTo(elements.length * 2);

        elements[numberOfElements] = newElement;
        numberOfElements++;
    }

    public void remove(final int element) {
        int i = indexOf(element);

        if (i == numberOfElements)
            return;

        for (; i < numberOfElements - 1; i++)
            elements[i] = elements[i + 1];

        numberOfElements--;
    }

    private int indexOf(final int element) {
        for (int i = 0; i != numberOfElements; i++)
            if (elements[i] == element)
                return i;
        return numberOfElements;
    }

    private void changeCapacityTo(final int newCapacity) {
        final int[] newElements = new int[newCapacity];

        for (int i = 0; i != numberOfElements; i++)
            newElements[i] = elements[i];

        elements = newElements;
    }

    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i != numberOfElements; i++) {
            if (i != 0)
                result += ", ";
            result += elements[i];
        }
        return result + "}";
    }

}
