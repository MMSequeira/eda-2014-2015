package pt.europeia.eda.javaslides.presentation10;

import static java.lang.System.out;

public class PointTester {
    
    public static void main(final String[] arguments) {
        Point a = new Point(1.0, -2.0);
        Point b = a;
        Point c = new Point(a);
        
        out.println("a is " + a);
        out.println("b is " + b);
        out.println("c is " + c);

        out.println("a == b is " + (a == b));
        out.println("a == c is " + (a == c));

        out.println("b.isEqualTo(a) is " + b.isEqualTo(a));
        out.println("c.isEqualTo(a) is " + c.isEqualTo(a));
    }

}
