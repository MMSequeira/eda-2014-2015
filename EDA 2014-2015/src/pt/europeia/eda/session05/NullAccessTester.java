package pt.europeia.eda.session05;

import static java.lang.System.out;

public class NullAccessTester {

    // Suppresses warning do to intended error: 
    @SuppressWarnings("null")
    public static void main(String[] args) {
        final Person luke = null;

        // Calling a method through a null reference throws a
        // NullPointerException.
        out.println(luke.getName());
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