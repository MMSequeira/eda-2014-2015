package pt.europeia.eda.javaslides.presentation14;

// This class should have final attributes. That is, the reduce() method is
// really a bad idea. Can you think of alternatives?
public class Rational implements Comparable<Rational> {

    private int numerator;
    private int denominator;

    public Rational(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public Rational multipliedBy(final Rational rational) {
        return new Rational(getNumerator() * rational.getNumerator(),
                getDenominator() * rational.getDenominator());
    }

    private void reduce() {
        final int gcd = IntegerUtilities.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // This implementation does not attempt to avoid integer overflow:
    @Override
    public int compareTo(final Rational another) {
        final int leftNumerator = getNumerator() * another.getDenominator();
        final int rightNumerator = another.getNumerator() * getDenominator();

        if (leftNumerator > rightNumerator)
            return 1;
        if (leftNumerator < rightNumerator)
            return -1;
        return 0;
        // Alternatively:
        // return leftNumerator - rightNumerator.
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // …

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