package pt.europeia.eda.java_slides.presentation13;

public class Supervisor extends Employee {

    private int level;

    public Supervisor(final String name, 
                      final String ssn,
                      final int level) {
        super(name, ssn);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getSsn() + ", " 
               + getLevel() + ")";
    }
    
}