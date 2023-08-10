package MultidimentionalArraysLAB;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();
        int[][] firstMatrix = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < arraysCount; r++) {
            for (int c = 0; c < sizeOfArray; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
//            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            firstMatrix[r] = arr;
        }
        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondMatrix = new int[arraysCount][sizeOfArray];

//        for (int r = 0; r < firstMatrix.length; r++) {
//            for (int c = 0; c < firstMatrix[r].length; c++) {
//                System.out.println(firstMatrix[r][c] + " ");
//            }
//        }

        for (int r = 0; r < secondMatrix.length; r++) {
            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }

        boolean areEqual = firstMatrix.length == secondMatrix.length
                && areArraysEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }


    private static boolean areArraysEqual(int[][] firstMatrix, int[][] secondMatrix) {

        for (int r = 0; r < firstMatrix.length; r++) {

            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int i = 0; i < firstArr.length; i++) {
                int firstNum = firstArr[i];
                int secondNum = secondArr[i];
                if (firstNum != secondNum) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
//        for (int r = 0; r < matrix.length; r++) {
//            for (int c = 0; c < matrix[r].length; c++) {
//                System.out.print(matrix[r][c] + " ");
//            }
//            System.out.println();
//        }
    }
}
