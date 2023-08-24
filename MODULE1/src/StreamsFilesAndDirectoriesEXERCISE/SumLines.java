package StreamsFilesAndDirectoriesEXERCISE;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathIn));

        for (String line : allLines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += (int) symbol; //dobavq ascii coda
            }
            System.out.println(sum);
        }

//        allLines.stream()
//                .map(line -> line.toCharArray())
//                .forEach(arr ->{
//                    int sum = 0;
//                    for (char symbol : arr) {
//                        sum += (int) symbol; //dobavq ascii coda
//                    }
//                    System.out.println(sum);
//                });

    }
}
