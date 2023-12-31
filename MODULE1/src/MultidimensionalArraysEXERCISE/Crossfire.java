package MultidimensionalArraysEXERCISE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);


            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInMatrix(currentRow, col, matrix)) {
                    matrix.get(currentRow).remove(col);
                }
            }

            for (int currentColumn = col + radius; currentColumn > -col - radius; currentColumn--) {
                if (isInMatrix(row, currentColumn, matrix)) {
                    matrix.get(row).remove(currentColumn);
                }
            }

            matrix.removeIf(List::isEmpty);


            command = scanner.nextLine();

        }

        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }


    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

//    public class Crossfire {
//        public static void main(String[] args) throws IOException {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//            int rows = dimensions[0];
//            int cols = dimensions[1];
//
//            List<List<Integer>> matrix = new ArrayList<>();
//
//            int count = 1;
//
//            for (int row = 0; row < rows; row++) {
//                matrix.add(new ArrayList<>());
//                for (int col = 0; col < cols; col++) {
//                    matrix.get(row).add(count++);
//                }
//            }
//
//            String line = reader.readLine();
//
//            while (!line.equals("Nuke it from orbit")){
//                String[] data = line.split(" ");
//
//                int row = Integer.parseInt(data[0]);
//                int col = Integer.parseInt(data[1]);
//                int radius = Integer.parseInt(data[2]);
//
//                for (int i = row - radius; i <= row + radius; i++) {
//                    if (isInRange(i, col, matrix) && i != row){
//                        matrix.get(i).remove(col);
//                    }
//                }
//
//                for (int i = col + radius; i >= col - radius; i--) {
//                    if (isInRange(row, i, matrix)){
//                        matrix.get(row).remove(i);
//                    }
//                }
//
//                matrix.removeIf(List::isEmpty);
//                line = reader.readLine();
//            }
//
//            for(List<Integer> integers : matrix){
//                for (Integer integer : integers) {
//                    System.out.print(integer + " ");
//                }
//                System.out.println();
//            }
//
//
//
//        }
//
//        private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
//            return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
//        }
//    }
//}