package pt.europeia.eda.javaslides.presentation09;

// A value class:
public class Rational {

    private final int numerator;
    private final int denominator;

    public Rational(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational multipliedBy(final Rational rational) {
        return new Rational(numerator * rational.numerator, denominator
                * rational.denominator);
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