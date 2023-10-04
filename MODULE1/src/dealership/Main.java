package dealership;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "XC90", 2020);
        Car car2 = new Car("BMV", "X5", 2003);
        Car car3 = new Car("Mercedes", "A5", 2019);

        Dealership dealership = new Dealership("SoftUni", 5);
        dealership.add(car1);
        dealership.add(car2);
        dealership.add(car3);

        System.out.println(dealership.buy("Volvo", "XC90"));
        System.out.println(dealership.getCar("VW", "Passat"));


    }
}
