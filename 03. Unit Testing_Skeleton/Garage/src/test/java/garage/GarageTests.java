package test.java.garage;

import main.java.garage.Car;
import main.java.garage.Garage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    //TODO: Test Garage class

    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
    }

    @Test
    public void testAddCarSuccessful() {
        Assert.assertEquals(0, this.garage.getCount());
        Car car = new Car("Skoda", 220, 65000);

        this.garage.addCar(car);

        List<Car> carsInGarage = this.garage.getCars();
        Assert.assertEquals(car, carsInGarage.get(0));
        Assert.assertEquals(1, this.garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowsExceptionForNullCar() {
        this.garage.addCar(null);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car carSkodaKaroq = new Car("Skoda", 220, 65000);
        Car carSkodaKodiaq = new Car("Skoda", 250, 79000);
        Car carSkodaKamiq = new Car("Skoda", 190, 40000);
        Car carFordKuga = new Car("Ford", 200, 45000);

        this.garage.addCar(carSkodaKaroq);
        this.garage.addCar(carSkodaKodiaq);
        this.garage.addCar(carSkodaKamiq);
        this.garage.addCar(carFordKuga);

        List<Car> returnedCars = this.garage.findAllCarsByBrand("Skoda");
        Assert.assertEquals(3, returnedCars.size());
        Assert.assertEquals(carSkodaKaroq, returnedCars.get(0));
        Assert.assertEquals(carSkodaKodiaq, returnedCars.get(1));
        Assert.assertEquals(carSkodaKamiq, returnedCars.get(2));
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car carSkodaKaroq = new Car("Skoda", 220, 65000);
        Car carSkodaKodiaq = new Car("Skoda", 250, 79000);
        Car carSkodaKamiq = new Car("Skoda", 190, 40000);
        Car carFordKuga = new Car("Ford", 200, 45000);

        this.garage.addCar(carSkodaKaroq);
        this.garage.addCar(carSkodaKodiaq);
        this.garage.addCar(carSkodaKamiq);
        this.garage.addCar(carFordKuga);

        List<Car> returnedCars = this.garage.findAllCarsWithMaxSpeedAbove(200);
        Assert.assertEquals(1, returnedCars.size());
        Assert.assertEquals(carSkodaKaroq, returnedCars.get(0));
        Assert.assertEquals(carSkodaKodiaq, returnedCars.get(1));
    }

    @Test
    public void testGetMostExpensiveCar() {
        Car carSkodaKaroq = new Car("Skoda", 220, 65000);
        Car carSkodaKodiaq = new Car("Skoda", 250, 79000);
        Car carSkodaKamiq = new Car("Skoda", 190, 40000);
        Car carFordKuga = new Car("Ford", 200, 45000);
        this.garage.addCar(carSkodaKaroq);
        this.garage.addCar(carSkodaKodiaq);
        this.garage.addCar(carSkodaKamiq);
        this.garage.addCar(carFordKuga);

        Car mostExpensiveCar = this.garage.getTheMostExpensiveCar();
        Assert.assertEquals("Skoda", mostExpensiveCar.getBrand());
        Assert.assertEquals(250, mostExpensiveCar.getMaxSpeed());
        Assert.assertEquals(79000, mostExpensiveCar.getPrice(), 0.01);
    }

    @Test
    public void testGetCars(){

    }


}