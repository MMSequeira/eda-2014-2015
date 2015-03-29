package pt.europeia.eda.javaslides.presentation04;

public class GcdTester {

    // Precondition: m ≥ 0 and n ≥ 0 and either m ≠ 0 or n ≠ 0.
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
