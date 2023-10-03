import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutumnCocktails {
    private static final int PEAR_SOUR = 150;
    private static final int THE_HARVEST = 250;
    private static final int HIGH_FASHION = 400;
    private static final int APPLE_HINNY = 300;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cocktails = new HashMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(); //queue
        for (String token : tokens) {
            ingredients.offer(Integer.parseInt(token));
        }

        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> freshness = new ArrayDeque<>(); //stack
        for (String token : tokens) {
            freshness.push(Integer.parseInt(token));
        }

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            Integer firstIngredient = ingredients.poll();

            if (firstIngredient == 0) {
                continue;
            }

            Integer lastFreshness = freshness.pop();
            int totalLevel = firstIngredient * lastFreshness;

            switch (totalLevel) {
                case PEAR_SOUR:
                    int currentPearSours = cocktails.get("Pear Sour");
                    currentPearSours++;
                    cocktails.put("Pear Sour", currentPearSours);
                    break;
                case THE_HARVEST:
                    int currentTheHarvests = cocktails.get("The Harvest");
                    currentTheHarvests++;
                    cocktails.put("The Harvest", currentTheHarvests);
                    break;
                case APPLE_HINNY:
                    int currentAppleHinnies = cocktails.get("Apple Hinny");
                    currentAppleHinnies++;
                    cocktails.put("Apple Hinny", currentAppleHinnies);
                    break;
                case HIGH_FASHION:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;
                default:
                    firstIngredient += 5;
                    ingredients.offer(firstIngredient);
                    break;
            }

        }

        if (!ingredients.isEmpty()) {
//            int leftoverIngredients = ingredients.stream().mapToInt(e -> e).sum();
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }

            System.out.printf("Ingredients left: %d%n", sum);
        }

        if (cocktails.get("Pear Sour") > 0 && cocktails.get("Apple Hinny") > 0 && cocktails.get("The Harvest") > 0 && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }

        if (cocktails.get("High Fashion") > 0) {
            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
        }

        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }

        if (cocktails.get("The Harvest") > 0) {
            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
        }


    }
}
