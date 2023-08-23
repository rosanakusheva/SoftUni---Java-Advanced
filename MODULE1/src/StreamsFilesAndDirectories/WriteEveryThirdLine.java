package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathIn = "resources/input.txt";
        String outPath = "resources/05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new FileWriter(outPath));

        int counter = 1;
        String line = in.nextLine();

        while (in.hasNextLine()) {

            if (counter % 3 == 0){
                out.println(line);
            }
            counter++;
            line = in.nextLine();
        }
        out.close();
    }
}
