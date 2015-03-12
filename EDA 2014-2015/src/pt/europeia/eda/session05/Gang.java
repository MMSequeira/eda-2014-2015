package pt.europeia.eda.session05;

// A simple class to test the @Override annotation:
public class Gang {
    
    // Using @Override, the compiler will detect the error in the method name,
    // or rather, it will detect that the method does not override any methods
    // in the superclass Object:
//    @Override
    public String tostring() {
        return "A gang";
    }
    
}
