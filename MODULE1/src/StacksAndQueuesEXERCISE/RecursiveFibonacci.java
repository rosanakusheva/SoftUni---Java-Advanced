package StacksAndQueuesEXERCISE;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //за кое поред число искам да намеря Fn?
        System.out.println(fib(n));
    }
    public static long fib (int n) {
        //n = 1 -> F1 = 1
        //n = 2 -> F2 = 1
        if (n <= 2) {
            return 1;
        }

        //n = 20
        //F20 = ? = F19 + F18
        return fib(n - 1) + fib (n - 2);
    }
//        memoryForFib = new long [n + 1];
//        System.out.println(fib(n));
//
//    }
//
//    public static long fib (int n) {
//        if (n <= 1) {
//            return 1;
//        }
//
//        if (memoryForFib[n] != 0) {
//            //имаме го изчислено
//            return memoryForFib[n];
//        }
//
//        return memoryForFib[n] = fib(n - 1) + fib (n - 2);
//
//    }
    }

