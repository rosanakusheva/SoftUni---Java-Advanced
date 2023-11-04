package Vehicles;

public class Bus extends BaseVehicle{
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String drive(double distance, boolean empty){
         this.setEmpty(empty);
         return super.drive(distance);
    }

    public void setEmpty(boolean empty) {
        if (!isEmpty && empty){
            this.fuelConsumption -= 1.4;
        }
        if (isEmpty && !empty){
            this.fuelConsumption += 1.4;
        }
        this.fuelConsumption = this.fuelConsumption - 1.4;
        isEmpty = empty;
    }
}
