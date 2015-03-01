package pt.europeia.eda.piazza.week01;

import java.util.ArrayList;

import static java.lang.System.out;

public class Numbers {

    public static void main(final String[] arguments) {
        out.println(primesUpTo(1000));
        out.println("isPrime(1) = " + isPrime(1));
        out.println("isPrime(1, new ArrayList<Integer>()) = "
                + isPrime(1, new ArrayList<Integer>()));
    }

    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    public static int squareOf(final int number) {
        return number * number;
    }

    public static boolean isPrime(final int number) {       
        if (number != 2 && number % 2 == 0)
            return false;

        for (int divisor = 3; divisor <= Math.sqrt(number); divisor += 2)
            if (number % divisor == 0)
            return false;

        if (number == 1)
            return false;
            
        return true;
    }
    
    public static boolean isPrime(final int number,
            final ArrayList<Integer> primes) {
        if (number == 1)
            return false;

        for (int i = 0; i != primes.size() && squareOf(primes.get(i)) <= number; i++)
            if (number % primes.get(i) == 0)
                return false;
        return true;
    }

    public static ArrayList<Integer> primesUpTo(final int maximumNumber) {
        ArrayList<Integer> primes = new ArrayList<>();

        if (maximumNumber < 2)
            return primes;

        primes.add(2);

        for (int number = 3; number <= maximumNumber; number += 2)
            if (isPrime(number, primes))
                primes.add(number);

        return primes;
    }

}
