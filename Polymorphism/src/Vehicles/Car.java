package Vehicles;

public class Car extends BaseVehicle {
    private static final double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_AC_CONSUMPTION;
//        this.setFuelConsumption(this.getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }
}
