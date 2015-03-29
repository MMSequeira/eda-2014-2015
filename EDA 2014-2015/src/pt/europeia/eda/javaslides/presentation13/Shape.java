package pt.europeia.eda.javaslides.presentation13;

public abstract class Shape {

    private Position position;

    public Shape(final Position position) {
        this.position = position;
    }

    public final Position getPosition() {
        return position;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract Box getBoundingBox();

    public void moveTo(final Position newPosition) {
        position = newPosition;
    }

}
