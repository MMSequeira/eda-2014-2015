package pt.europeia.eda.sessionx02.contract;

import java.util.Arrays;

// This version of the class includes assertions used to check operation
// postconditions and instance invariants.
public class SetOfInts {

    private static final int initialCapacity = 1;

    private int[] elements;
    private int numberOfElements;

    public SetOfInts() {
        elements = new int[initialCapacity];
        numberOfElements = 0;

        // The invariant of this new class instance is checked right after (or
        // rather, at the end of) construction:
        checkInvariant();
    }

    public boolean isEmpty() {
        // The invariant of this set is checked before (or rather, at the
        // beginning of) the execution of each non-modifying method:
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
        // The preconditions of the operation must be checked and an exception
        // must be thrown to signal their violation:
        if (anotherSet == null)
            throw new NullPointerException("anotherSet cannot be null.");

        checkInvariant();
        // The invariant of the other set is also checked here, though only
        // because the code below is not accessing it only though its public
        // interface:
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

        // These assertions check part of the postconditions of this operation.
        // Notice that violations of preconditions lead to run time exceptions
        // while the violation of postconditions lead to assertion failures and
        // the throwing of AssertionError. The former can be caught and dealt
        // with by the calling code, while the latter usually should not. Also
        // notice that assertion are not checked by default. You must enable
        // assertion checking by calling the Java virtual machine with the -ea
        // option.
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

        assert this.contains(intersection) :
            "Both sets must their intersection.";
        assert anotherSet.contains(intersection) :
            "Both sets must their intersection.";

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

        assert subtraction.intersectionWith(anotherSet).isEmpty() :
            "Subtraction has no common elements with subtracted set.";
        assert this.contains(subtraction) :
            "Original set must contain subtraction.";

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

        // The invariant of this set is checked after (or rather, at the
        // end of) the execution of each modifying method:
        checkInvariant();

        assert contains(newElement) :
            "After adding an element the set must contain it.";
    }

    public void remove(final int element) {
        checkInvariant();

        final int indexOfElement = indexOf(element);

        if (indexOfElement == numberOfElements)
            return;

        elements[indexOfElement] = elements[numberOfElements - 1];

        numberOfElements--;

        checkInvariant();

        assert !contains(element) :
            "After removing an element the set must not contain it.";
    }

    // A helper method used to check whether the set has repeated elements
    // (which it shouldn't):
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

    // The helper method that checks the invariant of this set instance. The
    // invariant usually consists of a conjunction of conditions, which are
    // usually separately asserted. This makes the errors thrown more specific
    // and informative. Remember that assertions are only checked if the Java
    // virtual machine if called with the -ea option:
    private void checkInvariant() {
        assert elements != null : "The elements reference cannot be null.";
        assert 0 <= numberOfElements : "Number of elements cannot be negative.";
        assert numberOfElements <= elements.length :
            "Number of elements must not be larger than the array capacity.";
        assert !hasRepeatedElements() :
            "The set cannot contain repeated elements.";
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