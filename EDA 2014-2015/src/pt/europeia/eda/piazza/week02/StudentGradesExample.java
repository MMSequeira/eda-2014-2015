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
