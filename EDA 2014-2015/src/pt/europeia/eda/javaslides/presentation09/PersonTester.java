package pt.europeia.eda.javaslides.presentation09;

import static java.lang.System.out;

import java.util.Arrays;

public class PersonTester {

    public static void main(final String[] arguments) {
        final Person luke = new Person("Luke", 1.81);
        final boolean isTall = luke.isTall();
        final double height = luke.getHeight();
        final String asString = luke.toString();

        out.println("luke is " + luke);
        out.println("isTall is " + isTall);
        out.println("height is " + height);
        out.println("asString is " + asString);

        final Person[] daltons = new Person[4];
        daltons[0] = new Person("Averell", 2.1);
        daltons[1] = new Person("William", 1.9);
        daltons[2] = new Person("Jack", 1.7);
        daltons[3] = new Person("Joe", 1.5);

        out.println("daltons is " + Arrays.toString(daltons));

        final boolean joeIsTall = daltons[3].isTall();
        final String name = daltons[1].getName();

        out.println("joeIsTall is " + joeIsTall);
        out.println("name is " + name);

        final Person averell = new Person("Averell", 2.1);
        final Person william = new Person("William", 1.9);
        final Person jack = new Person("Jack", 1.7);
        final Person joe = new Person("Joe", 1.5);

        final Gang theDaltons = new Gang("Dalton");

        theDaltons.add(averell);
        theDaltons.add(william);
        theDaltons.add(jack);
        theDaltons.add(joe);

        theDaltons.setLiderTo(joe);

        out.println(theDaltons);
        out.println(theDaltons.averageHeight());
        out.println(theDaltons.shortestMember());
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