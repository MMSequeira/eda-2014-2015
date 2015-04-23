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