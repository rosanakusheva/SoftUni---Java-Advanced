package StreamsFilesAndDirectoriesEXERCISE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Merge2Files {
    public static void main(String[] args) throws IOException {
        String path1 = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String path2 = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";

        List<String> allLines1 = Files.readAllLines(Path.of(path1));
        List<String> allLines2 = Files.readAllLines(Path.of(path2));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (String line1 : allLines1) {
            writer.write(line1);
            writer.newLine();
        }

        for (String line2 : allLines2) {
            writer.write(line2);
            writer.newLine();
        }
        writer.close();
    }
}
