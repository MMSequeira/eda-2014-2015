package pt.europeia.eda.java_slides.presentation12;

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
