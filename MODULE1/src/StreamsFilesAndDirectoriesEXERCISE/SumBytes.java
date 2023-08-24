package StreamsFilesAndDirectoriesEXERCISE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/04. Java-Advanced-Streams-Files-and-Directories-Resources (1)/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathIn));

        long sum = 0;
        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);

//        byte[] allBytes = Files.readAllBytes(Path.of(pathIn));
//        for (byte ascii : allBytes) {
//            if (ascii != 10 && ascii != 13) {
//                sum += ascii;
//            }
//        }
//        System.out.println(sum);

    }
}
