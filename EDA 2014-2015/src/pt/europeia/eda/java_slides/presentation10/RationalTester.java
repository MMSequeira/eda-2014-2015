package pt.europeia.eda.java_slides.presentation10;

import static java.lang.System.out;

public class RationalTester {

    public static void main(String[] args) {
        final Rational rational = new Rational(1, 4);

        out.println(rational.getDenominator());
        
        // rational.denominator = 0;

        final Rational anotherRational = new Rational(2, 8);

        out.println("anotherRational is " + anotherRational);
        
        // rational.reduce();
    }

}
