package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn = "resources/input.txt";
        String outPath = "resources/04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter fileOutput = new PrintWriter(new FileOutputStream(outPath));

        while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    int number = scanner.nextInt();
                    fileOutput.println(number);
                }
                scanner.next();
        }
        fileOutput.close();

    }
}
