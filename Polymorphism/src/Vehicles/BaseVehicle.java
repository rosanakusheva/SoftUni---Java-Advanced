package Vehicles;

import java.text.DecimalFormat;

public class BaseVehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;


    public BaseVehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
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
        if (liters <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (liters > this.tankCapacity - this.fuelQuantity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += liters;
    }


    public String toString(){
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
