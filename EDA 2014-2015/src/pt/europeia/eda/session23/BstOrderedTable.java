package pt.europeia.eda.session23;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.NoSuchElementException;

public class BstOrderedTable<Key extends Comparable<? super Key>, Value> {

    private Node<Key, Value> root;

    private static class Node<Key, Value> {

        private final Key key;
        private Value value;
        private Node<Key, Value> left = null;
        private Node<Key, Value> right = null;
        private int size = 1;

        public Node(final Key key, final Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public BstOrderedTable() {
        root = null;

        checkInvariant();
    }

    public int size() {
        checkInvariant();

        return sizeOf(root);
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

        return valueFor(key, root);
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

        root = putIn(key, value, root);

        checkInvariant();
    }

    public void delete(final Key key) {
        checkInvariant();

        root = deleteFrom(key, root);

        checkInvariant();
    }

    public int rankOf(final Key key) {
        checkInvariant();

        return rankOf(key, root);
    }

    public Key minimum() {
        checkInvariant();

        if (isEmpty())
            return null;

        return minimumNodeOf(root).key;
    }

    public Key maximum() {
        checkInvariant();

        if (isEmpty())
            return null;

        return maximumNodeOf(root).key;
    }

    public Key keyWithRank(final int rank) {
        checkInvariant();

        if (rank < 0 || rank >= size())
            return null;

        final Node<Key, Value> nodeWithRank = nodeWithRankIn(rank, root);

        return nodeWithRank.key;
    }

    public Key floorOf(final Key key) {
        checkInvariant();

        final Node<Key, Value> floorNode = floorNodeOf(key, root);

        if (floorNode == null)
            return null;

        return floorNode.key;
    }

    public Key ceilingOf(final Key key) {
        checkInvariant();

        Node<Key, Value> ceilingNode = ceilingNodeOf(key, root);

        if (ceilingNode == null)
            return null;

        return ceilingNode.key;
    }

    public int sizeOfRange(final Key low, final Key high) {
        checkInvariant();

        if (low.compareTo(high) > 0)
            return 0;

        if (contains(high))
            return rankOf(high) - rankOf(low) + 1;

        return rankOf(high) - rankOf(low);
    }

    public Iterable<Key> keysInRange(final Key low, final Key high) {
        checkInvariant();

        Queue<Key> keys = new Queue<Key>();

        enqueueKeysInRange(keys, low, high, root);

        return keys;
    }

    public int height() {
        checkInvariant();

        return heightOf(root);
    }

    public Iterable<Key> keysInLevelOrder() {
        checkInvariant();

        Queue<Key> keys = new Queue<Key>();

        Queue<Node<Key, Value>> nodes = new Queue<Node<Key, Value>>();

        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            final Node<Key, Value> node = nodes.dequeue();

            if (node == null)
                continue;

            keys.enqueue(node.key);

            nodes.enqueue(node.left);
            nodes.enqueue(node.right);
        }
        return keys;
    }

    public void deleteMinimum() {
        checkInvariant();

        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");

        root = deleteMinimumOf(root);

        checkInvariant();
    }

    public void deleteMaximum() {
        checkInvariant();

        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");

        root = deleteMaximumOf(root);

        checkInvariant();
    }

    private int sizeOf(final Node<Key, Value> tree) {
        if (tree == null)
            return 0;

        return tree.size;
    }

    private Value valueFor(final Key key, final Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);
        
        if (comparison < 0)
            return valueFor(key, tree.left);
        if (comparison > 0)
            return valueFor(key, tree.right);
        
        return tree.value;
    }

    private Node<Key, Value> putIn(final Key key, final Value value,
            final Node<Key, Value> tree) {
        if (tree == null)
            return new Node<Key, Value>(key, value);

        final int comparison = key.compareTo(tree.key);
        
        if (comparison < 0)
            tree.left = putIn(key, value, tree.left);
        else if (comparison > 0)
            tree.right = putIn(key, value, tree.right);
        else
            tree.value = value;

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private Node<Key, Value> deleteFrom(final Key key, Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);
        
        if (comparison < 0)
            tree.left = deleteFrom(key, tree.left);
        else if (comparison > 0)
            tree.right = deleteFrom(key, tree.right);
        else {
            if (tree.right == null)
                return tree.left;
            if (tree.left == null)
                return tree.right;

            final Node<Key, Value> originalTree = tree;

            tree = minimumNodeOf(originalTree.right);
            tree.right = deleteMinimumOf(originalTree.right);
            tree.left = originalTree.left;
        }

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private int rankOf(final Key key, final Node<Key, Value> tree) {
        if (tree == null)
            return 0;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            return rankOf(key, tree.left);

        if (comparison > 0)
            return 1 + sizeOf(tree.left) + rankOf(key, tree.right);

        return sizeOf(tree.left);
    }

    private Node<Key, Value> minimumNodeOf(final Node<Key, Value> tree) {
        if (tree.left == null)
            return tree;

        return minimumNodeOf(tree.left);
    }

    private Node<Key, Value> maximumNodeOf(final Node<Key, Value> tree) {
        if (tree.right == null)
            return tree;

        return maximumNodeOf(tree.right);
    }

    private Node<Key, Value> nodeWithRankIn(final int rank,
            final Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int rankOfTreeRoot = sizeOf(tree.left);

        if (rankOfTreeRoot > rank)
            return nodeWithRankIn(rank, tree.left);

        if (rankOfTreeRoot < rank)
            return nodeWithRankIn(rank - rankOfTreeRoot - 1, tree.right);

        return tree;
    }

    private Node<Key, Value> floorNodeOf(final Key key,
            final Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison == 0)
            return tree;

        if (comparison < 0)
            return floorNodeOf(key, tree.left);

        final Node<Key, Value> floorNode = floorNodeOf(key, tree.right);
        
        if (floorNode != null)
            return floorNode;
        
        return tree;
    }

    private Node<Key, Value> ceilingNodeOf(final Key key,
            final Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison == 0)
            return tree;

        if (comparison > 0)
            return ceilingNodeOf(key, tree.right);

        final Node<Key, Value> ceilingNode = ceilingNodeOf(key, tree.left);
        
        if (ceilingNode != null)
            return ceilingNode;

        return tree;
    }

    private void enqueueKeysInRange(final Queue<Key> keys, final Key low,
            final Key high, final Node<Key, Value> tree) {
        if (tree == null)
            return;

        final int comparisonWithLow = low.compareTo(tree.key);
        final int comparisonWithHigh = high.compareTo(tree.key);

        if (comparisonWithLow < 0)
            enqueueKeysInRange(keys, low, high, tree.left);

        if (comparisonWithLow <= 0 && comparisonWithHigh >= 0)
            keys.enqueue(tree.key);

        if (comparisonWithHigh > 0)
            enqueueKeysInRange(keys, low, high, tree.right);
    }

    private Node<Key, Value> deleteMinimumOf(final Node<Key, Value> tree) {
        if (tree.left == null)
            return tree.right;

        tree.left = deleteMinimumOf(tree.left);

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private Node<Key, Value> deleteMaximumOf(final Node<Key, Value> tree) {
        if (tree.right == null)
            return tree.left;

        tree.right = deleteMaximumOf(tree.right);

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private int heightOf(final Node<Key, Value> tree) {
        if (tree == null)
            return -1;

        return 1 + Math.max(heightOf(tree.left), heightOf(tree.right));
    }

    private void checkInvariant() {
        assert isBst() : "Binary tree not in symmetric order.";
        assert isSizeConsistent() : "Subtree sizes of binary tree are not consistent.";
        assert isRankConsistent() : "Ranks of binary tree are not consistent.";
    }

    private boolean isBst() {
        return isBstBetween(root, null, null);
    }

    private boolean isBstBetween(final Node<Key, Value> tree,
            final Key minimum, final Key maximum) {
        if (tree == null)
            return true;

        if (minimum != null && tree.key.compareTo(minimum) <= 0)
            return false;

        if (maximum != null && tree.key.compareTo(maximum) >= 0)
            return false;

        return isBstBetween(tree.left, minimum, tree.key)
                && isBstBetween(tree.right, tree.key, maximum);
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(final Node<Key, Value> tree) {
        if (tree == null)
            return true;

        if (tree.size != 1 + sizeOf(tree.left) + sizeOf(tree.right))
            return false;

        return isSizeConsistent(tree.left) && isSizeConsistent(tree.right);
    }

    private boolean isRankConsistent() {
        for (int rank = 0; rank != sizeOf(root); rank++)
            if (rank != rankOf(nodeWithRankIn(rank, root).key, root))
                return false;

        if (root != null) {
            Queue<Key> keys = new Queue<Key>();

            enqueueKeysInRange(keys, minimumNodeOf(root).key, maximumNodeOf(root).key, root);

            for (Key key : keys)
                if (key.compareTo(nodeWithRankIn(rankOf(key, root), root).key) != 0)
                    return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        final BstOrderedTable<String, Integer> table = new BstOrderedTable<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            final String key = StdIn.readString();
            table.put(key, i);
        }

        StdOut.println("Level order:");
        for (String key : table.keysInLevelOrder())
            StdOut.println(key + " " + table.valueFor(key));

        StdOut.println();

        StdOut.println("Key order:");
        for (String key : table.keys())
            StdOut.println(key + " " + table.valueFor(key));
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