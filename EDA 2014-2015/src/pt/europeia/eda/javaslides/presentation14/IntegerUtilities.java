package pt.europeia.eda.javaslides.presentation14;

public class IntegerUtilities {

    private IntegerUtilities() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    /**
     * Returns the greatest common divisor (GCD) of two integer numbers.
     * 
     * @param m
     *            first of the two integer numbers whose GCD will be returned.
     * @param n
     *            second of the two integer numbers whose GCD will be returned.
     * @return the greatest common divisor of m and n.
     * @pre m ≠ 0 ∨ n ≠ 0
     * @post gcd = gcd(m, n)
     */
    public static int gcd(int m, int n) {
        if (m == 0 && n == 0)
            throw new IllegalArgumentException("Illegal call with "
                    + "m = 0 and n = 0.");

        m = Math.abs(m);
        n = Math.abs(n);

        while (m != 0) {
            final int temporary = m;
            m = n % m;
            n = temporary;
        }

        return n;
    }

    public static int simplisticGcd(int m, int n) {
        if (m == 0 && n == 0)
            throw new IllegalArgumentException("Illegal call with "
                    + "m = 0 and n = 0.");

        m = Math.abs(m);
        n = Math.abs(n);

        if (m == 0 || n == 0)
            return Math.max(m, n);

        int possibleGcd = Math.min(m, n);

        while (m % possibleGcd != 0 || n % possibleGcd != 0)
            possibleGcd--;

        return possibleGcd;
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
