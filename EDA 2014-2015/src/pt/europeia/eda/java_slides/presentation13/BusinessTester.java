package pt.europeia.eda.java_slides.presentation13;

import java.util.ArrayList;

import static java.lang.System.out;

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
