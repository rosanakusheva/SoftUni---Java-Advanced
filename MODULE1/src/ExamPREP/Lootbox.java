package ExamPREP;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        String input2 = scanner.nextLine();
        Arrays.stream(input2.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);

//        List<Integer> loot = new ArrayList<>();
        int loot = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.peek();

            int sum = firstBoxItem + secondBoxItem;
            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                secondBoxStack.pop();
                loot += sum;
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondBoxItem);
            }
        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (loot >= 100){
            System.out.printf("Your loot was epic! Value: %s", loot);
        } else {
            System.out.printf("Your loot was poor... Value: %d", loot);
        }


    }
}
