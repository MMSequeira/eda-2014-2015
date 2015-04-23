package pt.europeia.eda.session06;

// Class demonstrating Java private promiscuity (see EmployeeTester):
public class Employee {

    private String name;

    public Employee(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // An object of a class may access and change the private attributes of
    // another object of the same class. Java allows promiscuity between objects
    // of the same class. You should avoid it, however.
    public void rename(final Employee otherEmployee, final String newName) {
        // Don't do this!
        otherEmployee.name = newName;
    }

    @Override
    public String toString() {
        return "(" + getName() + ")";
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