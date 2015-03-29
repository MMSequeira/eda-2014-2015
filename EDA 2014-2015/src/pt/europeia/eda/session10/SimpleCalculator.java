package pt.europeia.eda.session10;

import static java.lang.System.out;

import java.util.Scanner;
import java.util.Stack;

public class SimpleCalculator {

    private static final Scanner in = new Scanner(System.in);

    public static void main(final String[] arguments) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();

        while (in.hasNext()) {
            String token = in.next();

            if (token.equals("="))
                break;

            if (token.equals("("))
                ;
            else if (token.equals("+"))
                operators.push(token);
            else if (token.equals("*"))
                operators.push(token);
            else if (token.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+"))
                    values.push(values.pop() + values.pop());
                else if (operator.equals("*"))
                    values.push(values.pop() * values.pop());
            } else
                values.push(Double.parseDouble(token));
        }
        out.println(values.pop());
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
