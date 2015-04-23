package pt.europeia.eda.piazza.week01;

import static java.lang.System.out;

import java.util.ArrayList;

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

/*
 * Copyright 2015, Manuel Menezes de Sequeira.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 */