package pt.europeia.eda.session09;

import static java.lang.System.out;

import java.util.ArrayList;

public class CodeExamples {

    public static void main(final String[] arguments) {
        // Generic type arguments cannot be primitive types. Uncommend the code
        // below and check the compilation error:
        // ArrayList<int> numbers;

        // The compilation error is 'Syntax error, insert "Dimensions" to
        // complete ReferenceType'. Not very helpful. The compiler is trying to
        // tell us that by adding "dimensions" (i.e., the square brackets), a
        // reference type will result, which it can accept...
        ArrayList<int[]> arraysOfNumbers;

        // The solution is the use the wrapper class for the int primitive type,
        // i.e., Integer:
        ArrayList<Integer> numbers;

        // This code uses auto-boxing and auto-unboxing:
        final Integer aNumber = 10;
        final int n = aNumber;

        // Java packages ints inside Integers when an int is provided and an
        // Integer, Object or some reference type is required. Auto-boxing does
        // not necessarily create new objects. Since wrapper classes are
        // immutable, Java may auto-box each int into a single corresponding
        // Integer, and thus the Integer references obtained by auto-boxing the
        // same int may all be equal. Thus, the first line of the code above is
        // not strictly speaking equivalent to the first line of the commented
        // code below. The second line, where auto-unboxing occurs, is entirely
        // equivalent to the second line below, though:
        // Integer aNumber = new Integer(10);
        // int n = aNumber.intValue();

        out.println(n);

        // Auto-boxing:
        Integer anotherNumber = 10;

        // Creation of a new Integer:
        Integer yetAnotherNumber = new Integer(10);

        // Can you explain the results of the code below?

        out.println("aNumber " + aNumber.intValue());
        out.println("anotherNumber " + anotherNumber.intValue());
        out.println("yetAnotherNumber " + yetAnotherNumber.intValue());

        out.println("aNumber == 10 is " + (aNumber == 10));
        out.println("yetAnotherNumber == 10 is " + (yetAnotherNumber == 10));

        out.println("aNumber == anotherNumber is " + (aNumber == anotherNumber));
        out.println("aNumber == yetAnotherNumber is "
                + (aNumber == yetAnotherNumber));

        out.println("aNumber < anotherNumber is " + (aNumber < anotherNumber));
        out.println("aNumber < yetAnotherNumber is "
                + (aNumber < yetAnotherNumber));

        out.println("aNumber <= anotherNumber is " + (aNumber <= anotherNumber));
        out.println("aNumber <= yetAnotherNumber is "
                + (aNumber <= yetAnotherNumber));
    }
}
