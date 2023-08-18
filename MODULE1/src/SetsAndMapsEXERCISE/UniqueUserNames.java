package SetsAndMapsEXERCISE;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> words = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {

            String word = scanner.nextLine();
            words.add(word);

        }

        words.forEach(System.out::println);

    }
}
