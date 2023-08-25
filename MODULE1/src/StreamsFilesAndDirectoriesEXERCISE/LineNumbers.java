package StreamsFilesAndDirectoriesEXERCISE;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathIn));

        PrintWriter writer = new PrintWriter("output.txt");

        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }
        writer.close();

    }
}
