package pt.europeia.eda.piazza.week02;

import static java.lang.System.out;

// Improvement of student responses:
public class StudentGradesExample {

    public static void main(final String[] arguments) {
        final int[] studentIds = { 50020032, 50030312, 50025342, 50031432 };
        final String[] courseAcronyms = { "EPL", "P1", "P2" };
        final int[][] studentGrades = { { 15, 18, 17 }, { 18, 14, 16 },
            { 11, 13, 15 }, { 10, 19, 16 } };

        showGrades(studentIds, courseAcronyms, studentGrades);
        showAverageGrades(studentIds, studentGrades);
        showHighestAverageGrade(studentIds, studentGrades);
    }

    public static void showGrades(final int[] studentIds,
            String[] courseAcronyms, final int[][] studentGrades) {
        for (int i = 0; i != studentIds.length; i++) {
            out.println("Grades of student " + studentIds[i] + ": ");
            for (int j = 0; j != studentGrades[i].length; j++)
                out.println("\t" + courseAcronyms[j] + ": "
                        + studentGrades[i][j]);
        }
    }

    public static void showAverageGrades(final int[] studentIds,
            final int[][] studentGrades) {
        for (int i = 0; i != studentIds.length; i++)
            out.println("Average grade of student " + studentIds[i] + ": "
                    + averageOf(studentGrades[i]));
    }

    public static void showHighestAverageGrade(final int[] studentIds,
            final int[][] studentGrades) {
        double highestAverageGrade = averageOf(studentGrades[0]);
        int idOfHighestAverageGradeStudent = studentIds[0];

        for (int i = 1; i != studentIds.length; i++) {
            final double average = averageOf(studentGrades[i]);
            if (highestAverageGrade < average) {
                highestAverageGrade = average;
                idOfHighestAverageGradeStudent = studentIds[i];
            }
        }

        out.println("Highest average grade is " + highestAverageGrade
                + " for student " + idOfHighestAverageGradeStudent + ".");
    }

    private static double averageOf(final int[] values) {
        double sum = 0.0;
        for (int value : values)
            sum += value;
        return sum / values.length;
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