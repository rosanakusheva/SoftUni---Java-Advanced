package DefiningClasses.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Car>> carsByCargoType = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j <= 12; j += 2) {
                Tire currentTire = new Tire(Double.parseDouble(data[j]), Integer.parseInt(data[j + 1]));
                tires.add(currentTire);
            }
            Car currentCar = new Car(carModel, engine, cargo, tires);
            carsByCargoType.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargoType.get(cargoType).add(currentCar);
        }

        String command = scanner.nextLine();
        carsByCargoType.get(command).forEach(car -> car.extract(command));

    }
}
