package pt.europeia.eda.session22;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class FrequencyCounter {

    public static void main(final String[] arguments) {
        final int minimumLength = Integer.parseInt(arguments[0]);
        final In in = new In(arguments[1]);

//        final BinarySearchOrderedTable<String, Integer> frequencies = new BinarySearchOrderedTable<String, Integer>();
        final SequentialSearchOrderedTable<String, Integer> frequencies = new SequentialSearchOrderedTable<String, Integer>();
        int numberOfDistinctWords = 0;
        int numberOfWords = 0;
        while (!in.isEmpty()) {
            final String word = in.readString();
            if (word.length() < minimumLength)
                continue;
            numberOfWords++;
            if (frequencies.contains(word))
                frequencies.put(word, frequencies.valueFor(word) + 1);
            else {
                frequencies.put(word, 1);
                numberOfDistinctWords++;
            }
        }

        String mostFrequentWord = "";
        frequencies.put(mostFrequentWord, 0);
        for (String word : frequencies.keys())
            if (frequencies.valueFor(word) > frequencies.valueFor(mostFrequentWord))
                mostFrequentWord = word;

        StdOut.println(mostFrequentWord + " "
                + frequencies.valueFor(mostFrequentWord));
        StdOut.println("distinct = " + numberOfDistinctWords);
        StdOut.println("words = " + numberOfWords);
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