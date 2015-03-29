package pt.europeia.eda.javaslides.presentation10;

// This class should have final attributes. That is, the reduce() method is
// really a bad idea. Can you think of alternatives?
public class Rational {

    private int numerator;
    private int denominator;

    public Rational(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public Rational multipliedBy(final Rational rational) {
        return new Rational(getNumerator() * rational.getNumerator(),
                getDenominator() * rational.getDenominator());
    }

    private void reduce() {
        final int gcd = IntegerUtilities.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // …

}