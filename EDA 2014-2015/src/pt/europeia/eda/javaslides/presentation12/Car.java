package pt.europeia.eda.javaslides.presentation12;

import java.time.LocalDate;

public class Car {
    private String licenseNumber;
    private String model;
    private int yearBuilt;
    private LocalDate lastInspectionDate;

    public Car(final String licenseNumber, final String model,
            final int yearBuilt, final LocalDate lastInspectionDate) {
        this.licenseNumber = licenseNumber;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.lastInspectionDate = lastInspectionDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public int getYearAge() {
        // TODO Complete Car.getYearAge().
        return 0;
    }

    public LocalDate getLastInspectionDate() {
        return lastInspectionDate;
    }

    public LocalDate getNextInspectionDate() {
        // TODO Complete Car.getNextInspectionDate().
        return null;
    }

    public boolean isInspected() {
        // TODO Complete Car.getNextInspectionDate().
        return true;
    }

    @Override
    public String toString() {
        return "Car (model: " + model + ", license: " + licenseNumber
                + ", year: " + yearBuilt + ", inspected: " + lastInspectionDate
                + ")";
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