package pt.europeia.eda.javaslides.presentation13;

import static java.lang.System.out;

public class Derived extends Base {

    @Override
    public String className() {
        return "Derived";
    }

    public void testCalls() {
        final Base base = (Base)this; // (Base) is not really necessary

        out.println("Through this:  " + this.className());
        out.println("Through base:  " + base.className());
        out.println("Through super: " + super.className());
    }
    
}