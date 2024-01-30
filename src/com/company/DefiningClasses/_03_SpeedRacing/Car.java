package com.company.DefiningClasses._03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelPer1km;
    private double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelPer1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1km = fuelPer1km;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPer1km() {
        return fuelPer1km;
    }

    public void setFuelPer1km(double fuelPer1km) {
        this.fuelPer1km = fuelPer1km;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %.2f", this.getModel(), this.getFuelAmount(), this.getDistanceTravelled());
    }
}
