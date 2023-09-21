package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
             String[] data = scanner.nextLine().split("\\s+");

             String firstName = data[0];
             int age = Integer.parseInt(data[1]);

             Person person = new Person(firstName, age);
             people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()) )
                .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
    }

}
