package pt.europeia.eda.javaslides.presentation09;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class CodeExamples {

    public static void main(final String[] arguments) {
        testInputScanner();
        testStringScanner();
    }

    public static void testInputScanner() {
        final Scanner inputScanner = new Scanner(in);

        out.print("Enter a line: ");

        final String line = inputScanner.nextLine();

        out.println("line is " + line);

        out.print("Enter a number: ");

        final int number = inputScanner.nextInt();

        out.println("number is " + number);

        inputScanner.close();
    }

    public static void testStringScanner() {
        final String sentence = "one two    three four   five  ";

        int numberOfWords = 0;
        String invertedSentence = "";

        final Scanner sentenceScanner = new Scanner(sentence);

        while (sentenceScanner.hasNext()) {
            final String word = sentenceScanner.next();
            invertedSentence = word + " " + invertedSentence;
            numberOfWords++;
        }

        sentenceScanner.close();

        out.println("Read " + numberOfWords + " words.");
        out.println("Inverted sentence: " + invertedSentence);
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