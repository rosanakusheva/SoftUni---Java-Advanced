package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String pathIn = "resources/input.txt";
        String pathOut = "resources/03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathIn);

        FileOutputStream outputStream = new FileOutputStream(pathOut);

        int oneByte = inputStream.read();

        Set<Character> delimiterTableTable = Set.of(' ', '\n');
        while (oneByte >= 0) {

            if (oneByte == 32 || oneByte == 10) {
                outputStream.write((char) oneByte);

            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }

            oneByte = inputStream.read();
        }

    }
}
