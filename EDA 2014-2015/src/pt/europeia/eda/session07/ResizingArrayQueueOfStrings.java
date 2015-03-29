package pt.europeia.eda.session07;

import static pt.europeia.eda.Tools.in;
import static pt.europeia.eda.Tools.out;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {

    private String[] items;
    private int size = 0;
    private int first = 0;
    private int last = size - 1;

    public ResizingArrayQueueOfStrings() {
        items = new String[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(final String item) {
        if (size == items.length)
            resizeTo(2 * items.length);

        last++;

        if (last == items.length)
            last = 0;

        items[last] = item;

        size++;
    }

    public String dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        final String item = items[first];

        items[first] = null;

        size--;

        first++;
        if (first == items.length)
            first = 0;

        if (size > 0 && size == items.length / 4)
            resizeTo(items.length / 2);

        return item;
    }

    private void resizeTo(final int newCapacity) {
        final String[] copyOfItems = new String[newCapacity];

        for (int i = 0; i != size; i++)
            copyOfItems[i] = items[(first + i) % items.length];

        items = copyOfItems;
        first = 0;
        last = size - 1;
    }

    public static void main(final String[] arguments) {
        final ResizingArrayQueueOfStrings words = new ResizingArrayQueueOfStrings();

        while (in.hasNext()) {
            final String word = in.next();
            if (!word.equals("-"))
                words.enqueue(word);
            else if (!words.isEmpty())
                out.print(words.dequeue() + " ");
        }
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
