package pt.europeia.eda.javaslides.presentation09;

import java.util.HashSet;
import java.util.Set;

public class Gang {

    private String name;
    private Set<Person> members;
    private Person lider;

    public Gang(final String name) {
        this.name = name;
        this.members = new HashSet<Person>();
        this.lider = null;
    }

    public void add(final Person newMember) {
        members.add(newMember);
    }

    public double averageHeight() {
        double sumOfHeights = 0.0;

        for (Person member : members)
            sumOfHeights += member.getHeight();

        return sumOfHeights / members.size();
    }

    public Person shortestMember() {
        if (members.size() == 0)
            throw new IllegalStateException("Illegal…");

        double smallestHeight = Double.POSITIVE_INFINITY;
        Person shortestMember = null;

        for (Person member : members)
            if (member.getHeight() < smallestHeight) {
                smallestHeight = member.getHeight();
                shortestMember = member;
            }

        return shortestMember;
    }

    public void setLiderTo(final Person newLider) {
        members.add(newLider);
        lider = newLider;
    }

    public String toString() {
        return "Gang {Name: " + name + ", Members: " + members + ", Lider: "
                + lider + "}";
    }

    // …

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