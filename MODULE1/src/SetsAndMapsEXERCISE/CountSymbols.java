package SetsAndMapsEXERCISE;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i <= text.length() - 1; i++) {
            char currentSymbol = text.charAt(i);

            if (symbolsCount.containsKey(currentSymbol)) {
                int currentCount = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentCount + 1);
            } else {
                symbolsCount.put(currentSymbol, 1);
            }
        }
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " " + "time/s"));
    }
}
