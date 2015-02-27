package pt.europeia.eda.session02;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class SimpleLoopExercises {
	public static Scanner inputScanner = new Scanner(in);

	public static void main(String[] args) {
		exercise1();
		exercise2();
		exercise3();
		exercise4();
	}

	// Print sequences of numbers:
	public static void exercise1() {
		out.println("From 1 to 10:");
		for (int number = 1; number != 11; number++)
			out.println(number);

		out.println("From 1 to 10 (step 2):");
		for (int number = 1; number != 11; number += 2)
			out.println(number);

		out.println("From 1 to 10 (step 3):");
		for (int number = 1; number <= 10; number += 3)
			out.println(number);
	}

	// Print a triangle of stars (size 3):
	public static void exercise2() {
		for (int line = 0; line != 3; line++) {
			for (int star = 0; star != line + 1; star++)
				out.print('*');
			out.println();
		}
	}

	// Print a series of 4 triangles of increasing size:
	public static void exercise3() {
		for (int triangle = 0; triangle != 4; triangle++)
			for (int line = 0; line != triangle + 1; line++) {
				for (int star = 0; star != line + 1; star++)
					out.print('*');
				out.println();
			}
	}

	// Ask user for an integer and search its position in an array:
	public static void exercise4() {
		// The array of numbers:
		final int[] numbers = { 10, 40, -1, 5, 6 };

		// Get the number to search:
		out.print("Insert the number to search: ");
		final int numberToSearch = inputScanner.nextInt();

		// Search:
		int i = 0;
		while (i != numbers.length && numbers[i] != numberToSearch)
			i++;

		// If the loop ended because we exhausted the array, the number was not
		// found:
		if (i == numbers.length)
			out.println("Not found!");
		else
			out.println("Found in position " + (i + 1));
	}
}
