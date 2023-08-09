package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                firstMatrix[r][c] = arr[c].charAt(0);
            }
        }

//       rows = Integer.parseInt(scanner.nextLine());
//        cols = Integer.parseInt(scanner.nextLine());

        char[][] secondMatrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                secondMatrix[r][c] = arr[c].charAt(0);
            }

        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c]){
                    System.out.print(firstMatrix[r][c] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
