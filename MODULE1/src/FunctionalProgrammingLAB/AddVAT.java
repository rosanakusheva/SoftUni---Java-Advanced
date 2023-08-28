package FunctionalProgrammingLAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");
        UnaryOperator<Double> addVAT = e -> 1.2 * e;
        Consumer<Double> printer = e -> System.out.printf("%.2f%n", e);

        System.out.printf("Prices with VAT:%n");
        Arrays.stream(prices)
                .map(e -> Double.parseDouble(e))
                .map(addVAT)
                .forEach(printer);
    }
}
