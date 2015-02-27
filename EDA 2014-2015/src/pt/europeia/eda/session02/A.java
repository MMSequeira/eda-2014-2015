package pt.europeia.eda.session02;

import static java.lang.System.out;

// A simple class with a main() method that calls another classe's main()
// method. Not only may there be multiple main() methods in a single
// project, main() methods may even be called from other methods, including
// other main() methods. Not a good idea, but possible.
public class A {
    
    public static void main(final String[] arguments) {
        out.println("I'm A.main().");
        B.main(arguments);
    }
    
}