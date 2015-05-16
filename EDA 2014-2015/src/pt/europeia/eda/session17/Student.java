package pt.europeia.eda.session17;

import java.util.Comparator;

public class Student {
    public static final Comparator<Student> comparatorByName = new ComparatorByName();
    public static final Comparator<Student> comparatorBySection = new ComparatorBySection();
    public static final Comparator<Student> comparatorBySectionThenByName = new ComparatorBySectionThenByName();
    public static final Comparator<Student> reverseComparatorByName = new ReverseComparatorByName();

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

    private static class ComparatorBySectionThenByName implements
            Comparator<Student> {
        public int compare(final Student first, final Student second) {
            if (first.section != second.section)
                return first.section - second.section;
            return first.name.compareTo(second.name);
        }
    }

    private static class ReverseComparatorByName implements Comparator<Student> {
        public int compare(final Student first, final Student second) {
            return second.name.compareTo(first.name);
        }
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