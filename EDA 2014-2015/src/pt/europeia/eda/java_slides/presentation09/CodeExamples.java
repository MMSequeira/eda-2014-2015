package pt.europeia.eda.java_slides.presentation09;

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
