package StreamsFilesAndDirectoriesEXERCISE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathIn));

        int vowelsCount = 0;
        int punctCount = 0;
        int consonantsCount = 0;

        Set<Character> vowels = getVowels();
        Set<Character> punctuationalMarks = getPuntMarks();

        for (String line : allLines) {

            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }

                if (vowels.contains(currentSymbol)) {
                    vowelsCount++;
                } else if (punctuationalMarks.contains(currentSymbol)) {
                    punctCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + consonantsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctCount);
        writer.close();

    }

    private static Set<Character> getPuntMarks() {
        Set<Character> marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add('.');
        marks.add(',');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}



