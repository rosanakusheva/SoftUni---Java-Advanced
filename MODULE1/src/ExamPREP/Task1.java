package ExamPREP;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuelInfo = scanner.nextLine();
        String consumptionInfo = scanner.nextLine();
        String neededFuelInfo = scanner.nextLine();

        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        ArrayDeque<Integer> consumptionQueue = new ArrayDeque<>();
        ArrayDeque<Integer> amountFuelNeededQueue = new ArrayDeque<>();
//        Map<String, Integer> altitudeMap = new LinkedHashMap<>();

        Arrays.stream(fuelInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(fuelStack::push);

        Arrays.stream(consumptionInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(consumptionQueue::offer);

        Arrays.stream(neededFuelInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(amountFuelNeededQueue::offer);

        int altitudeCount = 0;
        boolean isTopReached = true;
        while (true) {
            if (fuelStack.isEmpty()) {
                break;
            }
            int fuel = fuelStack.peek();
            int consumption = consumptionQueue.peek();
            int fuelNeeded = amountFuelNeededQueue.peek();

            int result = fuel - consumption;
            if (result >= fuelNeeded) {
                altitudeCount++;
                System.out.printf("John has reached: Altitude %d", altitudeCount);
                System.out.println();
                fuelStack.pop();
                consumptionQueue.poll();
                amountFuelNeededQueue.poll();
            } else {
                System.out.printf("John did not reach: Altitude %d", altitudeCount + 1);
                System.out.println();
                isTopReached = false;
                break;
            }
        }

        if (!isTopReached && altitudeCount > 0) {
            System.out.println("John failed to reach the top.");
            StringBuilder builder = new StringBuilder();
            builder.append("Reached altitudes: Altitude ");
            for (int i = 1; i <= altitudeCount; i++) {
                builder.append(i).append(", Altitude ");
            }
            String format = builder.substring(0, builder.length()-11);
            System.out.println(format);
        }

        if (!isTopReached && altitudeCount == 0) {
            System.out.println("John failed to reach the top.\n" +
                    "John didn't reach any altitude.");
        }

        if (isTopReached) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
    }
}
