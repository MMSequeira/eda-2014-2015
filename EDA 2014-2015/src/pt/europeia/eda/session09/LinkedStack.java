package pt.europeia.eda.session09;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static pt.europeia.eda.Tools.in;
import static pt.europeia.eda.Tools.out;

public class LinkedStack<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(final Item item) {
        final Node oldFirst = first;

        first = new Node();

        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow.");

        final Item item = first.item;

        first = first.next;

        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more items in iteration.");
            
            final Item item = current.item;
            
            current = current.next;
            
            return item;
        }
        
    }

    public static void main(String[] arguments) {
        final LinkedStack<String> words = new LinkedStack<String>();

        while (in.hasNext()) {
            final String word = in.next();
            if (word.equals("-"))
                out.print(words.pop() + " ");
            else
                words.push(word);
        }
        out.println();

        out.println("Remaining words:");
        for (String word : words)
            out.println(word);
    }

}

/*************************************************************************
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
 *************************************************************************/