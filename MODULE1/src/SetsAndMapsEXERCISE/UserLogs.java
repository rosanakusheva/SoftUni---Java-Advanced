package SetsAndMapsEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String user = input.split("\\s+")[2].split("=")[1];

            if (!data.containsKey(user)) {
                data.put(user, new LinkedHashMap<>());
            }

            Map<String, Integer> currentIPs = data.get(user);
            if (!currentIPs.containsKey(ip)) {
                currentIPs.put(ip, 1);
            } else {
                currentIPs.put(ip, currentIPs.get(ip) + 1);
            }

            input = scanner.nextLine();
        }

        for (String user : data.keySet()) {
            System.out.println(user + ": ");
            Map<String, Integer> currentIPs = data.get(user);
            int countIps = currentIPs.size();
            for (String ip : currentIPs.keySet()) {
                if (countIps == 1) {
                    System.out.println(ip + " => " + currentIPs.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + currentIPs.get(ip) + ", ");
                }
                countIps--;
            }

        }
    }
}
