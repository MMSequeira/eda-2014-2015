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
