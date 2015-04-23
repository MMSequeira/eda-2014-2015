package pt.europeia.eda.javaslides.presentation11;

import static java.lang.System.out;

public class EnumerationsTester {

    public static void main(final String[] arguments) {
        final DayOfTheWeek day = DayOfTheWeek.MONDAY;
        DayOfTheWeek someDay = DayOfTheWeek.FRIDAY;

        out.println("Monday is " + day + ".");

        someDay = DayOfTheWeek.valueOf("FRIDAY");
        // someDay = DayOfTheWeek.valueOf("Friday");

        if (someDay == DayOfTheWeek.FRIDAY)
            out.println("Some day is Friday.");

        out.println("Some day is " + someDay + ".");

        final Sex sex = Sex.valueOf("MALE");

        out.println("sex is " + sex);

        final String sexName = sex.toString();

        out.println("sexName is " + sexName);

        for (CardinalDirection direction : CardinalDirection.values())
            out.println(direction);

        out.println(CardinalDirection.NORTH.name());
        out.println(CardinalDirection.SOUTH.prettyName());
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