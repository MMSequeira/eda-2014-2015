package pt.europeia.eda.session22;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.NoSuchElementException;

public class BinarySearchOrderedTable<Key extends Comparable<? super Key>, Value> {

    private static final int initialCapacity = 2;

    private Key[] keys;
    private Value[] values;
    private int size = 0;

    public BinarySearchOrderedTable() {
        this(initialCapacity);

        checkInvariant();
    }

    @SuppressWarnings("unchecked")
    public BinarySearchOrderedTable(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];

        checkInvariant();
    }

    public int size() {
        checkInvariant();

        return size;
    }

    public boolean isEmpty() {
        checkInvariant();

        return size() == 0;
    }

    public boolean contains(final Key key) {
        checkInvariant();

        return valueFor(key) != null;
    }

    public Value valueFor(final Key key) {
        checkInvariant();

        if (isEmpty())
            return null;

        final int rank = rankOf(key);

        if (rank < size && keys[rank].compareTo(key) == 0)
            return values[rank];

        return null;
    }

    public Iterable<Key> keys() {
        checkInvariant();

        return keysInRange(minimum(), maximum());
    }

    public void put(final Key key, final Value value) {
        checkInvariant();

        if (value == null) {
            delete(key);
            return;
        }

        final int rank = rankOf(key);

        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        if (size == keys.length)
            changeCapacityTo(2 * keys.length);

        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }

        keys[rank] = key;
        values[rank] = value;

        size++;

        checkInvariant();
    }

    public void delete(final Key key) {
        checkInvariant();

        if (isEmpty())
            return;

        final int rank = rankOf(key);

        if (rank == size || keys[rank].compareTo(key) != 0)
            return;

        for (int j = rank; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        size--;

        keys[size] = null;
        values[size] = null;

        if (size > 0 && size == keys.length / 4)
            changeCapacityTo(keys.length / 2);

        checkInvariant();
    }

    public int rankOf(final Key key) {
        int first = 0;
        int last = size - 1;

        while (first <= last) {
            final int middle = first + (last - first) / 2;

            final int comparison = key.compareTo(keys[middle]);

            if (comparison < 0)
                last = middle - 1;
            else if (comparison > 0)
                first = middle + 1;
            else
                return middle;
        }
        return first;
    }

    public Key minimum() {
        checkInvariant();

        if (isEmpty())
            return null;

        return keys[0];
    }

    public Key maximum() {
        checkInvariant();

        if (isEmpty())
            return null;

        return keys[size - 1];
    }

    public Key keyWithRank(final int rank) {
        if (rank < 0 || rank >= size)
            return null;

        return keys[rank];
    }

    public Key floorOf(final Key key) {
        checkInvariant();

        final int rank = rankOf(key);

        if (rank < size && key.compareTo(keys[rank]) == 0)
            return keys[rank];

        if (rank == 0)
            return null;
        else
            return keys[rank - 1];
    }

    public Key ceilingOf(final Key key) {
        checkInvariant();

        final int rank = rankOf(key);

        if (rank == size)
            return null;
        else
            return keys[rank];
    }

    public int sizeOfRange(final Key low, final Key high) {
        checkInvariant();

        if (low.compareTo(high) > 0)
            return 0;

        if (contains(high))
            return rankOf(high) - rankOf(low) + 1;
        else
            return rankOf(high) - rankOf(low);
    }

    public Iterable<Key> keysInRange(final Key low, final Key high) {
        checkInvariant();

        final Queue<Key> queue = new Queue<Key>();

        if (low == null && high == null)
            return queue;

        if (low == null)
            throw new IllegalArgumentException(
                    "Low and high keys must either both be null or both non-null");
        if (high == null)
            throw new IllegalArgumentException(
                    "Low and high keys must either both be null or both non-null");

        if (low.compareTo(high) > 0)
            return queue;

        for (int i = rankOf(low); i < rankOf(high); i++)
            queue.enqueue(keys[i]);

        if (contains(high))
            queue.enqueue(keys[rankOf(high)]);

        return queue;
    }

    public void deleteMinimum() {
        checkInvariant();

        if (isEmpty())
            throw new NoSuchElementException(
                    "Cannot delete minimum key-value from empty table");

        delete(minimum());

        checkInvariant();
    }

    public void deleteMaximum() {
        checkInvariant();

        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow error");

        delete(maximum());

        checkInvariant();
    }

    private void changeCapacityTo(final int newCapacity) {
        assert newCapacity >= size : "Cannot reduce capacity below table size.";

        @SuppressWarnings("unchecked")
        final Key[] newsKeys = (Key[]) new Comparable[newCapacity];
        @SuppressWarnings("unchecked")
        final Value[] newValues = (Value[]) new Object[newCapacity];

        for (int i = 0; i != size; i++) {
            newsKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        values = newValues;
        keys = newsKeys;
    }

    private void checkInvariant() {
        assert keys != null : "Table has a null reference to the values array.";
        assert values != null : "Table has a null reference to the values array.";
        assert isSizeConsistent() : "Table array capacities not consistent with size.";
        assert keysAreNonNull() : "Table contains null keys.";
        assert valuesAreNonNull() : "Table contains null values.";
        assert isIncreasing() : "Array of keys in table is not increasing.";
        assert isRankConsistent() : "Ranks of table are not consistent.";
    }

    private boolean isSizeConsistent() {
        return 0 <= size && size <= keys.length && keys.length == values.length;
    }

    private boolean keysAreNonNull() {
        for (int i = 0; i != size; i++)
            if (keys[i] == null)
                return false;
        return true;
    }

    private boolean valuesAreNonNull() {
        for (int i = 0; i != size; i++)
            if (values[i] == null)
                return false;
        return true;
    }

    private boolean isIncreasing() {
        for (int i = 1; i < size; i++)
            if (keys[i].compareTo(keys[i - 1]) < 0)
                return false;
        return true;
    }

    private boolean isRankConsistent() {
        for (int i = 0; i != size; i++)
            if (i != rankOf(keyWithRank(i)))
                return false;

        for (int i = 0; i != size; i++)
            if (keys[i].compareTo(keyWithRank(rankOf(keys[i]))) != 0)
                return false;

        return true;
    }

    public static void main(final String[] arguments) {
        final BinarySearchOrderedTable<String, Integer> table = new BinarySearchOrderedTable<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            final String word = StdIn.readString();
            table.put(word, i);
        }

        for (String word : table.keys())
            StdOut.println(word + " " + table.valueFor(word));
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