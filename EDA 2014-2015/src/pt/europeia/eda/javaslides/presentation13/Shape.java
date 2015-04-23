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