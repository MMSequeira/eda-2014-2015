package pt.europeia.eda.java_slides.presentation11;

import static java.lang.System.out;

import java.math.BigInteger;

public class BigIntegerTester {
    
    public static BigInteger factorialOf(BigInteger n) {
        BigInteger factorial = BigInteger.valueOf(1);
        while (n != BigInteger.ZERO) {
            factorial = factorial.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return factorial;
    }

    public static void main(final String[] arguments) {
        out.println("Number of different deck shuffles: "
                + factorialOf(BigInteger.valueOf(52)));
    }
    
}
