package pt.europeia.eda.javaslides.presentation13;

public class Circle extends Shape {

    private double radius;

    public Circle(final Position position, final double radius) {
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
        return new Box(new Position(getPosition().getX() - getRadius(),
                getPosition().getY() - getRadius()), new Size(
                2.0 * getRadius(), 2.0 * getRadius()));
    }

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