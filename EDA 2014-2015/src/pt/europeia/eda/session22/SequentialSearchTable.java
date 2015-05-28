package pt.europeia.eda.session22;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SequentialSearchTable<Key, Value> {
    
    private int size;
    private Node<Key, Value> first;

    private static class Node<Key, Value> {
        
        private final Key key;
        private Value value;
        private Node<Key, Value> next;

        public Node(final Key key, final Value value, final Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }

    public SequentialSearchTable() {
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

        final Queue<Key> queue = new Queue<Key>();
        
        for (Node<Key, Value> node = first; node != null; node = node.next)
            queue.enqueue(node.key);
        
        return queue;
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

    // Iterative version (see commented out recursive version below):
    public void delete(final Key key) {
        checkInvariant();

        if (isEmpty())
            return;

        if (key.equals(first.key)) {
            size--;
            first = first.next;
        } else if (first.next != null) {
            Node<Key, Value> node = first;
            while (node.next != null && !key.equals(node.next.key))
                node = node.next;
            if (node.next != null) {
                size--;
                node.next = node.next.next;
            }
        }

        checkInvariant();
    }

//    public void delete(final Key key) {
//        checkInvariant();
//
//        first = deleteFrom(first, key);
//
//        checkInvariant();
//    }
//
//    private Node<Key, Value> deleteFrom(final Node<Key, Value> node, final Key key) {
//        if (node == null)
//            return null;
//        
//        if (key.equals(node.key)) {
//            size--;
//            return node.next;
//        }
//        
//        node.next = deleteFrom(node.next, key);
//        
//        return node;
//    }
//
    private void checkInvariant() {
        assert isSizeConsistent() : "Table array capacities not consistent with size.";
        assert keysAreNonNull() : "Table contains null keys.";
        assert valuesAreNonNull() : "Table contains null values.";
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
    
    public static void main(final String[] arguments) {
        final SequentialSearchTable<String, Integer> table = new SequentialSearchTable<String, Integer>();
        
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