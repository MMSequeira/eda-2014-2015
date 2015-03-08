package pt.europeia.eda.piazza.week02;

import static java.lang.System.out;

// Improvement of student responses:
public class StudentGradesExample {

    public static void main(final String[] arguments) {
        final int[] studentIDs = { 50020032, 50030312, 50025342, 50031432 };
        final String[] courseAcronyms = { "EPL", "P1", "P2" };
        final int[][] studentGrades = { { 15, 18, 17 }, { 18, 14, 16 },
                { 11, 13, 15 }, { 10, 19, 16 } };

        showGrades(studentIDs, courseAcronyms, studentGrades);
        showAverageGrades(studentIDs, studentGrades);
        showHighestAverageGrade(studentIDs, studentGrades);
    }

    public static void showGrades(final int[] studentIDs,
            String[] courseAcronyms, final int[][] studentGrades) {
        for (int i = 0; i != studentIDs.length; i++) {
            out.println("Grades of student " + studentIDs[i] + ": ");
            for (int j = 0; j != studentGrades[i].length; j++)
                out.println("\t" + courseAcronyms[j] + ": "
                        + studentGrades[i][j]);
        }
    }

    public static void showAverageGrades(final int[] studentIDs,
            final int[][] studentGrades) {
        for (int i = 0; i != studentIDs.length; i++)
            out.println("Average grade of student " + studentIDs[i] + ": "
                    + averageOf(studentGrades[i]));
    }

    public static void showHighestAverageGrade(final int[] studentIDs,
            final int[][] studentGrades) {
        double highestAverageGrade = averageOf(studentGrades[0]);
        int IdOfHighestAverageGradeStudent = studentIDs[0];
        
        for (int i = 1; i != studentIDs.length; i++) {
            final double average = averageOf(studentGrades[i]);
            if (highestAverageGrade < average) {
                highestAverageGrade = average;
                IdOfHighestAverageGradeStudent = studentIDs[i];
            }
        }
        
        out.println("Highest average grade is " + highestAverageGrade
                + " for student " + IdOfHighestAverageGradeStudent + ".");
    }

    private static double averageOf(final int[] values) {
        double sum = 0.0;
        for (int value : values)
            sum += value;
        return sum / values.length;
    }

}
