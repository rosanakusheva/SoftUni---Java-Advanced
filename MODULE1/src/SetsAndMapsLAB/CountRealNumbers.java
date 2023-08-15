package SetsAndMapsLAB;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (occurrences.containsKey(numbers[i])){

                int currentOccurrences = occurrences.get(numbers[i]);
                currentOccurrences++;
                occurrences.put(numbers[i], currentOccurrences);

            } else {

                occurrences.put(numbers[i], 1);
            }
        }

        for (Double number : occurrences.keySet()){
            System.out.printf("%.1f -> %d%n", number, occurrences.get(number));
        }
    }
}
