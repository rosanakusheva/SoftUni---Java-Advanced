package SetsAndMapsEXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueElements = new TreeSet<>();

        for (int i = 1; i <= n ; i++) {
            String []chemicalElements = scanner.nextLine().split("\\s+");

            for (String element : chemicalElements){
                uniqueElements.add(element);
            }
//            uniqueElements.addAll(Arrays.asList(chemicalElements));
        }
        uniqueElements.forEach(el -> System.out.print(el + " "));
    }
}
