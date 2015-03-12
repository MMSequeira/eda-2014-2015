package pt.europeia.eda.java_slides.presentation13;

public class Circle extends Shape {

    private double radius;

    public Circle(final Position position,
                  final double radius) {
        super(position);
        this.radius = radius;
    }

    public final double getRadius() { 
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * getRadius();
    }

    @Override
    public Box getBoundingBox() {
        return new Box(
            new Position(getPosition().getX() - getRadius(),
                         getPosition().getY() - getRadius()),
            new Size(2.0 * getRadius(), 2.0 * getRadius())
        );
    }
}
