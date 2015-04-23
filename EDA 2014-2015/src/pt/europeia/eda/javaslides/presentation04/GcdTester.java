package pt.europeia.eda.javaslides.presentation04;

public class GcdTester {

    // Precondition: m ≥ 0 and n ≥ 0 and either m ≠ 0 or n ≠ 0.
    public static int gcd(int m, int n) {
        while (m != 0) {
            final int temporary = m;
            m = n % m;
            n = temporary;
        }

        return n;
    }

    public static void main(final String[] arguments) {
        final int firstValue = 25;
        final int secondValue = 30;
        final int gcd = gcd(firstValue, secondValue);
        System.out.println("The GCD is " + gcd + ".");

        // or simply:
        // System.out.println("The GCD is " + gcd(25, 30) + ".");
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