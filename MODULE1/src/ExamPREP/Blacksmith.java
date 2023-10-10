package ExamPREP;

import java.util.*;

public class Blacksmith {
    private static final int GLADIUS = 70;
    private static final int SHAMSHIR = 80;
    private static final int KATANA = 90;
    private static final int SABRE = 110;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> swordsMap = new TreeMap<>();
        swordsMap.put("Gladius", 0);
        swordsMap.put("Shamshir", 0);
        swordsMap.put("Katana", 0);
        swordsMap.put("Sabre", 0);

        String steelInfo = scanner.nextLine();
        String carbonInfo = scanner.nextLine();

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(steelInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(carbonInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(carbonStack::push);

        int totalSwords = 0;
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.peek();
            int carbon = carbonStack.peek();

            int sum = steel + carbon;

            if (sum == GLADIUS) {
                int currentGladiuses = swordsMap.get("Gladius");
                currentGladiuses++;
                totalSwords++;
                swordsMap.put("Gladius", currentGladiuses);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == SHAMSHIR) {
                int currentShamshirs = swordsMap.get("Shamshir");
                currentShamshirs++;
                totalSwords++;
                swordsMap.put("Shamshir", currentShamshirs);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == KATANA) {
                int currentKatanas = swordsMap.get("Katana");
                currentKatanas++;
                totalSwords++;
                swordsMap.put("Katana", currentKatanas);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == SABRE) {
                int currentSabres = swordsMap.get("Sabre");
                currentSabres++;
                totalSwords++;
                swordsMap.put("Sabre", currentSabres);
                steelQueue.poll();
                carbonStack.pop();
            } else {
                steelQueue.poll();
                int newCarbon = carbonStack.pop() + 5;
                carbonStack.push(newCarbon);
            }
        }

        if (totalSwords != 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            String val = String.join(", ", Arrays.toString(steelQueue.toArray()));
            System.out.print(val);
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            String val = String.join(", ", Arrays.toString(carbonStack.toArray()).replaceAll("\\[", "").replaceAll("]", ""));
            System.out.print(val);

        }

//        swordsMap.entrySet().stream()
//                .filter(e -> e.getValue() != 0)
//                .forEach(el -> System.out.println(el.getKey() + ": " + el.getValue()));

        if (swordsMap.get("Gladius") != 0) {
            System.out.printf("Gladius: %d%n", swordsMap.get("Gladius"));
        }

        if (swordsMap.get("Katana") != 0) {
            System.out.println();
            System.out.printf("Katana: %d%n", swordsMap.get("Katana"));
        }

        if (swordsMap.get("Sabre") != 0) {
            System.out.printf("Sabre: %d%n", swordsMap.get("Sabre"));
        }

        if (swordsMap.get("Shamshir") != 0) {
            System.out.printf("Shamshir: %d%n", swordsMap.get("Shamshir"));
        }

    }
}
