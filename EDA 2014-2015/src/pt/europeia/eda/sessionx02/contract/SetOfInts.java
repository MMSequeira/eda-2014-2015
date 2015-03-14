package pt.europeia.eda.sessionx02.contract;

import java.util.Arrays;

public class SetOfInts {

    private static final int initialCapacity = 1;

    private int[] elements;
    private int numberOfElements;

    public SetOfInts() {
        elements = new int[initialCapacity];
        numberOfElements = 0;

        checkInvariant();
    }

    public int cardinality() {
        checkInvariant();

        return numberOfElements;
    }

    public int[] getElements() {
        checkInvariant();

        return Arrays.copyOf(elements, numberOfElements);
    }

    public boolean contains(final int value) {
        checkInvariant();

        if (indexOf(value) != numberOfElements)
            return true;
        else
            return false;

        // Non-naive implementation:
        // return indexOf(value) != numberOfElements;
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

    public static SetOfInts unionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.unionWith(anotherSet);
    }

    public void add(final int newElement) {
        checkInvariant();

        if (contains(newElement))
            return;

        if (numberOfElements == elements.length)
            changeCapacityTo(elements.length * 2);

        elements[numberOfElements] = newElement;

        numberOfElements++;

        assert contains(newElement) : "After adding an element the set must contain it.";
        checkInvariant();
    }

    public void remove(final int element) {
        checkInvariant();

        int i = indexOf(element);

        if (i == numberOfElements)
            return;

        // for (; i < numberOfElements - 1; i++)
        // elements[i] = elements[i + 1];

        elements[i] = elements[numberOfElements - 1];

        numberOfElements--;

        assert !contains(element) : "After removing an element the set must not contain it.";
        checkInvariant();
    }

    private boolean hasRepeatedElements() {
        for (int i = 0; i < numberOfElements - 1; i++)
            for (int j = i + 1; j != numberOfElements; j++)
                if (elements[i] == elements[j])
                    return true;
        return false;
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

    private void checkInvariant() {
        assert elements != null : "The elements reference cannot be null";
        assert 0 <= numberOfElements : "Number of elements cannot be negative";
        assert numberOfElements <= elements.length : "Number of elements must not be larger than the array capacity";
        assert !hasRepeatedElements() : "The set cannot contain repeated elements";
    }

    @Override
    public String toString() {
        checkInvariant();

        String result = "{";
        for (int i = 0; i != numberOfElements; i++) {
            if (i != 0)
                result += ", ";
            result += elements[i];
        }
        return result + "}";
    }

}