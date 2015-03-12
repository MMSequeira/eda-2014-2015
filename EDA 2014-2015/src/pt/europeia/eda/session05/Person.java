package pt.europeia.eda.session05;

// A simple class to demonstrate the result of calling a method through a null
// reference:
public class Person {

    private String name;

    public Person(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}
