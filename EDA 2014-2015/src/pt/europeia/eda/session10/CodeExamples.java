package pt.europeia.eda.session10;

import static java.lang.System.out;

public class CodeExamples {

    public static int factorialOf(final int number) {
        // if (number == 0)
        // return 1;
        return number * factorialOf(number - 1);
    }

    public static void main(final String[] arguments) {
        // Throws a stack overflow error, since the factorial implementation is
        // broken, leading to an infinite number of recursive calls, each
        // requiring some space in the stack:
        out.println(factorialOf(10));
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