package StacksAndQueues.LAB;

import javax.swing.text.html.CSS;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bits = new ArrayDeque<>();
        int num = Integer.parseInt(scanner.nextLine());

        if (num < 0) {
            System.out.println("Cannot handle negative integers");
            return;
        }
        if (num == 0) {
            System.out.println(0);
            return;
        }

        while (num > 0) {
            int bit = num % 2;
            bits.push(bit);

            num = num / 2;

        }
        while (!bits.isEmpty()) {
            System.out.print(bits.pop());
        }
    }
}
