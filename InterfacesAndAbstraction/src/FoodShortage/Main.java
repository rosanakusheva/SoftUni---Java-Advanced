package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] buyerParts = input.split("\\s+");

            String name = buyerParts[0];
            int age = Integer.parseInt(buyerParts[1]);
            String group = buyerParts[2];

            if (buyerParts.length == 3) {
                Rebel rebel = new Rebel(name);
                buyers.put(name, rebel);
            } else {
                Citizen citizen = new Citizen(name);
                buyers.put(name, citizen);
            }
        }
        String buyerName = scanner.nextLine();
        while (!buyerName.equals("End")) {
            Buyer buyer = buyers.get(buyerName);

            if (buyer != null) {
                buyer.buyFood();
            }

            buyerName = scanner.nextLine();
        }

        int totalFood = buyers.values().stream()
                .mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);

    }
}
