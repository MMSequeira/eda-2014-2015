package pt.europeia.eda.session08;

import static java.lang.System.out;

public class DowncastTester {

    public static void main(String[] args) {
        Object object = new Integer(10);
        // Throws exception (invalid downcast):
        String string = (String)object;
        out.println(string);
    }
    
}
