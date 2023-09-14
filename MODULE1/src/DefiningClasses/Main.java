package DefiningClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            Car car = data.length == 1
                    ? new Car(data[0])
                    : new Car(data[0], data[1], Integer.parseInt(data[2]));

            cars.add(car);
        }
        for (Car car : cars){
            System.out.println(car);
        }
//        Car impala = new Car("Chevrolet", "Impala", 390);
//
//        impala.setBrand("Chevrolet");
//        impala.setModel("Impala");
//        impala.setHorsePower(390);
//
////        System.out.printf("The car is: %s %s - %d HP.", impala.brand, impala.model, impala.horsePower);
//        System.out.println(impala.toString());
    }
}
