package pt.europeia.eda.session14;

import edu.princeton.cs.introcs.In;

import static java.lang.System.out;

public class WordSorter {

    public static void main(final String[] arguments) {
        final In in = new In(arguments[0]);
        
        final String[] words = in.readAllStrings();
        
        Selection.sort(words);
        
        for (String word : words)
            out.println(word);
    }

}