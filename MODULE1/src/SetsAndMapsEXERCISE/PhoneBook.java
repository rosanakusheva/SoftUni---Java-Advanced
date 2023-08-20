package SetsAndMapsEXERCISE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String text = scanner.nextLine();

        while (!text.equals("search")) {
            String person = text.split("-")[0];
            String phoneNumber = text.split("-")[1];
            phonebook.put(person, phoneNumber);

            text = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }
    }
}
