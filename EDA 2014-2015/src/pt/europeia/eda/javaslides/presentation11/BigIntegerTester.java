package pt.europeia.eda.javaslides.presentation11;

import static java.lang.System.out;

import java.math.BigInteger;

public class BigIntegerTester {
    
    public static BigInteger factorialOf(BigInteger number) {
        BigInteger factorial = BigInteger.valueOf(1);
        while (number != BigInteger.ZERO) {
            factorial = factorial.multiply(number);
            number = number.subtract(BigInteger.ONE);
        }
        return factorial;
    }

    public static void main(final String[] arguments) {
        out.println("Number of different deck shuffles: "
                + factorialOf(BigInteger.valueOf(52)));
    }
    
}
