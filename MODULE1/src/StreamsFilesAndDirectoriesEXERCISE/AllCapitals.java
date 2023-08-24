package StreamsFilesAndDirectoriesEXERCISE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));


        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}
