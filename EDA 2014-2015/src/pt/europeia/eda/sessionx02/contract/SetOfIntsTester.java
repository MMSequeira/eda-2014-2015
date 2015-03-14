package pt.europeia.eda.sessionx02.contract;

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
        out.println("set.getElements() is "
                + Arrays.toString(set.getElements()));

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
        
        set.add(40);
        set.add(50);
        set.add(60);

        out.println("set is " + set);

        final SetOfInts anotherSet = new SetOfInts();

        anotherSet.add(50);
        anotherSet.add(60);
        anotherSet.add(70);
        anotherSet.add(80);

        out.println("anotherSet is " + anotherSet);

//        final SetOfInts union = set.unionWith(anotherSet);
        final SetOfInts union = SetOfInts.unionOf(set, anotherSet);

        out.println("union is " + union);

        final SetOfInts intersection = set.intersectionWith(anotherSet);

        out.println("intersection is " + intersection);

//        out.println("set minus anotherSet is " + set.minus(anotherSet));
//        out.println("anotherSet minus set is " + anotherSet.minus(set));
//
//        out.println("union contains intersection is "
//                + union.contains(intersection));
//        out.println("intersection contains union is "
//                + intersection.contains(union));
//        out.println("set contains anotherSet is " + set.contains(anotherSet));
//        out.println("anotherSet contains set is " + anotherSet.contains(set));
//        out.println("set contains intersection is "
//                + set.contains(intersection));
//        out.println("anotherSet contains intersection is "
//                + anotherSet.contains(intersection));        
    }

}
