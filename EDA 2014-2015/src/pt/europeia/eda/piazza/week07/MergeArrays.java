package pt.europeia.eda.piazza.week07;

import static java.lang.System.out;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeArrays {

    @SafeVarargs
    private static <Item extends Comparable<? super Item>> Item[] merge(
            final Item[]... sortedArrays) {
        PriorityQueue<ArrayIterator<Item>> iterators = new PriorityQueue<ArrayIterator<Item>>();
        int totalLength = 0;

        for (int i = 0; i < sortedArrays.length; ++i) {
            iterators.offer(new ArrayIterator<Item>(sortedArrays[i]));
            totalLength += sortedArrays[i].length;
        }

        @SuppressWarnings("unchecked")
        final Item[] result = (Item[]) Array.newInstance(sortedArrays
                .getClass().getComponentType().getComponentType(), totalLength);

        int index = 0;
        while (!iterators.isEmpty()) {
            final ArrayIterator<Item> iteratorToSmaller = iterators.poll();
            result[index] = iteratorToSmaller.next();
            if (iteratorToSmaller.hasNext())
                iterators.offer(iteratorToSmaller);
            index++;
        }
        return result;
    }

    private static class ArrayIterator<Item extends Comparable<? super Item>>
            implements Comparable<ArrayIterator<Item>> {
        private Item[] array;
        private int currentIndex;

        public ArrayIterator(final Item[] array) {
            this.array = array;
            currentIndex = 0;
        }

        public boolean hasNext() {
            return currentIndex != array.length;
        }

        public Item peek() {
            return array[currentIndex];
        }

        public Item next() {
            final Item currentItem = array[currentIndex];

            currentIndex++;

            return currentItem;
        }

        @Override
        public int compareTo(final ArrayIterator<Item> other) {
            return peek().compareTo(other.peek());
        }

    }

    public static void main(String[] args) {
        final Integer[] numbers1 = { 2, 4, 6, 8, 9, 12, 14, 16 };
        final Integer[] numbers2 = { 3, 6, 7, 9, 22, 25, 28 };
        final Integer[] numbers3 = { 2, 5, 7, 8, 10, 11, 16 };
        final Integer[] numbers4 = { 4, 8, 23, 26, 28 };

        final Integer[] numbers = merge(numbers1, numbers2, numbers3, numbers4);

        out.println(Arrays.toString(numbers));
    }
}

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This file is a derivative work of the code in
 * 
 * http://www.dsalgo.com/2013/02/merge-n-sorted-arrays.html
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