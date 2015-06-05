package pt.europeia.eda.exams.exam201406031000;

import static java.lang.System.out;

import java.util.NoSuchElementException;

public class Queue<Item> {

    private Node<Item> first = null;
    private Node<Item> last = null;

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        final Node<Item> oldLast = last;

        last = new Node<Item>();

        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow.");

        final Item item = first.item;

        first = first.next;

        if (isEmpty())
            last = null;

        return item;
    }

    // These two methods are the answer to Question 9 of the 2014-06-03 10:00
    // exam:
    public int positionOf(final Item item) {
        int position = 0;

        for (Node<Item> node = first; node != null; node = node.next, position++)
            if (node.item.equals(item))
                return position;

        return -1;
    }

    public boolean contains(final Item item) {
        return positionOf(item) != -1;
    }

    public static void main(final String[] arguments) {
        final Queue<String> queue = new Queue<String>();

        out.println(queue.positionOf("A"));
        out.println(queue.contains("A"));

        queue.enqueue("A");

        out.println(queue.positionOf("A"));
        out.println(queue.contains("A"));

        queue.enqueue("B");

        out.println(queue.positionOf("A"));
        out.println(queue.positionOf("B"));
        out.println(queue.contains("A"));
        out.println(queue.contains("B"));
        out.println(queue.contains("C"));
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