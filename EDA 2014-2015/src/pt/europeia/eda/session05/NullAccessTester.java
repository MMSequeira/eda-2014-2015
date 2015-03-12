package pt.europeia.eda.session05;

import static java.lang.System.out;

public class NullAccessTester {

    public static void main(String[] args) {
        final Person luke = null;

        // Calling a method through a null reference throws a
        // NullPointerException.
        out.println(luke.getName());
    }
}
