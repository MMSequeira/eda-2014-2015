package pt.europeia.eda.javaslides.presentation14;

import java.util.NoSuchElementException;

// This implementation only allows you to go through the list once, since
// currentNode is never reset to null.
public class LinkedList<Item> {

    private Node<Item> firstNode = null;
    private Node<Item> currentNode = null;

    private static class Node<Item> {

        private Node<Item> nextNode;
        private Item item;

        private Node(final Node<Item> nextNode, final Item item) {
            this.nextNode = nextNode;
            this.item = item;
        }

    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void addFirst(final Item newItem) {
        firstNode = new Node<Item>(firstNode, newItem);
    }

    public boolean hasNext() {
        return currentNode == null || currentNode.nextNode != null;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Cannot remove first item of empty list.");

        if (currentNode == firstNode)
            currentNode = currentNode.nextNode;

        Node<Item> nextFirstNode = firstNode.nextNode;
        firstNode.item = null;
        firstNode.nextNode = null;
        firstNode = nextFirstNode;
    }

    public void addLast(final Item newItem) {
        if (firstNode == null)
            firstNode = new Node<Item>(null, newItem);
        else
            lastNode().nextNode = new Node<Item>(null, newItem);
    }

    public Item next() {
        if (!hasNext())
            throw new NoSuchElementException(
                    "No next item after the last list item.");

        if (currentNode == null)
            currentNode = firstNode;
        else
            currentNode = currentNode.nextNode;

        return currentNode.item;
    }

    private Node<Item> lastNode() {
        Node<Item> node = firstNode;

        while (node.nextNode != null)
            node = node.nextNode;

        return node;
    }

}

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
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
 */