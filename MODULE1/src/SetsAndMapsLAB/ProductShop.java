package SetsAndMapsLAB;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {

            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).putIfAbsent(product, 0.0);
            shops.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : shops.entrySet()) {
            System.out.println(entry.getKey() + "->");

            for (Map.Entry<String, Double> entry2 : entry.getValue().entrySet()) {
                System.out.println("Product: " + entry2.getKey() + ", Price: " + String.format("%.1f", entry2.getValue()));
            }
        }
    }
}
