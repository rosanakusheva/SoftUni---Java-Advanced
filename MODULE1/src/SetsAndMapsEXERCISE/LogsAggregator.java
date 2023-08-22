
package SetsAndMapsEXERCISE;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> userDuration = new TreeMap<>();
        Map<String, TreeSet<String>> usersAddresses = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            String ip = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            Integer duration = Integer.parseInt(input.split("\\s+")[2]);

            if (!userDuration.containsKey(user)) {
                userDuration.put(user, duration);
                usersAddresses.put(user, new TreeSet<>(){{add(ip);}});

            } else {
                userDuration.put(user, userDuration.get(user) + duration);
                usersAddresses.get(user).add(ip);
            }

        }
        // user}: {duration} [{IP1}, {IP2}, ...]
        userDuration.forEach((key, value) ->{

            System.out.println(String.format("%s: %d %s", key, value, usersAddresses.get(key).toString()));

        });
    }
}
