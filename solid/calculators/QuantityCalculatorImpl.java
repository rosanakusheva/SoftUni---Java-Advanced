package solid.calculators;

import solid.Product;
import solid.products.drinks.Drink;
import solid.products.food.Food;

import java.util.List;

public class QuantityCalculatorImpl implements Calculator {
    @Override
    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            if (product instanceof Drink) {
                sum += ((Drink) product).getLiters() * ((Drink) product).getDensity();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
