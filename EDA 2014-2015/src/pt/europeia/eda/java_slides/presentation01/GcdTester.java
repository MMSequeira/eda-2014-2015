package pt.europeia.eda.java_slides.presentation01;

public class GcdTester {

    // Precondition: either m ≠ 0 or n ≠ 0.
    public static int gcd(int m, int n) {
        while (m != 0) {
            final int temporary = m;
            m = n % m;
            n = temporary;
        }

        return n;
    }

    public static void main(final String[] arguments) {
        final int firstValue = 25;
        final int secondValue = 30;
        final int gcd = gcd(firstValue, secondValue);
        System.out.println("The GCD is " + gcd + "."); 

        // or simply:
        // System.out.println("The GCD is " + gcd(25, 30) + "."); 
    }

}
