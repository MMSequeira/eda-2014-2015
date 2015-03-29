package pt.europeia.eda.javaslides.presentation10;

public class IntegerUtilities {

    private IntegerUtilities() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }
    
    /**
     * Returns the greatest common divisor (GCD) of two integer numbers.
     * 
     * @param m
     *            first of the two integer numbers whose GCD will be returned.
     * @param n
     *            second of the two integer numbers whose GCD will be returned.
     * @return the greatest common divisor of m and n.
     * @pre m ≠ 0 ∨ n ≠ 0
     * @post gcd = gcd(m, n)
     */
    public static int gcd(int m, int n) {
        if (m == 0 && n == 0)
            throw new IllegalArgumentException("Illegal call with "
                    + "m = 0 and n = 0.");

        m = Math.abs(m);
        n = Math.abs(n);

        while (m != 0) {
            int temporary = m;
            m = n % m;
            n = temporary;
        }

        return n;
    }
//  public static int gcd(int m, int n) {
//  if (m == 0 && n == 0)
//      throw new IllegalArgumentException("Illegal call with "
//              + "m = 0 and n = 0.");
//
//  m = Math.abs(m);
//  n = Math.abs(n);
//
//  if (m == 0 || n == 0)
//      return Math.max(m, n);
//
//  int possibleGcd = Math.min(m, n);
//
//  while (m % possibleGcd != 0 || n % possibleGcd != 0)
//      possibleGcd--;
//
//  return possibleGcd;
//}

}
