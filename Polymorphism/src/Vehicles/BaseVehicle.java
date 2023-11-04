package Vehicles;

import java.text.DecimalFormat;

public class BaseVehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;


    public BaseVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }


    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded > this.fuelQuantity){
            if (this instanceof Car){
                return ("Car needs refueling");
            } else {
                return ("Truck needs refueling");
            }
        }
        this.fuelQuantity = this.fuelQuantity - fuelNeeded;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));

    }


    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String toString(){
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
