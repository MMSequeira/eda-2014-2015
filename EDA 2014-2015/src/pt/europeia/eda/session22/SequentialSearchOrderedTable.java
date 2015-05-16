package pt.europeia.eda.session22;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SequentialSearchOrderedTable<Key extends Comparable<? super Key>, Value> {

    private int size;
    private Node<Key, Value> first;

    private static class Node<Key extends Comparable<? super Key>, Value> {

        private final Key key;
        private Value value;
        private Node<Key, Value> next;

        public Node(final Key key, final Value value,
                final Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public SequentialSearchOrderedTable() {
        size = 0;
        first = null;

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

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (key.equals(node.key))
                return node.value;

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

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }

        first = new Node<Key, Value>(key, value, first);

        size++;

        checkInvariant();
    }

    public void delete(final Key key) {
        checkInvariant();

        first = deleteFrom(first, key);

        checkInvariant();
    }

    public int rankOf(final Key key) {
        int rank = 0;
        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key.compareTo(key) < 0)
                rank++;

        return rank;
    }

    public Key minimum() {
        checkInvariant();

        if (isEmpty())
            return null;

        Key minimumKey = first.key;

        for (Node<Key, Value> node = first.next; node != null; node = node.next)
            if (node.key.compareTo(minimumKey) < 0)
                minimumKey = node.key;

        return minimumKey;
    }

    public Key maximum() {
        checkInvariant();

        if (isEmpty())
            return null;

        Key maximumKey = first.key;

        for (Node<Key, Value> node = first.next; node != null; node = node.next)
            if (node.key.compareTo(maximumKey) > 0)
                maximumKey = node.key;

        return maximumKey;
    }

    public Key keyWithRank(final int rank) {
        if (rank < 0 || rank >= size)
            return null;

        return Quick.select(keysArray(), rank);
    }

    public Key floorOf(final Key key) {
        checkInvariant();

        Key floor = null;

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key.compareTo(key) <= 0
                    && (floor == null || node.key.compareTo(floor) > 0))
                floor = node.key;

        return floor;
    }

    public Key ceilingOf(final Key key) {
        checkInvariant();

        Key ceiling = null;

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key.compareTo(key) >= 0
                    && (ceiling == null || node.key.compareTo(ceiling) < 0))
                ceiling = node.key;

        return ceiling;
    }

    public int sizeOfRange(final Key low, final Key high) {
        checkInvariant();

        int sizeOfRange = 0;

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key.compareTo(low) >= 0 && node.key.compareTo(high) <= 0)
                sizeOfRange++;

        return sizeOfRange;
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

        final Key[] keys = keysArray();

        Quick.sort(keys);

        for (Key key : keys)
            if (key.compareTo(low) >= 0 && key.compareTo(high) <= 0)
                queue.enqueue(key);

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

    private Node<Key, Value> deleteFrom(final Node<Key, Value> node, final Key key) {
        if (node == null)
            return null;

        if (key.equals(node.key)) {
            size--;
            return node.next;
        }

        node.next = deleteFrom(node.next, key);

        return node;
    }

    private Key[] keysArray() {
        @SuppressWarnings("unchecked")
        final Key[] keys = (Key[]) new Comparable[size];

        int i = 0;
        for (Node<Key, Value> node = first; node != null; node = node.next) {
            keys[i] = node.key;
            i++;
        }

        return keys;
    }

    private void checkInvariant() {
        assert isSizeConsistent() : "Table array capacities not consistent with size.";
        assert keysAreNonNull() : "Table contains null keys.";
        assert valuesAreNonNull() : "Table contains null values.";
        assert isRankConsistent() : "Ranks of table are not consistent.";
    }

    private boolean isSizeConsistent() {
        int numberOfNodes = 0;
        for (Node<Key, Value> node = first; node != null; node = node.next)
            numberOfNodes++;

        return numberOfNodes == size;
    }

    private boolean keysAreNonNull() {
        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key == null)
                return false;
        return true;
    }

    private boolean valuesAreNonNull() {
        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.value == null)
                return false;
        return true;
    }

    private boolean isRankConsistent() {
        for (int i = 0; i != size; i++)
            if (i != rankOf(keyWithRank(i)))
                return false;

        for (Node<Key, Value> node = first; node != null; node = node.next)
            if (node.key.compareTo(keyWithRank(rankOf(node.key))) != 0)
                return false;

        return true;
    }

    public static void main(final String[] arguments) {
        final SequentialSearchOrderedTable<String, Integer> table = new SequentialSearchOrderedTable<String, Integer>();

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