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

    public boolean isEmpty() {
        checkInvariant();
        
        return cardinality() == 0;
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

        return indexOf(value) != numberOfElements;
    }

    public boolean contains(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        checkInvariant();
        anotherSet.checkInvariant();
        
        for (int i = 0; i != anotherSet.numberOfElements; i++)
            if (!contains(anotherSet.elements[i]))
                return false;
        return true;
    }

    public SetOfInts unionWith(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        checkInvariant();
        anotherSet.checkInvariant();

        final SetOfInts union = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            union.add(elements[i]);

        for (int i = 0; i != anotherSet.numberOfElements; i++)
            union.add(anotherSet.elements[i]);

        assert union.contains(this) : "Union must contain each set.";
        assert union.contains(anotherSet) : "Union must contain each set.";

        return union;
    }

    public static SetOfInts unionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.unionWith(anotherSet);
    }

    public SetOfInts intersectionWith(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        checkInvariant();
        anotherSet.checkInvariant();

        final SetOfInts intersection = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (anotherSet.contains(elements[i]))
                intersection.add(elements[i]);

        assert this.contains(intersection) : "Both sets must their intersection.";
        assert anotherSet.contains(intersection) : "Both sets must their intersection.";

        return intersection;
    }

    public static SetOfInts intersectionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.intersectionWith(anotherSet);
    }

    public SetOfInts minus(SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        checkInvariant();
        anotherSet.checkInvariant();

        final SetOfInts subtraction = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (!anotherSet.contains(elements[i]))
                subtraction.add(elements[i]);

        assert subtraction.intersectionWith(anotherSet).isEmpty() : "Subtraction has no common elements with subtracted set.";
        assert this.contains(subtraction) : "Original set must contain subtraction.";

        return subtraction;
    }

    public static SetOfInts subtractionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.minus(anotherSet);
    }

    public void add(final int newElement) {
        checkInvariant();

        if (contains(newElement))
            return;

        if (numberOfElements == elements.length)
            changeCapacityTo(elements.length * 2);

        elements[numberOfElements] = newElement;

        numberOfElements++;

        checkInvariant();

        assert contains(newElement) : "After adding an element the set must contain it.";
    }

    public void remove(final int element) {
        checkInvariant();

        int i = indexOf(element);

        if (i == numberOfElements)
            return;

        elements[i] = elements[numberOfElements - 1];

        numberOfElements--;

        checkInvariant();

        assert !contains(element) : "After removing an element the set must not contain it.";
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
        assert elements != null : "The elements reference cannot be null.";
        assert 0 <= numberOfElements : "Number of elements cannot be negative.";
        assert numberOfElements <= elements.length : "Number of elements must not be larger than the array capacity.";
        assert !hasRepeatedElements() : "The set cannot contain repeated elements.";
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