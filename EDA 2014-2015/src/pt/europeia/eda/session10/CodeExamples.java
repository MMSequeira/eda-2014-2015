package pt.europeia.eda.session10;

import static java.lang.System.out;

public class CodeExamples {

    public static int factorialOf(final int number) {
        // if (number == 0)
        // return 1;
        return number * factorialOf(number - 1);
    }

    public static void main(final String[] arguments) {
        // Throws a stack overflow error, since the factorial implementation is
        // broken, leading to an infinite number of recursive calls, each
        // requiring some space in the stack:
        out.println(factorialOf(10));
    }

}
