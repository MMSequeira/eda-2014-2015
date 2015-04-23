package pt.europeia.eda.javaslides.presentation10;

import static java.lang.System.out;

public class PointTester {

    public static void main(final String[] arguments) {
        Point a = new Point(1.0, -2.0);
        Point b = a;
        Point c = new Point(a);

        out.println("a is " + a);
        out.println("b is " + b);
        out.println("c is " + c);

        out.println("a == b is " + (a == b));
        out.println("a == c is " + (a == c));

        out.println("b.isEqualTo(a) is " + b.isEqualTo(a));
        out.println("c.isEqualTo(a) is " + c.isEqualTo(a));
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