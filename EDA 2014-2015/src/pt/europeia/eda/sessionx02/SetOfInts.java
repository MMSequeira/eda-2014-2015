package pt.europeia.eda.sessionx02;

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

    public int[] getElements() {
        return Arrays.copyOf(elements, numberOfElements);
    }

    public boolean contains(final int value) {
        // if (indexOf(value) != numberOfElements)
        // return true;
        // else
        // return false;

        return indexOf(value) != numberOfElements;
    }

    public boolean contains(final SetOfInts anotherSet) {
        for (int i = 0; i != anotherSet.numberOfElements; i++)
            if (!contains(anotherSet.elements[i]))
                return false;
        return true;
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

        // if (i != numberOfElements - 1)
        elements[i] = elements[numberOfElements - 1];
        // for (; i < numberOfElements - 1; i++)
        // elements[i] = elements[i + 1];

        numberOfElements--;
    }

    public SetOfInts unionWith(final SetOfInts anotherSet) {
        final SetOfInts union = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            union.add(elements[i]);

        for (int i = 0; i != anotherSet.numberOfElements; i++)
            union.add(anotherSet.elements[i]);

        return union;
    }

    public SetOfInts intersectionWith(final SetOfInts anotherSet) {
        final SetOfInts intersection = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (anotherSet.contains(elements[i]))
                intersection.add(elements[i]);

        return intersection;
    }

    public SetOfInts minus(SetOfInts anotherSet) {
        final SetOfInts subtraction = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (!anotherSet.contains(elements[i]))
                subtraction.add(elements[i]);

        return subtraction;
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

        // A simple alternative to the above code would be the following:
        // elements = Arrays.copyOf(elements, newCapacity);
    }

    // Returns a string representation of the set, consisting of all its
    // elements, separated by commas, placed within brackets:
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