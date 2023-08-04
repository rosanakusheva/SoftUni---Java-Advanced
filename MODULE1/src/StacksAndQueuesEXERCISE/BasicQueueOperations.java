package StacksAndQueuesEXERCISE;

import javax.swing.text.DefaultCaret;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.add(scanner.nextInt());//.offer
        }

        for (int i = 1; i <= s; i++) {
            queue.poll();
        }
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}

