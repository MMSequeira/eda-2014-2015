package pt.europeia.eda.piazza.week07;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class MergeLists {

    @SafeVarargs
    private static <Item extends Comparable<? super Item>> List<Item> merge(
            final List<Item>... sortedLists) {
        PriorityQueue<Iterator<Item>> iterators = new PriorityQueue<Iterator<Item>>();

        for (int i = 0; i < sortedLists.length; ++i)
            iterators.offer(new Iterator<Item>(sortedLists[i]));

        final List<Item> result = new ArrayList<>();

        while (!iterators.isEmpty()) {
            final Iterator<Item> iteratorToSmaller = iterators.poll();
            result.add(iteratorToSmaller.next());
            if (iteratorToSmaller.hasNext())
                iterators.offer(iteratorToSmaller);
        }
        return result;
    }

    private static class Iterator<Item extends Comparable<? super Item>>
            implements Comparable<Iterator<Item>> {
        private ListIterator<Item> iterator;

        public Iterator(final List<Item> list) {
            iterator = list.listIterator();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public Item peek() {
            final Item currentItem = iterator.next();

            iterator.previous();

            return currentItem;
        }

        public Item next() {
            return iterator.next();
        }

        @Override
        public int compareTo(final Iterator<Item> other) {
            return peek().compareTo(other.peek());
        }

    }

    public static void main(String[] args) {
        final List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 9, 12, 14, 16);
        final List<Integer> numbers2 = Arrays.asList(3, 6, 7, 9, 22, 25, 28);
        final List<Integer> numbers3 = Arrays.asList(2, 5, 7, 8, 10, 11, 16);
        final List<Integer> numbers4 = Arrays.asList(4, 8, 23, 26, 28);

        final List<Integer> numbers = merge(numbers1, numbers2, numbers3,
                numbers4);

        out.println(numbers);
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