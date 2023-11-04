package Vehicles;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

         BaseVehicle car = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");
        BaseVehicle truck = createVehicle(tokens);

        Map<String, BaseVehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case " Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);

                    break;

            }

        }
        vehicles.values().forEach(System.out::println);

    }

    private static BaseVehicle createVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        BaseVehicle  baseVehicle = null;
        switch (vehicleType){
            case "Car":
                baseVehicle = new Car(fuelQuantity, fuelConsumption);
                break;
            case "Truck":
               baseVehicle = new Truck(fuelQuantity, fuelConsumption);
               break;
        }
        return baseVehicle;

    }
}
