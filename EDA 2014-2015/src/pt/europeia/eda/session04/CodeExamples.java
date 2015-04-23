package pt.europeia.eda.session04;

import java.util.HashSet;
import java.util.Set;

public class CodeExamples {

    public static void main(final String[] arguments) {
        // java.lang.Math is a package-class, i.e., a class whose purpose is to
        // pack a set of class (static) methods, variables, constants, etc. .
        // Hence, it is not possible to instantiate it (check the definition of
        // Math at http://bit.ly/ue-eda-jdk-8-math):
        // Math m = new Math();

        // java.lang.System is also a package-class:
        // System system = new System();

        // Build a set of persons containing the Daltons:
        Set<Person> members = new HashSet<Person>();
        members.add(new Person("Averell", 2.1));
        members.add(new Person("William", 1.9));
        members.add(new Person("Jack", 1.7));
        members.add(new Person("Joe", 1.5));

        // Calculate average height of the Daltons:
        double sumOfHeights = 0.0;
        for (Person member : members)
            sumOfHeights += member.getHeight();
        System.out.println("Average height of Daltons: " + sumOfHeights
                / members.size());

        // Repeat calculation using a "regular" for loop. Sets were not made to
        // be indexable, so this is very poor code:
        sumOfHeights = 0.0;
        for (int i = 0; i != members.size(); i++)
            sumOfHeights += ((Person) (members.toArray()[i])).getHeight();
        System.out.println("Average height of Daltons: " + sumOfHeights
                / members.size());
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