package pt.europeia.eda.java_slides.presentation12;

import static java.lang.System.out;

import java.time.LocalDate;
import java.time.Month;

public class CarTester {

    public static void main(final String[] arguments) {
        final Car johnsCar = new Car("00-AA-00", "VW-GTI-TDI.SLK", 2005,
                LocalDate.of(2014, Month.NOVEMBER, 20));

        out.println("John's car is " + johnsCar);

        final Car janesCar = johnsCar;
        final Car fredsCar = new Car("01-35-AP", "Smart-ForTwo", 2003,
                LocalDate.of(2014, Month.AUGUST, 30));

        out.println("Jane's car is " + janesCar);
        out.println("Fred's car is " + fredsCar);
    }

}
