package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
         String pathIn = "resources/input.txt";
         String pathOut = "resources/06.SortLinesOutput.txt";

         Path input = Paths.get(pathIn);
         Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);

        Files.write(output, lines);
        System.out.println();

    }
}
