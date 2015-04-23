package pt.europeia.eda.javaslides.presentation13;

import static java.lang.System.out;

import java.util.ArrayList;

public class BusinessTester {

    public static void main(final String[] arguments) {
        testConstruction();
        testCollection();
        testPolimorphism();
    }

    public static void testConstruction() {
        Supervisor supervisor = new Supervisor("Guilhermina", "123456789", 3);

        Employee employee = new Supervisor("Felisberto", "987654321", 5);

        out.println("employee is " + employee);
        out.println("supervisor is " + supervisor);
    }

    public static void testCollection() {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("João Maria", "123456789"));
        employees.add(new Supervisor("Ana Maria", "987654321", 4));

        for (Employee employee : employees)
            out.println(employee.toString());

        // This loop is equivalent:
        for (Employee employee : employees)
            out.println(employee);
    }

    public static void testPolimorphism() {
        Supervisor supervisor = new Supervisor("Guilhermina", "123456789", 3);
        Employee anEmployee = new Supervisor("Felisberto", "987654321", 5);
        Employee anotherEmployee = new Employee("Elvira", "111111111");

        out.println(supervisor.toString());
        out.println(anEmployee.toString());
        out.println(anotherEmployee.toString());

        // Or simply:
        out.println(supervisor);
        out.println(anEmployee);
        out.println(anotherEmployee);
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