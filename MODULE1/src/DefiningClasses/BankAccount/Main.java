package DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        BiFunction<BankAccount, String[], String> depositFunction = (b, arr) -> {
            int amount = Integer.parseInt(arr[2]);
            b.deposit(amount);
            return "Deposited " + amount + " to ID" + arr[1];
        };

        BiFunction<BankAccount, String[], String> getInterestFunction = (b, arr) -> {
            int years = Integer.parseInt(arr[2]);
            double interest = b.getInterest(years);
            return String.format("%.2f", interest);
        };

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            String command = data[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccountMap.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");

            } else if (command.equals("Deposit")) {
                String output = executeOnBankAccount(data, bankAccountMap, depositFunction);
                System.out.println(output);

            } else if (command.equals("SetInterest")) {
                double interestRate = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interestRate);

            } else if (command.equals("GetInterest")) {
                String output = executeOnBankAccount(data, bankAccountMap, getInterestFunction);
                System.out.println(output);
            }


            input = scanner.nextLine();
        }
    }

    private static String executeOnBankAccount(String[] data, Map<Integer, BankAccount> bankAccountMap, BiFunction<BankAccount, String[], String> function) {
        BankAccount bankAccount = bankAccountMap.get(Integer.parseInt(data[1]));
        int id = Integer.parseInt(data[1]);

        if (bankAccount == null) {
            return "Account does not exist";
        }
        return function.apply(bankAccount, data)  ;

    }


}
