package StacksAndQueuesEXERCISE;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] robotsData = input.split(";");

        LinkedHashMap<String, Integer> robotsMap = getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkTime = getRobotsWorkTime(robotsData);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkTime);
            boolean isTaken = false;
            for (Map.Entry<String, Integer> robot : robotsWorkTime.entrySet()) {
                if (robot.getValue() == 0) {
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkTime.put(robot.getKey(), robotsMap.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct  );
            }
        }


    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkTime.entrySet()){
            if (robot.getValue() > 0 ){
                robotsWorkTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkTime(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            robots.put(robotName, 0);
        }
        return robots;
    }

    private static int getTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        return startTimeInSeconds;
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        if (hours >= 24){
            hours -= 24;
        }
        return String.format("%02d:%02d:%02d",hours, minutes, seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processingTine = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, processingTine);
        }
        return robots;
    }
}
