package pt.europeia.eda.javaslides.presentation07;

import static java.lang.System.out;

import java.util.Arrays;

public class CodeExamples {

    public static void main(final String[] arguments) {
        final double[][] identityMatrix = { { 1.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 } };

        // Java arrays toString() method does not do what we would like it to
        // do:
        out.println(identityMatrix);

        // Fortunately Java's Arrays class has a handy toString() method which
        // does what we want. Sort of... For multidimensional arrays it does not
        // work as we would like it to.
        out.println(Arrays.toString(identityMatrix));

        // Fortunately Java's Arrays class has another handy method,
        // deepToString() which does what we want!
        out.println(Arrays.deepToString(identityMatrix));

        // Multidimensional arrays don't have to be regular:
        final int[][] primeFactors = { null, {}, { 2 }, { 3 }, { 2, 2 }, { 5 },
                { 2, 3 }, { 7 }, { 2, 2, 2 }, { 3, 3 }, { 2, 5 } };

        out.println(Arrays.deepToString(primeFactors));

        // One-dimensional arrays may be used to represent mathematical vectors:
        final double[] vector1 = { 1.0, 0.0, 0.0 };

        out.println(Arrays.toString(vector1));

        // Array items are implicitly initiatialized with zero (or null):
        final double[] vector2 = new double[3];

        out.println(Arrays.toString(vector2));

        // Two-dimensional arrays may be used to represent mathematical
        // matrices:
        final double[][] rectangularMatrix = new double[2][3];

        out.println(Arrays.deepToString(rectangularMatrix));

        // One may index multidimensional arrays as expected:
        final int secondFactorOf4 = primeFactors[4][1];

        final int[] factorsOf8 = primeFactors[8];

        final int firstFactorOf8 = factorsOf8[0];

        out.println("secondFactorOf4 is " + secondFactorOf4);
        out.println("factorsOf8 is " + Arrays.toString(factorsOf8));
        out.println("firstFactorOf8 is " + firstFactorOf8);

        // Example of use:
        final int[][] gradesPerCourse = { { 14, 16 }, { 12, 18, 20 } };

        int numberOfGrades = 0;
        int sumOfGrades = 0;
        for (int course = 0; course != gradesPerCourse.length; course++) {
            for (int i = 0; i != gradesPerCourse[course].length; i++)
                sumOfGrades += gradesPerCourse[course][i];
            numberOfGrades += gradesPerCourse[course].length;
        }

        final double averageOfGrades = sumOfGrades / (double) numberOfGrades;
        
        out.println("averageOfGrades is " + averageOfGrades);
    }

}
