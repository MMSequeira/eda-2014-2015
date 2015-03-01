package pt.europeia.eda.java_slides.presentation08;

import static java.lang.System.out;

public class CalculatorTester {

    public static void main(final String[] arguments) {
        final Calculator calculator = new Calculator();

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.setValue(5);

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.clear();

        out.println("calculator.getValue() is " + calculator.getValue());

        calculator.add(10);

        out.println("calculator.getValue() is " + calculator.getValue());
    }

}
