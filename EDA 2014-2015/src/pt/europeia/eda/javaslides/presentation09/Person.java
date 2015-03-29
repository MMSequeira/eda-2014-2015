package pt.europeia.eda.javaslides.presentation09;

// An identity class:
public class Person {

    private String name;
    private double height;

    public Person(final String name, final double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public boolean isTall() {
        return 1.8 <= getHeight();
    }

    @Override
    public String toString() {
        return getName() + " (" + getHeight() + ")";
    }

}
