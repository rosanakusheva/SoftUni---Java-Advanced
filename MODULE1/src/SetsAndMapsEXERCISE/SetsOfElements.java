package SetsAndMapsEXERCISE;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int sizeFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int sizeSecondSet = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 1; i <= sizeFirstSet; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }

        for (int i = 1; i <= sizeSecondSet; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }

//        Set<Integer> duplicateElements = new LinkedHashSet<>();
//        for (int number : firstSet){
//            if (secondSet.contains(number)){
//                duplicateElements.add(number);
//            }
//        }
//        duplicateElements.forEach(System.out::println);

        firstSet.retainAll(secondSet);
        firstSet.forEach(element -> System.out.print(element + " "));


    }
}
