package pt.europeia.eda.java_slides.presentation09;

import static java.lang.System.out;

import java.util.Arrays;

public class PersonTester {

    public static void main(final String[] arguments) {
        final Person luke = new Person("Luke", 1.81);
        final boolean isTall = luke.isTall();
        final double height = luke.getHeight();
        final String asString = luke.toString();

        out.println("luke is " + luke);
        out.println("isTall is " + isTall);
        out.println("height is " + height);
        out.println("asString is " + asString);
        
        final Person[] daltons = new Person[4];
        daltons[0] = new Person("Averell", 2.1);
        daltons[1] = new Person("William", 1.9);
        daltons[2] = new Person("Jack", 1.7);
        daltons[3] = new Person("Joe", 1.5);

        out.println("daltons is " + Arrays.toString(daltons));
        
        final boolean joeIsTall = daltons[3].isTall();
        final String name = daltons[1].getName();

        out.println("joeIsTall is " + joeIsTall);
        out.println("name is " + name);
        
        final Person averell = new Person("Averell", 2.1);
        final Person william = new Person("William", 1.9);
        final Person jack = new Person("Jack", 1.7);
        final Person joe = new Person("Joe", 1.5);

        final Gang theDaltons = new Gang("Dalton");

        theDaltons.add(averell);
        theDaltons.add(william);
        theDaltons.add(jack);
        theDaltons.add(joe);

        theDaltons.setLiderTo(joe);
                
        out.println(theDaltons);
        out.println(theDaltons.averageHeight());
        out.println(theDaltons.shortestMember());
    }

}
