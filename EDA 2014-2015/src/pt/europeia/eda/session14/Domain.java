package pt.europeia.eda.session14;

public class Domain implements Comparable<Domain> {

    private final String[] fields;

    public Domain(final String name) {
        fields = name.split("\\.");
    }

    public int compareTo(final Domain other) {
        for (int i = 0; i != Math.min(fields.length, other.fields.length); i++) {
            final String field = fields[fields.length - 1 - i];
            final String otherField = fields[other.fields.length - 1 - i];

            int comparison = field.compareTo(otherField);

            if (comparison < 0)
                return -1;
            else if (comparison > 0)
                return +1;
        }
        return fields.length - other.fields.length;
    }

}

/*
 * Copyright 2015, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This file is a derivative work of the code which accompanies the textbook
 * 
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
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
 * 
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */