package pt.europeia.eda.sessionx02;

import java.util.Arrays;

// The array used to store the set elements currently only grows. When elements
// are removed, the array does not shrink as it probably should.
public class SetOfInts {

    private static final int initialCapacity = 1;

    private int[] elements;
    private int numberOfElements;

    public SetOfInts() {
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    public boolean isEmpty() {
        return cardinality() == 0;
    }

    public int cardinality() {
        return numberOfElements;
    }

    public int[] getElements() {
        return Arrays.copyOf(elements, numberOfElements);
    }

    public boolean contains(final int value) {
        return indexOf(value) != numberOfElements;
    }

    // This version of contains() checks whether this set contains another set,
    // instead of checking just a single element:
    public boolean contains(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        for (int i = 0; i != anotherSet.numberOfElements; i++)
            if (!contains(anotherSet.elements[i]))
                return false;
        return true;
    }

    // Returns a new set which is the union of this set to another set. Ideally,
    // both sets should be accessed only through its public interface. This
    // code should be improved when the class is equipped with iteration.
    public SetOfInts unionWith(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        final SetOfInts union = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            union.add(elements[i]);

        for (int i = 0; i != anotherSet.numberOfElements; i++)
            union.add(anotherSet.elements[i]);

        return union;
    }

    // Just a class version of the instance operation unionWith().
    public static SetOfInts unionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.unionWith(anotherSet);
    }

    // Returns a new set which is the intersection of this set to another set.
    // See comments for unionWith().
    public SetOfInts intersectionWith(final SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        final SetOfInts intersection = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (anotherSet.contains(elements[i]))
                intersection.add(elements[i]);

        return intersection;
    }

    // Just a class version of the instance operation intersectionWith().
    public static SetOfInts intersectionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.intersectionWith(anotherSet);
    }

    // Returns a new set which is the subtraction of another set from this set.
    // See comments for unionWith().
    public SetOfInts minus(SetOfInts anotherSet) {
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        final SetOfInts subtraction = new SetOfInts();

        for (int i = 0; i != numberOfElements; i++)
            if (!anotherSet.contains(elements[i]))
                subtraction.add(elements[i]);

        return subtraction;
    }

    // Just a class version of the instance operation minus().
    public static SetOfInts subtractionOf(final SetOfInts oneSet,
            final SetOfInts anotherSet) {
        return oneSet.minus(anotherSet);
    }

    public void add(final int newElement) {
        if (contains(newElement))
            return;

        if (numberOfElements == elements.length)
            changeCapacityTo(elements.length * 2);

        elements[numberOfElements] = newElement;

        numberOfElements++;
    }

    // This improved version of the code takes advantage of the fact that the
    // order of the elements in the set is not considered relevant.
    public void remove(final int element) {
        final int indexOfElement = indexOf(element);

        if (indexOfElement == numberOfElements)
            return;

        elements[indexOfElement] = elements[numberOfElements - 1];

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

        // A simple alternative to the above code would be the following:
        // elements = Arrays.copyOf(elements, newCapacity);
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