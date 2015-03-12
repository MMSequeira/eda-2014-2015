package pt.europeia.eda.session06;

import static java.lang.System.out;

public class EmployeeTester {

    public static void main(final String[] arguments) {
        final Employee jane = new Employee("Jane");
        final Employee joe = new Employee("Joe");
        
        out.println(jane);
        out.println(joe);

        jane.rename(joe, "Jack");
        
        out.println(joe);
    }
}
