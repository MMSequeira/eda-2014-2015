package pt.europeia.eda.java_slides.presentation09;

import static java.lang.System.out;

public class RationalTester {

    public static void main(String[] args) {
        // All classes have a tostring() operation. By default, it prints the
        // type name (ore rather, a string representation of the type), followed
        // by "@", and followed by a hash (usualy the address of the instance).
        // Classes may override the default implementation of toString(), so
        // that the result is more suitable to human consumption. The Rational
        // class does that:
        final Rational myRational = new Rational(1, 4);
        final String myRationalAsString = myRational.toString();
        out.println("myRationalAsString is " + myRationalAsString);

        // The toString() operation is called automatically by the compiler:
        out.println(myRational);
        out.println("myRational is " + myRational);
        
        final Rational r1 = new Rational(1, 4);
        final Rational r2 = new Rational(1, 2);
        final Rational r3 = r1.multipliedBy(r2);
        final String string = r1 + " × " + r2 + " = " + r3;

        out.println("r1 is " + r1);
        out.println("r2 is " + r2);
        out.println("r3 is " + r3);
        out.println("string is " + string);
    }

}
