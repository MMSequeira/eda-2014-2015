package pt.europeia.eda.javaslides.presentation10;

import static java.lang.System.out;
import static pt.europeia.eda.javaslides.presentation10.IntegerUtilities.gcd;

public class IntegerUtilitiesTester {

    public static void main(final String[] arguments) {
        out.println("gcd(20, 25) is " + gcd(20, 25));
        out.println("gcd(-20, 25) is " + gcd(-20, 25));
        out.println("gcd(20, -25) is " + gcd(20, -25));
        out.println("gcd(-20, -25) is " + gcd(-20, -25));
        out.println("gcd(0, 25) is " + gcd(0, 25));
        out.println("gcd(20, 0) is " + gcd(20, 0));
    }

}
