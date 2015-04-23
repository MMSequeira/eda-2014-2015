package pt.europeia.eda.session10;

import static java.lang.System.out;

public class StackTester {

    public static void main(final String[] arguments) {
        final Stack<String> words = new Stack<String>();

        out.println(words.isEmpty());

        words.push("one");
        words.push("two");
        words.push("three");

        out.println(words.pop());

        for (String word : words)
            out.println(word);

        while (!words.isEmpty())
            out.println(words.pop());

        out.println(words.isEmpty());

        words.push("four");
        words.push("five");
        words.push("six");

        // Should throw an exception due to concurrent changes to the stack:
        for (String word : words) {
            out.println(word);
            words.push(word);
        }
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