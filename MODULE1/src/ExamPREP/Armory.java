package ExamPREP;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int officerRow = 0;
        int officerCol = 0;


        boolean isLeft = false;
        boolean isEnoughSwords = false;
        int sum = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'A') {
                    officerRow = row;
                    officerCol = col;
                    break;
                }

            }
        }

        String command = scanner.nextLine();
        while (true) {
            matrix[officerRow][officerCol] = '-';
            if (command.equals("up")) {
                if (officerRow - 1 < 0) {
                    isLeft = true;
                    break;
                } else {
                    matrix[officerRow][officerCol] = '-';
                    officerRow--;

                }
            } else if (command.equals("down")) {
                if (officerRow + 1 >= matrix.length) {
                    isLeft = true;
                    break;
                } else {
                    matrix[officerRow][officerCol] = '-';
                    officerRow++;
                }
            } else if (command.equals("left")) {
                if (officerCol - 1 < 0) {
                    isLeft = true;
                    break;
                } else {
                    matrix[officerRow][officerCol] = '-';
                    officerRow--;
                }
            } else if (command.equals("right")) {
                if (officerCol + 1 >= matrix.length) {
                    isLeft = true;
                    break;
                } else {
                    matrix[officerRow][officerCol] = '-';
                    officerCol++;
                }
            }


            char officerPosition = matrix[officerRow][officerCol];

            if (officerPosition == '-') {
                matrix[officerRow][officerCol] = 'A';

            } else if (officerPosition == 'M') {

            } else if (Character.isDigit(officerPosition)) {
                sum += Character.getNumericValue(officerPosition);
                matrix[officerRow][officerCol] = 'A';
                if (sum >= 65) {
                    isEnoughSwords = true;
                    break;
                }
            }

            command = scanner.nextLine();
        }

        if (isLeft) {
            System.out.println("I do not need more swords!");
        }

        if (isEnoughSwords) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", sum);
        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
