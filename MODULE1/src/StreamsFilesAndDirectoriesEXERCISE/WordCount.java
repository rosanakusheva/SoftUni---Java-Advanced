package StreamsFilesAndDirectoriesEXERCISE;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLinesWithWords) {
            String[] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }

        String pathTextToSearch = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        List<String> allLinesFromText = Files.readAllLines(Path.of(pathTextToSearch));

        for (String line : allLinesFromText) {
            line = line.replaceAll("[\\.\\,\\!\\?\\:]", "");
            String[] wordsInCurrentLine = line.split("\\s+");
            for (String word : wordsInCurrentLine) {
                if (countWords.containsKey(word)){
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }
        PrintWriter writer = new PrintWriter("result.txt");
        countWords.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();

    }
}
