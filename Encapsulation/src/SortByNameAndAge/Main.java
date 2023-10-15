package SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(scanner.nextLine());
            people.add(new Person(firstName, lastName, age, salary));
        }

//        Collections.sort(people, (firstPerson, secondPerson) -> {
//            int comparisonResult = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
//
////            if (comparisonResult == 0){
////                comparisonResult = Integer.compare(firstPerson.getAge(), secondPerson.getAge());
////            }
////            return comparisonResult;
//
//            if (comparisonResult != 0) {
//                return comparisonResult;
//            } else {
//                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
//            }
//        });
        double bonus = Double.parseDouble(scanner.nextLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }

    }
}
