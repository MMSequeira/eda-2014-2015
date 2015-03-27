package pt.europeia.eda.session08;

import static java.lang.System.out;

public class AutoboxingTester {

    public static void compare(Integer a, Integer b) {
        if (a < b)
            out.println(a + " < " + b);
        else if (a == b)
            out.println(a + " = " + b);
        else
            out.println(a + " > " + b);
    }

    public static void main(String[] arguments) {
        compare(new Integer(42), new Integer(42));
        compare(43, 43);
        compare(142, 142);
    }
    
}