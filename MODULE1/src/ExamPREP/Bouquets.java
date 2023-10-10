    package ExamPREP;

    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Scanner;

    public class Bouquets {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String tulipsInfo = scanner.nextLine();
            String daffodilsInfo = scanner.nextLine();

            ArrayDeque<Integer> tulips = new ArrayDeque<>();
            ArrayDeque<Integer> daffodils = new ArrayDeque<>();

            Arrays.stream(tulipsInfo.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .forEach(e -> tulips.push(e));

            Arrays.stream(daffodilsInfo.split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .forEach(e -> daffodils.offer(e));

            int bouquets = 0;
            int leftFlowers = 0;

            while (!tulips.isEmpty() && !daffodils.isEmpty()) {
                int tulip = tulips.peek();
                int daffodil = daffodils.peek();

                int sum = tulip + daffodil;
                if (sum == 15) {
                    bouquets++;
                    tulips.pop();
                    daffodils.poll();
                } else if (sum > 15) {
                    tulips.pop();
                    tulips.push(tulip - 2);
                } else if (sum < 15) {
                    leftFlowers += sum;
                    tulips.pop();
                    daffodils.poll();
                }
            }

            int bouquetsFromLeftFlowers = leftFlowers / 15;
            bouquets += bouquetsFromLeftFlowers;

            if (bouquets >= 5) {
                System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
            } else {
                System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquets);
            }

        }
    }
