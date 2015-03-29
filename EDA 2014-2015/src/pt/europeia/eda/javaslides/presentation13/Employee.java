package pt.europeia.eda.javaslides.presentation13;

public class Employee /* extends Object */ {

    private String name;
    private String ssn;

    public Employee(final String name, final String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getSsn() + ")";
    }

}


