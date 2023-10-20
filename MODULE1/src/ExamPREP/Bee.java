package ExamPREP;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int beeRow = -1;
        int beeCol = -1;
        for (int row = 0; row < size; row++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            matrix[row] = singleRow;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                    break;
                }
            }
        }

        int flowers = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
             matrix[beeRow][beeCol] = '.';
            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                matrix[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (matrix[beeRow][beeCol] == 'f'){
                flowers++;
            } else if (matrix[beeRow][beeCol] == 'O') {
                continue;
            }

            matrix[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }

        if (flowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }
}
