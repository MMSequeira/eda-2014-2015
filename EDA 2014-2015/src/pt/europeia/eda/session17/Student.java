package pt.europeia.eda.session17;

import java.util.Comparator;

public class Student {
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();
    
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
    
    private static class ByName implements Comparator<Student> {
        public int compare(final Student first, final Student second) {
            return first.name.compareTo(second.name);
        }
    }

    private static class BySection implements Comparator<Student> {
        public int compare(final Student first, final Student second) {
            return first.section - second.section;
        }
    }
}