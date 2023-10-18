package ExamPREP;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vowelsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(consonantsStack::push);

        List<String> words = List.of("pear", "flour", "pork", "olive");
        List<String> foundWords = new ArrayList<>(List.of("____", "_____", "____", "_____"));

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i);
                String emptyWord = foundWords.get(i);

                if (currentWord.contains(vowel)) {
                    int index = currentWord.indexOf(vowel);
                    emptyWord = emptyWord.substring(0, index) + vowel + emptyWord.substring(index + 1);
                    foundWords.set(i, emptyWord);
                }

                if (currentWord.contains(consonant)) {
                    int index = currentWord.indexOf(consonant);
                    emptyWord = emptyWord.substring(0, index) + consonant + emptyWord.substring(index + 1);
//                    StringBuilder sb = new StringBuilder(emptyWord);
//                    sb.setCharAt(index, vowel.charAt(0));
//                    emptyWord = sb.toString();
                    foundWords.set(i, emptyWord);
                }

            }
            vowelsQueue.offer(vowel);

        }
        List<String> result = foundWords.stream()
                .filter(word -> !word.contains("_"))
                .collect(Collectors.toList());
        System.out.printf("Words found: %d%n", result.size());
        result.forEach(System.out::println);
    }
}
