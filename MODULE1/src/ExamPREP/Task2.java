package ExamPREP;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int rowFisherman = 0;
        int colFisherman = 0;
        int amount = 0;
        boolean isReachedQuota = false;
        boolean isOut = false;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'S') {
                    rowFisherman = row;
                    colFisherman = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("collect the nets")) {
            matrix[rowFisherman][colFisherman] = '-';
            switch (command) {
                case "left":
                    colFisherman--;
                    break;
                case "right":
                    colFisherman++;
                    break;
                case "up":
                    rowFisherman--;
                    break;
                case "down":
                    rowFisherman++;
                    break;
            }

            if (rowFisherman < 0 || rowFisherman >= size) {
                if (rowFisherman < 0) {
                    rowFisherman = size - 1;
                }

                if (rowFisherman >= size) {
                    rowFisherman = 0;
                }
            }

            if (colFisherman < 0 || colFisherman >= size) {
                if (colFisherman < 0) {
                    colFisherman = size - 1;
                }

                if (colFisherman >= size) {
                    colFisherman = 0;
                }
            }

            char fishermanPosition = matrix[rowFisherman][colFisherman];

            if (Character.isDigit(fishermanPosition)) {
                amount += Character.getNumericValue(fishermanPosition);
                if (amount >= 20) {
                    isReachedQuota = true;
                }
                matrix[rowFisherman][colFisherman] = 'S';
            } else if (fishermanPosition == '-') {
                matrix[rowFisherman][colFisherman] = 'S';
            } else if (fishermanPosition == 'W') {
                isOut = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isOut) {
            System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", rowFisherman, colFisherman);
        }

        if (!isOut && isReachedQuota) {
            System.out.println("Success! You managed to reach the quota!");
        } else if (!isOut) {
            System.out.print("You didn't catch enough fish and didn't reach the quota!");
            System.out.printf(" You need %d tons of fish more.%n", 20 - amount);
        }

        if (!isOut && amount > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", amount);
        }

        if (!isOut) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}

