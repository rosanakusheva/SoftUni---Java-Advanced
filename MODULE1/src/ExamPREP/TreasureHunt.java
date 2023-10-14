package ExamPREP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];


        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scanner.nextLine().replace(" ", "").toCharArray();
            matrix[i] = row;
        }

        int rowYPosition = 0;
        int colYPosition = 0;
        int rowTreasure = 0;
        int colTreasure = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'Y') {
                    rowYPosition = row;
                    colYPosition = col;
                }
                if (matrix[row][col] == 'X') {
                    rowTreasure = row;
                    colTreasure = col;
                }
            }
        }

        List<String> paths = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            if (command.equals("up")) {
                if (rowYPosition > 0) {
                    char position = matrix[--rowYPosition][colYPosition];//goes up 1 position (row)
                    if (position == 'T') { //checks if the new position is T
                        rowYPosition++; //goes back is it is
                    } else {
                        //valid move
                        paths.add(command);
                    }
                }

            } else if (command.equals("down")) {
                if (rowYPosition < matrix.length - 1) {
                    char position = matrix[++rowYPosition][colYPosition];//goes down 1 position (row)
                    if (position == 'T') { //checks if the new position is T
                        rowYPosition--; //goes back is it is
                    } else {
                        //valid move
                        paths.add(command);
                    }
                }

            } else if (command.equals("right")) {
                if (colYPosition < cols - 1) {
                    char position = matrix[rowYPosition][++colYPosition];
                    if (position == 'T') {
                        colYPosition--;
                    } else {
                        //valid move
                        paths.add(command);
                    }
                }

            } else if (command.equals("left")) {
                if (colYPosition > 0) {
                    char position = matrix[rowYPosition][--colYPosition];
                    if (position == 'T') {
                        colYPosition++;
                    } else {
                        //valid move
                        paths.add(command);
                    }
                }
            }
            command = scanner.nextLine();
        }

        if (rowYPosition == rowTreasure && colYPosition == colTreasure) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String path = String.join(", ", paths);
            System.out.print(path);
        } else {
            System.out.println("The map is fake!");
        }
    }
}
