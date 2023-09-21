package DefiningClasses.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, Cat> cats = new HashMap<>();

        while (!input.equals("End")) {
            String[] catData = input.split("\\s+");

            String catBreed = catData[0];
            String catName = catData[1];
            Cat cat = null;

            if (catBreed.equals("Siamese")) {
                double earSize = Double.parseDouble(catData[2]);
                cat = new Siamese(catName, earSize);

            } else if (catBreed.equals("StreetExtraordinaire")) {
                double decibels = Double.parseDouble(catData[2]);
                cat = new StreetExtraordinaire(catName, decibels);

            } else if (catBreed.equals("Cymric")) {
                double furLength = Double.parseDouble(catData[2]);
                cat = new Cymric(catName, furLength);

            }
            cats.put(catName, cat);
             input = scanner.nextLine();

        }

        String catNameToSearch = scanner.nextLine();

        if (cats.containsKey(catNameToSearch)){
            System.out.println(cats.get(catNameToSearch));
        }
    }
}
