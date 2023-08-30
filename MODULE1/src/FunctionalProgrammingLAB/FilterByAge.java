package FunctionalProgrammingLAB;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= peopleCount; i++) {
            String[] personData = scanner.nextLine().split(", ");
            String name = personData[0];
            int personAge = Integer.parseInt(personData[1]);

            people.put(name, personAge);
        }

        String comparison = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;
        if (comparison.equals("younger")) {
            filterPredicate = (personAge, age) -> personAge <= age;
        } else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;
        if (printType.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else if (printType.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else {
            printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

//        people.keySet().stream();
//        people.values().stream();
        people.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);

    }
}
