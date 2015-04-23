package pt.europeia.eda.javaslides.presentation12;

import static java.lang.System.out;

import java.time.LocalDate;
import java.time.Month;

public class CarTester {

    public static void main(final String[] arguments) {
        final Car johnsCar = new Car("00-AA-00", "VW-GTI-TDI.SLK", 2005,
                LocalDate.of(2014, Month.NOVEMBER, 20));

        out.println("John's car is " + johnsCar);

        final Car janesCar = johnsCar;
        final Car fredsCar = new Car("01-35-AP", "Smart-ForTwo", 2003,
                LocalDate.of(2014, Month.AUGUST, 30));

        out.println("Jane's car is " + janesCar);
        out.println("Fred's car is " + fredsCar);
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