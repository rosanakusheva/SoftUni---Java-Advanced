package ExamPREP;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textilesInfo = scanner.nextLine();
        String medicamentsInfo = scanner.nextLine();

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();

        Map<String, Integer> stashMap = new HashMap<>();
        stashMap.put("Patch", 0);
        stashMap.put("Bandage", 0);
        stashMap.put("MedKit", 0);

        Arrays.stream(textilesInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> textiles.offer(e));

        Arrays.stream(medicamentsInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> medicaments.push(e));


        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.peek();
            int medicament = medicaments.peek();

            int sum = textile + medicament;
            if (sum == 30) {
                int currentPatches = stashMap.get("Patch");
                currentPatches++;
                stashMap.put("Patch", currentPatches);
                textiles.poll();
                medicaments.pop();
            } else if (sum == 40) {
                int currentBandages = stashMap.get("Bandage");
                currentBandages++;
                stashMap.put("Bandage", currentBandages);
                textiles.poll();
                medicaments.pop();
            } else if (sum == 100) {
                int currentMedKits = stashMap.get("MedKit");
                currentMedKits++;
                stashMap.put("MedKit", currentMedKits);
                textiles.poll();
                medicaments.pop();

            } else if (sum > 100) {
                int currentMedKits = stashMap.get("MedKit");
                currentMedKits++;
                stashMap.put("MedKit", currentMedKits);
                textiles.poll();
                medicaments.pop();
                int remainder = sum - 100;
                int nextMed = medicaments.pop();
                int result = nextMed + remainder;
                medicaments.push(result);
            } else {
                textiles.poll();
                medicament = medicament + 10;
                int newMedicament = medicament;
                medicaments.pop();
                medicaments.push(newMedicament);
            }

        }

        if (textiles.isEmpty() && !medicaments.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty() && !textiles.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles and medicaments are both empty.");
        }

        if (stashMap.get("Patch") != 0 || stashMap.get("Bandage") != 0 || stashMap.get("MedKit") != 0) {
            List<Map.Entry<String, Integer>> orderedItems =
                    new ArrayList<>(stashMap.entrySet());
            Collections.sort(orderedItems,
                    Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
                            thenComparing(Map.Entry<String, Integer>::getKey));

            for (Map.Entry<String, Integer> item : orderedItems) {
                if (item.getValue() != 0) {
                    System.out.println(item.getKey() + " - " + item.getValue());
                }
            }

        }
        if (!medicaments.isEmpty()) {
            System.out.print("Medicaments left: ");
            String val = String.join(", ", Arrays.toString(medicaments.toArray()).replaceAll("\\[", "").replaceAll("]", ""));
            System.out.printf("%s%n", val);
        }
        if (!textiles.isEmpty()) {
            System.out.print("Textiles left: ");
            String val = String.join(", ", Arrays.toString(textiles.toArray()).replaceAll("\\[", "").replaceAll("]", ""));
            System.out.printf("%s%n", val);
        }
    }
}
