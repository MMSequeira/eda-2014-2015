package pt.europeia.eda.java_slides.presentation11;

import static java.lang.System.out;

public class EnumerationsTester {

    public static void main(final String[] arguments) {
        final DayOfTheWeek day = DayOfTheWeek.MONDAY;
        DayOfTheWeek someDay = DayOfTheWeek.FRIDAY;
            
        out.println("Monday is " + day + ".");
            
        someDay = DayOfTheWeek.valueOf("FRIDAY");
        // someDay = DayOfTheWeek.valueOf("Friday");
            
        if (someDay == DayOfTheWeek.FRIDAY)
            out.println("Some day is Friday.");

        out.println("Some day is " + someDay + ".");
        
        final Sex sex = Sex.valueOf("MALE");

        out.println("sex is " + sex);
        
        final String sexName = sex.toString();
 
        out.println("sexName is " + sexName);
        
        for (CardinalDirection direction : CardinalDirection.values())
            out.println(direction);
        
        out.println(CardinalDirection.NORTH.name());
        out.println(CardinalDirection.SOUTH.prettyName());
    }

}
