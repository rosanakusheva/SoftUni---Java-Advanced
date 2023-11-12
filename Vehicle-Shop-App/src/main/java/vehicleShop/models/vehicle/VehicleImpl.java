package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {
    private String name;
    private int strengthRequired;

    @Override
    public String getName() {
        return name;
    }

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.getStrengthRequired() == 0;
    }

    @Override
    public void making() {
        int currentNeededStrength = getStrengthRequired();
        currentNeededStrength -= 5;
        if (currentNeededStrength < 0) {
            currentNeededStrength = 0;
        }
        this.setStrengthRequired(currentNeededStrength);
    }
}
