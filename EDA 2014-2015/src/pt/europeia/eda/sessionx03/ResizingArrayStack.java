package pt.europeia.eda.sessionx03;

import static java.lang.System.nanoTime;
import static java.lang.System.out;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private static final int initialCapacity = 1;
    private static final int capacityGrowthFactor = 2;

    private Item[] items;
    private int size;
    private int numberOfChanges;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        items = (Item[]) new Object[initialCapacity];
        size = 0;
        numberOfChanges = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(final Item item) {
        if (size == items.length)
            changeCapacityTo(items.length * capacityGrowthFactor);

        items[size] = item;

        size++;

        numberOfChanges++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow.");

        size--;

        final Item item = items[size];

        items[size] = null;

        if (size == items.length
                / (capacityGrowthFactor * capacityGrowthFactor))
            changeCapacityTo(items.length / capacityGrowthFactor);

        numberOfChanges++;

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int current = size;
        private int initialNumberOfChanges = numberOfChanges;

        @Override
        public boolean hasNext() {
            if (numberOfChanges != initialNumberOfChanges)
                throw new ConcurrentModificationException(
                        "Stack changed while iterating.");

            return current > 0;
        }

        @Override
        public Item next() {
            if (numberOfChanges != initialNumberOfChanges)
                throw new ConcurrentModificationException(
                        "Stack changed while iterating.");

            if (!hasNext())
                throw new NoSuchElementException("No item to iterate over.");

            current--;

            return items[current];
        }

    }

    private void changeCapacityTo(final int newCapacity) {
        assert newCapacity >= size : "New capacity insufficient for existing items.";

        @SuppressWarnings("unchecked")
        final Item[] newItems = (Item[]) new Object[newCapacity];

        for (int i = 0; i != size; i++)
            newItems[i] = items[i];

        items = newItems;
    }

    public static void main(final String[] arguments) {
        final ResizingArrayStack<Double> numbers = new ResizingArrayStack<Double>();

        final long numberOfPushes = 8388609; // 2^23 + 1

        out.println("Pushing " + numberOfPushes + " items to stack:");

        final long initialTime = nanoTime();

        for (int i = 0; i != numberOfPushes; i++)
            numbers.push(0.0);

        final long finalTime = nanoTime();

        final double time = (finalTime - initialTime) / 1000000000.0;

        out.println("\tExecution time: " + time + " s.");
        out.println("\tAverage execution time per push: "
                + (time / numberOfPushes) + " s.");
    }

}

/*
 * Copyright 2015, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015, Manuel Menezes de Sequeira.
 *
 * This file is a derivative work of the code which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 *
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */
