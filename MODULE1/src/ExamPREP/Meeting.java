package ExamPREP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String malesInfo = scanner.nextLine();
        String femalesInfo = scanner.nextLine();

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(malesInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> males.push(e));

        Arrays.stream(femalesInfo.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> females.offer(e));


        int countMatches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0) {
                males.pop();
                continue;
            } else if (female <= 0) {
                females.poll();
                continue;
            }

            if (male % 25 == 0) {
                males.pop();
                if (!males.isEmpty()) {
                    males.pop();
                    continue;
                } else {
                    break;
                }
            }
            if (female % 25 == 0) {
                females.poll();
                if (!females.isEmpty()) {
                    females.poll();
                    continue;
                } else {
                    break;
                }
            }

            if (male == female) {
                countMatches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                male = male - 2;
                int newMale = male;
                males.pop();
                males.push(newMale);
            }

        }
        System.out.printf("Matches: %d%n", countMatches);
        if (!males.isEmpty()){
            System.out.print("Males left: ");
            String val = String.join(", ", Arrays.toString(males.toArray()).replaceAll("\\[", "").replaceAll("]", ""));
            System.out.print(val);
            System.out.println();
        } else {
            System.out.println("Males left: none");
        }
//        System.out.println();

        if (!females.isEmpty()){
            System.out.print("Females left: ");
            String val = String.join(", ", Arrays.toString(females.toArray()).replaceAll("\\[", "").replaceAll("]", ""));
            System.out.printf("%s%n",val);

        } else {
            System.out.println("Females left: none");
        }

    }
}
