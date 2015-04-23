package pt.europeia.eda.javaslides.presentation10;

import static java.lang.System.out;
import static pt.europeia.eda.javaslides.presentation10.IntegerUtilities.gcd;

public class IntegerUtilitiesTester {

    public static void main(final String[] arguments) {
        out.println("gcd(20, 25) is " + gcd(20, 25));
        out.println("gcd(-20, 25) is " + gcd(-20, 25));
        out.println("gcd(20, -25) is " + gcd(20, -25));
        out.println("gcd(-20, -25) is " + gcd(-20, -25));
        out.println("gcd(0, 25) is " + gcd(0, 25));
        out.println("gcd(20, 0) is " + gcd(20, 0));
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