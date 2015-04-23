package pt.europeia.eda.javaslides.presentation08;

import static java.lang.System.out;

public class CalculatorTester {

    public static void main(final String[] arguments) {
        final Calculator calculator = new Calculator();

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.setValue(5);

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.clear();

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.add(10);

        out.println("calculator.getValue() is " + calculator.getValue());
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