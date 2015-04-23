package pt.europeia.eda.javaslides.presentation09;

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

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 */