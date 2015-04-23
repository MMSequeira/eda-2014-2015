package pt.europeia.eda.piazza.week03;

import static java.lang.System.out;

import java.util.NoSuchElementException;

public class QueueOfDoubles {

    private double[] items;
    private int size = 0;
    private int first = 0;
    private int last = size - 1;

    public QueueOfDoubles() {
        items = new double[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(final double newItem) {
        if (size == items.length)
            resizeTo(2 * items.length);

        last++;
        if (last == items.length)
            last = 0;

        items[last] = newItem;

        size++;
    }

    public double dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        final double item = items[first];

        size--;

        first++;
        if (first == items.length)
            first = 0;

        if (size > 0 && size == items.length / 4)
            resizeTo(items.length / 2);

        return item;
    }

    public double first() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        return items[first];
    }

    private void resizeTo(final int newCapacity) {
        assert newCapacity >= size : "Attempt to reduce array capacity below the current queue size.";

        final double[] copyOfItems = new double[newCapacity];

        for (int i = 0; i < size; i++)
            copyOfItems[i] = items[(first + i) % items.length];

        items = copyOfItems;
        first = 0;
        last = size - 1;
    }

    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            if (i != 0)
                result += ", ";
            result += items[(first + i) % items.length];
        }

        return result + "]";
    }

    public static void main(final String[] arguments) {
        final QueueOfDoubles numbers = new QueueOfDoubles();

        out.println("Queue is " + numbers + ".");

        out.println("Enqueueing eight numbers:");
        for (double number = 10.0; number <= 80.0; number += 10.0) {
            numbers.enqueue(number);
            out.println("\tEnqueued " + number + ".");
        }

        out.println("Queue is " + numbers + ".");

        out.println("Dequeueing four numbers:");
        for (int i = 0; i != 4; i++)
            out.println("\tDequeued " + numbers.dequeue() + ".");

        out.println("Queue is " + numbers + ".");

        out.println("Enqueueing another ten numbers:");
        for (double number = 90.0; number <= 180.0; number += 10.0) {
            numbers.enqueue(number);
            out.println("\tEnqueued " + number + ".");
        }

        out.println("Queue is " + numbers + ".");

        out.println("Dequeueing all numbers:");
        while (!numbers.isEmpty())
            out.println("\tDequeued " + numbers.dequeue() + ".");

        out.println("Queue is " + numbers + ".");
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