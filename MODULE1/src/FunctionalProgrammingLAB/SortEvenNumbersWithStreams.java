package FunctionalProgrammingLAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbersWithStreams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringNumbers = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(stringNumbers)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));

        evenNumbers = evenNumbers
                .stream()
                .map(e -> Integer.parseInt(e))
                .sorted((left, right) -> left.compareTo(right))
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));
    }

//    Scanner scanner = new Scanner(System.in);
//
//    String[] stringNumbers = scanner.nextLine().split(", ");
//    int[] numbers = new int[stringNumbers.length];
//
//        for (int i = 0; i < stringNumbers.length; i++) {
//        numbers[i] = Integer.parseInt(stringNumbers[i]);
//    }
//
//    List<Integer> evenNumbers = new ArrayList<>();
//        for (int i = 0; i < numbers.length; i++) {
//        if (numbers[i] % 2 == 0) {
//            evenNumbers.add(numbers[i]);
//        }
//    }
//    List<String> evenNumbersAsStrings = new ArrayList<>();
//        for (int i = 0; i < evenNumbers.size(); i++) {
//        evenNumbersAsStrings.add(String.valueOf(evenNumbers.get(i)));
//    }
//
//        System.out.println(String.join(", ", evenNumbersAsStrings));
//}
}
