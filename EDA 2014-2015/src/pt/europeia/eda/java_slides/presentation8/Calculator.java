package pt.europeia.eda.java_slides.presentation8;

public class Calculator {
    private double value;

    public Calculator() {
        value = 0.0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double newValue) {
        value = newValue;
    }

    public void clear() {
        value = 0.0;
    }

    public void add(final double term) {
        value += term;
    }

    // …
}
