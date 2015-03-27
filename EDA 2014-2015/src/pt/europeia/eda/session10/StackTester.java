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
