package FunctionalProgrammingLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int firstNum = Integer.parseInt(array[0]);
        int secondNum = Integer.parseInt(array[1]);

        String numType = scanner.nextLine();

        Predicate<Integer> predicate;
        List<Integer> nums = new ArrayList<>();

        for (int i = firstNum; i <= secondNum; i++) {
            nums.add(i);
        }

        if (numType.equals("even")) {
            predicate = (num) -> num % 2 == 0;
        } else {
            predicate = (num) -> num % 2 != 0;
        }

        nums.stream()
                .filter(predicate)
                .forEach(num -> System.out.print(num + " "));
    }
}
