package pt.europeia.eda.sessionx01;

import java.util.Arrays;

// Class representing a set of ints. A few thing are missing:
// 1. Pre-conditions are not being checked.
// 2. Set intersection and union are missing.
// 3. Perhaps this is not the most efficient way to implement a set, right?
public class SetOfInts {

    // A constant representing the initial capacity of the array that stores the
    // set elements. The smaller the initial capacity of the array, the less
    // memory is used, but also the more time is spent resizing the array:
    private static final int initialCapacity = 1;

    // The array containing the elements. The size of the array, which we here
    // call the "capacity" of this implementation of the set, may be larger than
    // the number of elements in the set. The first numberOfElements array items
    // correspond to the set elements. The rest of the items are just reserved
    // capacity:
    private int[] elements;
    private int numberOfElements;

    // A new set has 0 elements and a capacity given by the constant
    // initialCapacity:
    public SetOfInts() {
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    // The cardinality of a set is simply its number of elements:
    public int cardinality() {
        return numberOfElements;
    }

    // Returns the elements of the set as a (new) array of ints:
    public int[] getElements() {
        return Arrays.copyOf(elements, numberOfElements);
    }

    // Checks whether the set contains a given value:
    public boolean contains(final int value) {
        // Naive implementation:
        if (indexOf(value) != numberOfElements)
            return true;
        else
            return false;

        // Non-naive implementation:
        // return indexOf(value) != numberOfElements;
    }

    // Adds a new element to the set, changing nothing is it is already a member
    // of the set:
    public void add(final int newElement) {
        // Do nothing if the new element is already a member of the set:
        if (contains(newElement))
            return;

        // If the array capacity is exhausted, double its capacity (this makes
        // the set time efficient at the cost of some memory inefficiency):
        if (numberOfElements == elements.length)
            changeCapacityTo(elements.length * 2);

        // Add the new element after the existing elements:
        elements[numberOfElements] = newElement;

        // Increment the number of elements:
        numberOfElements++;
    }

    // Removes a given element from the set, changing nothing if it is not a
    // member of the set:
    public void remove(final int element) {
        // Obtain the index of the element in the array (or numberOfElements, if
        // it is not a member of the set):
        int i = indexOf(element);

        // If the element is not a member of the set, do nothing:
        if (i == numberOfElements)
            return;

        // Fill the gap of the removed element by copying each succeeding
        // element one position to the left in the array:
        for (; i < numberOfElements - 1; i++)
            elements[i] = elements[i + 1];

        // Decrement the number of elements:
        numberOfElements--;
    }

    // This auxiliary (hence private) function method returns the index of a
    // given element in the array, if the element is indeed a member of the
    // set, returning numberOfElements if it is not a member of the set:
    private int indexOf(final int element) {
        for (int i = 0; i != numberOfElements; i++)
            if (elements[i] == element)
                return i;
        return numberOfElements;
    }

    // Change the array capacity to the capacity given, which must be enough for
    // all the set elements (i.e., newCapacity must not be smaller than the
    // number of elements of the set):
    private void changeCapacityTo(final int newCapacity) {
        // Create a new array with the new capacity:
        final int[] newElements = new int[newCapacity];

        // Copy existing set elements to the new array:
        for (int i = 0; i != numberOfElements; i++)
            newElements[i] = elements[i];

        // Set the new array as the array of set elements:
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