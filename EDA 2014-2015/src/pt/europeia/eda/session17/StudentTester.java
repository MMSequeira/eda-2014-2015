package pt.europeia.eda.session17;

import static java.lang.System.out;

import java.util.Arrays;

public class StudentTester {

    public static void main(final String[] arguments) {
        final Student[] students = { new Student("Furia", 1),
            new Student("Fox", 3), new Student("Battle", 4),
            new Student("Rohde", 2), new Student("Kanaga", 3),
            new Student("Andrews", 3), new Student("Gazsi", 4),
            new Student("Chen", 3) };

        out.println("students: " + Arrays.toString(students));

        // OptimizedMerge.sort(students);

        OptimizedMerge.sort(students, Student.BY_NAME);

        out.println("students: " + Arrays.toString(students));

        OptimizedMerge.sort(students, Student.BY_SECTION);

        out.println("students: " + Arrays.toString(students));
    }

}
