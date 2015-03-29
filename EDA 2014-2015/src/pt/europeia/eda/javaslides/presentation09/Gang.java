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
