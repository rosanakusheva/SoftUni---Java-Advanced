package Vehicles;

public class Truck extends BaseVehicle {
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = this.fuelConsumption + AC_ADDITIONAL_CONSUMPTION;
    }

    @Override
    public void refuel(double liters) {
        liters = liters * REFUEL_PERCENTAGE; // reduce with 5%
        super.refuel(liters);
//        this.fuelQuantity += liters;
    }

}
