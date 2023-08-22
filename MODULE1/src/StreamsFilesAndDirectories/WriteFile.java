package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        int oneByte = inputStream.read();

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');
        while (oneByte >= 0) {

            char symbol = (char) oneByte;
            boolean isPunctuation = punctuationTable.contains(symbol);

            if (!isPunctuation) {
               outputStream.write(symbol);

            }

            oneByte = inputStream.read();
        }


    }
}
