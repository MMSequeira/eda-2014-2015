package pt.europeia.eda.session23;

import static java.lang.System.out;

import edu.princeton.cs.introcs.StdRandom;

public class TestAverageHeight {

    public static void main(final String[] arguments) {
        final int numberOfNodes = 1 << 16;
        final int numberOfRepetitions = 1000;

        final int[] numbers = new int[numberOfNodes];
        
        for (int i = 0; i != numberOfNodes; i++)
            numbers[i] = i;

        int sumOfHeights = 0;
        for (int repetition = 0; repetition != numberOfRepetitions; repetition++) {
            final BstOrderedTable<Integer, Integer> table = new BstOrderedTable<Integer, Integer>();

            StdRandom.shuffle(numbers);
            
            for (int i = 0; i != numberOfNodes; i++)
                table.put(numbers[i], i);

            sumOfHeights += table.height();
        }
        out.println("Average height for N = " + numberOfNodes + " is "
                + (double) sumOfHeights / numberOfRepetitions + ".");
        out.println("Expected height for N = " + numberOfNodes + " [Reed, 2003] is "
                + (4.31107 * Math.log(numberOfNodes) - 1.953 * Math.log(Math
                        .log(numberOfNodes))) + ".");
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