package pt.europeia.eda.java_slides.presentation10;

public class Point {

    private final double abscissa;
    private final double ordinate;

    public Point(final double abscissa, final double ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public Point(final Point other) {
        abscissa = other.getAbscissa();
        ordinate = other.getOrdinate();
    }

    public double getAbscissa() {
        return abscissa;
    }

    public double getOrdinate() {
        return ordinate;
    }

    public double getRadius() {
        return Math.sqrt(abscissa * abscissa + ordinate * ordinate);
    }

    public double getAngle() {
        return Math.atan2(ordinate, abscissa);
    }

    public boolean isEqualTo(final Point other) {
        return getAbscissa() == other.getAbscissa()
                && getOrdinate() == other.getOrdinate();
    }

    @Override
    public String toString() {
        return "(" + getAbscissa() + ", " + getOrdinate() + ")";
    }
}

// public class Point {
//
// private final double rho;
// private final double theta;
//
// public Point(final double abscissa, final double ordinate) {
// rho = Math.sqrt(abscissa * abscissa + ordinate * ordinate);
// theta = Math.atan2(ordinate, abscissa);
// }
//
// public Point(final Point other) {
// rho = other.getRho();
// theta = other.getAngle();
// }
//
// public double getAbscissa() {
// return rho * Math.cos(theta);
// }
//
// public double getOrdinate() {
// return rho * Math.sin(theta);
// }
//
// public double getRadius() {
// return rho;
// }
//
// public double getAngle() {
// return theta;
// }
//
// }
