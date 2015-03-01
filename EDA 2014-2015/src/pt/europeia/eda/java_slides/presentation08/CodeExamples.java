package pt.europeia.eda.java_slides.presentation08;

import static java.lang.System.out;

public class CodeExamples {

    public static void main(final String[] arguments) {
        testValueTypes();
        testReferenceTypes();
        testString();
    }

    public static void testValueTypes() {
        final int a = 7;
        final int b = a;

        out.println("a == b is " + (a == b));
    }

    public static void testReferenceTypes() {
        // Classes are reference types. After initialization, a and b reference
        // instances which are not the same, though they are equal. After
        // initialization, c references the same instance as b:
        Point a = new Point(3.0, 4.0);
        Point b = new Point(3.0, 4.0);
        Point c = b;

        // By default, printing of classes produces a "strange" result:
        out.println("a is " + a);
        out.println("b is " + b);
        out.println("c is " + c);

        // Operator == checks identity, that is, whether both operands refer to
        // the same instance, returning false if the references refer not to the
        // same instance, even if these instances are equal:
        out.println("a == b is " + (a == b));
        out.println("b == c is " + (b == c));
    }

    public static void testString() {
        // Avoid this:
        final String someName = new String("Mário");

        out.println("someName is " + someName);

        // Use String literals instead, without constructing a new String:
        final String name = "Mário";

        out.println("name is " + name);

        // Strings have length and can be indexed:
        final int length = name.length();

        final char lastCharacter = name.charAt(4);

        out.println("length is " + length);
        out.println("lastCharacter is " + lastCharacter);

        // It is possible to obtain parts of strings (substrings):
        String anotherName = "Mário Sá";

        String firstName = anotherName.substring(0, 5);
        String lastName = anotherName.substring(6);

        out.println("anotherName is " + anotherName);
        out.println("firstName is " + firstName);
        out.println("lastName is " + lastName);

        // Strings can be concatenated using a method or using the + operator:
        final String newName = firstName.concat(" Pi");
        final String anotherNewName = firstName + " Pi";

        out.println("newName is " + newName);
        out.println("anotherNewName is " + anotherNewName);

        // String is a class and thus a reference type. Variables store
        // references to the strings themselves. The == operator checks for the
        // identity of the referenced instances, not their equality. Equality is
        // tested using the equals() operation():
        String a = "A";
        String b = "A";
        String c = new String("A");
        String d = c;

        out.println("a == b is " + (a == b));
        out.println("a == c is " + (a == c));
        out.println("c == d is " + (c == d));

        out.println("a.equals(b) is " + a.equals(b));
        out.println("a.equals(c) is " + a.equals(c));
        out.println("c.equals(d) is " + c.equals(d));
    }

}
