package pt.europeia.eda.java_slides.presentation06;

import java.util.Arrays;

import static java.lang.System.out;

public class CodeExamples {

    public static void main(final String[] arguments) {
        // Characters have codes. A character may be converted to its code. That
        // code can then be converted back to its character:
        char original = 'b';
        int code = (int) original;
        char recovered = (char) code;

        out.println("original is " + original);
        out.println("code is " + code);
        out.println("recovered ix " + recovered);

        // One may even perform arithmetic with characters (avoid it if you can,
        // though):
        char letter1 = 'c';
        letter1++;

        char letter2 = 'b';
        letter2--;

        final int difference = letter1 - letter2;

        out.println("letter1 ix " + letter1);
        out.println("letter2 is " + letter2);
        out.println("difference is " + difference);

        // Characters may be compared using relational operators:
        out.println("letter1 > letter2 is " + (letter1 > letter2));
        out.println("letter1 ≤ letter2 is " + (letter1 <= letter2));

        // Building an array of characters with the latim alphabet:
        final int numberOfLetters = 'z' - 'a' + 1; // 26

        final char[] letters = new char[numberOfLetters];

        for (int i = 0; i != letters.length; i++)
            letters[i] = (char) ('a' + i);

        out.println("numberOfLetters is " + numberOfLetters);
        out.println("letters is " + Arrays.toString(letters));

        // Primitive types are value types, i.e., each variable stores a value
        // directly. Below, after initializing b with a, the values of b and a
        // are independent:
        int a = 7;
        int b = a;

        out.println("a is " + a);
        out.println("b is " + b);

        a = 8;

        out.println("a is " + a);
        out.println("b is " + b);

        // Arrays are reference types, i.e., each variable stores a reference to
        // a value (or rather, an instance) of that type. Below, after
        // initializing secondArray with firstArray, the references constained
        // in secondArray and firstArray are independent, but the referenced
        // array is the same:
        int[] firstArray = { 10, 20, 30 };
        int[] secondArray = firstArray;

        out.println("firstArray is " + Arrays.toString(firstArray));
        out.println("secondArray is " + Arrays.toString(secondArray));

        firstArray[0] = 100;

        out.println("firstArray is " + Arrays.toString(firstArray));
        out.println("secondArray is " + Arrays.toString(secondArray));

        // Attempt to change value of variable through a procedure call fails:
        int number = 3;

        out.println("number is " + number);

        increment(number);

        out.println("number is " + number);

        // Attempt to change value of the first item of an array through a
        // procedure call succeeds:
        final int[] numbers = { 3, 2, 1, 0 };

        out.println("numbers is " + Arrays.toString(numbers));

        incrementFirstOf(numbers);

        out.println("numbers is " + Arrays.toString(numbers));
    }

    // This procedure method does not do what it was intended to do, since
    // primitive types such as int are value types and Java passes arguments by
    // copying each argument to its corresponding argument:
    public static void increment(int value) {
        value++;
    }

    // This procedure method does what it was intended to do, since arrays are
    // reference types and Java passes arguments by copying each argument to its
    // corresponding argument, which means that the values parameter references
    // the same array whose reference was passed as argument:
    public static void incrementFirstOf(final int[] values) {
        values[0]++;
    }

}