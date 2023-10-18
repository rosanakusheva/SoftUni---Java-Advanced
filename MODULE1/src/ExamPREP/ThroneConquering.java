package ExamPREP;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][];

        int[] coordinates = fillMatrixAndGetCoordinate(scanner, matrix);
        int parisRow = coordinates[0];
        int parisCol = coordinates[1];

        matrix[parisRow][parisCol] = '-';

        while (energy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);
            matrix[spawnRow][spawnCol] = 'S';

            switch (command) {
                case "up":
                    if (canMove(matrix, parisRow - 1, parisCol)) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (canMove(matrix, parisRow + 1, parisCol)) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (canMove(matrix, parisRow, parisCol - 1)) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (canMove(matrix, parisRow, parisCol + 1)) {
                        parisCol++;
                    }
                    break;
            }
            energy -= 1;

            if (matrix[parisRow][parisCol] == 'S') {
                energy -= 2;
                if (energy > 0) {
                    matrix[parisRow][parisCol] = '-';
                }
            } else if (matrix[parisRow][parisCol] == 'H') {
                matrix[parisRow][parisCol] = '-';
                break;
            }
        }
        if (energy <= 0) {
            matrix[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        printMatrix(matrix);

    }

    private static boolean canMove(char[][] matrix, int parisRow, int parisCol) {
        return parisRow >= 0 && parisRow < matrix.length && parisCol >= 0 && parisCol < matrix[parisRow].length;
    }

    private static int[] fillMatrixAndGetCoordinate(Scanner scanner, char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[row] = currentRow;

            for (int col = 0; col < currentRow.length; col++) {
                char symbol = currentRow[col];
                if (symbol == 'P') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
