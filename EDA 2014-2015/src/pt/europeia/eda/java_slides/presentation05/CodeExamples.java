package pt.europeia.eda.java_slides.presentation05;

import static java.lang.System.out;

import java.util.Arrays;

public class CodeExamples {

    public static void main(String[] args) {
        testAssignements();
        testArrays();
        testWhileLoop();
        testForLoop();
        testForEachLoop();
        testSelectionOperator(20, 25);
        testMaximumOf();
    }
    
    public static void testAssignements() {
        final int value = 10;

        int sum = 0;

        // Accumulation using sum and assignment:
        sum = sum + value;

        out.println("sum = " + sum);

        // Accumulation using special assignment operator:
        sum += value;

        out.println("sum = " + sum);

        int i = 0;

        // Increment using sum and assignment:
        i = i + 1;

        out.println("i = " + i);

        // Increment using prefix increment operator:
        ++i;

        out.println("i = " + i);

        // Increment using suffix increment operator:
        i++;

        out.println("i = " + i);

        int j = 0;

        // Decrement using sum and assignment:
        j = j - 1;

        out.println("j = " + j);

        // Decrement using prefix decrement operator:
        --j;

        out.println("j = " + j);

        // Decrement using suffix decrement operator:
        j--;

        out.println("j = " + j);
    }

    public static void testArrays() {
        final int numberOfStudents = 30;
        final int numberOfClasses = 10;

        // Declare, construct, and initialize an array of doubles:
        final double[] grades = new double[numberOfStudents];

        out.println("grades = " + Arrays.toString(grades));

        // Declare, construct, and implicitly initialize an array of ints:
        final int[] sizes = new int[numberOfClasses];

        out.println("sizes = " + Arrays.toString(sizes));

        // Get the size or length of an array:
        final int numberOfGrades = grades.length;

        out.println("numberOfGrades = " + numberOfGrades);

        int firstSize = sizes[0];

        out.println("firstSize = " + firstSize);

        int lastSize = sizes[sizes.length - 1];

        out.println("lastSize = " + lastSize);

        final int[] values = { 0, 2, 4 };

        out.println("values = " + Arrays.toString(values));

        out.println("values.length = " + values.length);

        int anotherValue = values[2];

        out.println("anotherValue = " + anotherValue);

        values[0] = 7;

        out.println("values = " + Arrays.toString(values));
    }
    
    public static void testWhileLoop() {
        // Declare, construct, and explicitly initialize an array of doubles:
        final double[] grades = {14.0, 16.0, 18.0};

        double sumOfGrades = 0.0;
        int i = 0;
        while (i != grades.length) {
            sumOfGrades += grades[i];
            i++;
        }

        out.println("sumOfGrades = " + sumOfGrades);
    }

    public static void testForLoop() {
        // Declare, construct, and explicitly initialize an array of doubles:
        final double[] grades = {14.0, 16.0, 18.0};

        double sumOfGrades = 0.0;
        for (int i = 0; i != grades.length; i++) {
            sumOfGrades += grades[i];
        }

        out.println("sumOfGrades = " + sumOfGrades);
    }

    public static void testForEachLoop() {
        // Declare, construct, and explicitly initialize an array of doubles:
        final double[] grades = {14.0, 16.0, 18.0};

        double sumOfGrades = 0.0;
        for (double grade : grades) {
            sumOfGrades += grade;
        }

        out.println("sumOfGrades = " + sumOfGrades);
    }

    public static void testSelectionOperator(final int m, final int n) {        
        int maximum;
        
        if (m < n)
            maximum = n;
        else
            maximum = m;

        out.println("maximum = " + maximum);

        maximum = m < n ? n : m;

        out.println("maximum = " + maximum);
    }

    public static void testMaximumOf() {
        final int[] sizes = {10, 4, 5, 20, 0, 6};
        
        final int maximumSize = maximumOf(sizes);
        
        out.println("maximumSize = " + maximumSize);
    }
    
    /**
     * Returns maximum of the items in array.
     *
     * @param array  array whose maximum will be returned.
     * @returns              the maximum of the items in array.
     * @pre array must have at least one item
     */
    public static int maximumOf(final int[] array) {
        int maximum = array[0];

        for (int i = 1; i != array.length; i++)
            if (maximum < array[i])
                maximum = array[i];

        return maximum;
    }

}
