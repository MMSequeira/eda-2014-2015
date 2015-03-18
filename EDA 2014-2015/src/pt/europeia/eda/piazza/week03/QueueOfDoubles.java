package pt.europeia.eda.piazza.week03;

import java.util.NoSuchElementException;

import static java.lang.System.out;

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

    private void resizeTo(final int newCapacity) {
        assert newCapacity >= size : "Attempt to reduce array capacity below the current queue size.";

        final double[] copyOfItems = new double[newCapacity];

        for (int i = 0; i < size; i++)
            copyOfItems[i] = items[(first + i) % items.length];

        items = copyOfItems;
        first = 0;
        last = size - 1;
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

    public static void main(final String[] arguments) {
        final QueueOfDoubles numbers = new QueueOfDoubles();

        numbers.enqueue(10.0);
        numbers.enqueue(20.0);
        numbers.enqueue(30.0);
        numbers.enqueue(40.0);
        numbers.enqueue(50.0);
        numbers.enqueue(60.0);

        out.println("Dequeueing");
        while (!numbers.isEmpty())
            out.println("\t" + numbers.dequeue());

        numbers.enqueue(70.0);
        numbers.enqueue(80.0);
        numbers.enqueue(90.0);

        out.println("Dequeueing");
        while (!numbers.isEmpty())
            out.println("\t" + numbers.dequeue());
    }

}