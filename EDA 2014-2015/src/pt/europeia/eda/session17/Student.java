package pt.europeia.eda.session17;

import java.util.Comparator;

public class Student {
    public static final Comparator<Student> comparatorByName = new ComparatorByName();
    public static final Comparator<Student> comparatorBySection = new ComparatorBySection();

    private String name;
    private int section;

    public Student(final String name, final int section) {
        this.name = name;
        this.section = section;
    }

    @Override
    public String toString() {
        return "(name: " + name + ", " + section + ")";
    }

    private static class ComparatorByName implements Comparator<Student> {
        public int compare(final Student first, final Student second) {
            return first.name.compareTo(second.name);
        }
    }

    private static class ComparatorBySection implements Comparator<Student> {
        public int compare(final Student first, final Student second) {
            return first.section - second.section;
        }
    }
}