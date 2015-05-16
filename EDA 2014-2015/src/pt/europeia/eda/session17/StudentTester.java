package pt.europeia.eda.session17;

import static java.lang.System.out;

import java.util.Arrays;

public class StudentTester {

    public static void main(final String[] arguments) {
        final Student[] originalStudents = { new Student("Furia", 1),
            new Student("Fox", 3), new Student("Battle", 4),
            new Student("Rohde", 2), new Student("Kanaga", 3),
            new Student("Andrews", 3), new Student("Gazsi", 4),
            new Student("Chen", 3) };

        // Tests using selection sort, which is unstable:
        out.println("Selection sort of students:");

        // Get copy of original, unsorted students:
        Student[] students = originalStudents.clone();

        // Show students:
        out.println("\tOriginal students:");
        out.println("\t\t" + Arrays.toString(students));

        // The regular, natural order sort cannot be called, since students
        // don't have a natural order, i.e., they do not implement the
        // Comparable interface:
        // Selection.sort(students);

        // First sort by decreasing order of name:
        Selection.sort(students, Student.reverseComparatorByName);
        out.println("\tStudents by decreasing name:");
        out.println("\t\t" + Arrays.toString(students));

        // Now sort by increasing order of name:
        Selection.sort(students, Student.comparatorByName);
        out.println("\tStudents by increasing name:");
        out.println("\t\t" + Arrays.toString(students));

        // Sort by increasing order of section:
        Selection.sort(students, Student.comparatorBySection);
        // Notice that students, for each section, are no longer sorted by name,
        // since selection sort is unstable:
        out.println("\tStudents by increasing section:");
        out.println("\t\t" + Arrays.toString(students));

        // Sort by increasing order of section and, for students with the same
        // section, sort by name:
        Selection.sort(students, Student.comparatorBySectionThenByName);
        out.println("\tStudents by increasing section and by increasing name:");
        out.println("\t\t" + Arrays.toString(students));

        // Tests using merge sort, which is stable:
        out.println("Merge sort of students:");

        // Get copy of original, unsorted students:
        students = originalStudents.clone();

        // Show students:
        out.println("\tOriginal students:");
        out.println("\t\t" + Arrays.toString(students));

        // First sort by decreasing order of name:
        OptimizedMerge.sort(students, Student.reverseComparatorByName);
        out.println("\tStudents by decreasing name:");
        out.println("\t\t" + Arrays.toString(students));

        // Now sort by increasing order of name:
        OptimizedMerge.sort(students, Student.comparatorByName);
        out.println("\tStudents by increasing name:");
        out.println("\t\t" + Arrays.toString(students));

        // Sort by increasing order of section:
        OptimizedMerge.sort(students, Student.comparatorBySection);
        // Notice that students, for each section, are still sorted by name,
        // since merge sort is stable:
        out.println("\tStudents by increasing section:");
        out.println("\t\t" + Arrays.toString(students));

        // Sort by increasing order of section and, for students with the same
        // section, sort by name:
        OptimizedMerge.sort(students, Student.comparatorBySectionThenByName);
        out.println("\tStudents by increasing section and by increasing name:");
        out.println("\t\t" + Arrays.toString(students));
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