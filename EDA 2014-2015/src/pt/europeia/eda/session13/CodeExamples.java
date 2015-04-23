package pt.europeia.eda.session13;

import static java.lang.System.out;

import java.util.Arrays;

public class CodeExamples {

    public static void main(final String[] arguments) {
        final double[] numbers = { 1.0, 2.0, 3.0 };
        final double[][] identity = { { 1.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0 },
            { 0.0, 0.0, 1.0 }, };

        // Calls numbers.toString(), which uses the toString() object inherited
        // from the Object class, which generates an ugly string, containing the
        // object's hash code (generally related to the object's address):
        out.println(numbers);

        // The Arrays.toString() static method produces a nicer string version
        // of the array:
        out.println(Arrays.toString(numbers));

        // If called on a two-dimensional array, however, the resulting string
        // will use the default Objecto toString() method on each array item:
        out.println(Arrays.toString(identity));

        // In order to obtain a nice string representation of a multidimensional
        // array, we have to use a deep version of the Arrays method. It is
        // called deep because, unlike the shallow version, it calls itself
        // recursively on each item of the array which is itself an array:
        out.println(Arrays.deepToString(identity));

        // Shallow and deep are adjectives use to specify whether some
        // operation, calculation, etc., applies only to the attributes of an
        // object or the items of an array or, rather, it also applies to the
        // objects or arrays referenced by them (if they are references).
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