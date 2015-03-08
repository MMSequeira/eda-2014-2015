package pt.europeia.eda.sessionx01;

import java.util.Arrays;

import static java.lang.System.out;

public class SetOfIntsTester {

    public static void main(String[] args) {
        out.println("Building empty set.");
        SetOfInts set = new SetOfInts();

        out.println("set is " + set);
        out.println("set.cardinality() is " + set.cardinality());

        out.println("Adding 10 to set.");
        set.add(10);

        out.println("set is " + set);
        out.println("set.cardinality() is " + set.cardinality());
        out.println("set.contains(10) is " + set.contains(10));

        out.println("Adding 20 to set.");
        set.add(20);
        out.println("Adding 30 to set.");
        set.add(30);

        out.println("set is " + set);
        out.println("set.cardinality() is " + set.cardinality());
        out.println("set.contains(10) is " + set.contains(10));
        out.println("set.contains(20) is " + set.contains(20));
        out.println("set.contains(30) is " + set.contains(30));
        out.println("set.getItems() is " + Arrays.toString(set.getItems()));

        out.println("Adding 10 (again) to set.");
        set.add(10);

        out.println("set is " + set);
        out.println("set.cardinality() is " + set.cardinality());
        out.println("set.contains(10) is " + set.contains(10));
        out.println("set.contains(20) is " + set.contains(20));
        out.println("set.contains(30) is " + set.contains(30));

        out.println("Removing 20 from the set.");
        set.remove(20);
        out.println("Removing 10 from the set.");
        set.remove(10);
        out.println("Removing 50 from the set.");
        set.remove(50);

        out.println("set is " + set);
        out.println("set.cardinality() is " + set.cardinality());
        out.println("set.contains(10) is " + set.contains(10));
        out.println("set.contains(20) is " + set.contains(20));
        out.println("set.contains(30) is " + set.contains(30));
    }

}
