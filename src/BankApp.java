import java.util.ArrayList;
import java.util.Scanner;

/**
 * BankApp
 *
 * This is the console menu for my small banking practice app.
 * It lets me open accounts, deposit, withdraw, transfer and view history.
 * Everything is kept in memory, so the data is gone when the program closes.
 */
public class BankApp {

    // I store all the accounts in an ArrayList because I don't know how many there will be.
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    // I use this counter to give every new account a unique number.
    private static int nextAccountNumber = 1001;

    public static void main(String[] args) {
        System.out.println("=== Welcome to My Simple Bank ===");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            // I use a switch because it's easier to read than lots of if/else.
            switch (choice) {
                case 1 -> openAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> showAccount();
                case 6 -> listAccounts();
                case 0 -> running = false;
                default -> System.out.println("That is not a valid option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Open account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View account and history");
        System.out.println("6. List all accounts");
        System.out.println("0. Exit");
    }

    private static void openAccount() {
        System.out.print("Enter the owner's name: ");
        String name = input.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        String number = "ACC" + nextAccountNumber;
        nextAccountNumber++;

        accounts.add(new BankAccount(number, name));
        System.out.println("Account " + number + " opened for " + name + ".");
    }

    private static void deposit() {
        BankAccount account = findAccountFromUser();
        if (account == null) return;

        double amount = readDouble("Amount to deposit: R");
        if (account.deposit(amount)) {
            System.out.printf("Done. New balance: R%.2f%n", account.getBalance());
        } else {
            System.out.println("Deposit failed. The amount must be more than zero.");
        }
    }

    private static void withdraw() {
        BankAccount account = findAccountFromUser();
        if (account == null) return;

        double amount = readDouble("Amount to withdraw: R");
        if (account.withdraw(amount)) {
            System.out.printf("Done. New balance: R%.2f%n", account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Check the amount and your balance.");
        }
    }

    private static void transfer() {
        System.out.println("-- From --");
        BankAccount from = findAccountFromUser();
        if (from == null) return;

        System.out.println("-- To --");
        BankAccount to = findAccountFromUser();
        if (to == null) return;

        double amount = readDouble("Amount to transfer: R");
        if (from.transferTo(to, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    private static void showAccount() {
        BankAccount account = findAccountFromUser();
        if (account == null) return;

        System.out.println("Owner:   " + account.getOwnerName());
        System.out.printf("Balance: R%.2f%n", account.getBalance());
        System.out.println("History:");
        for (String line : account.getHistory()) {
            System.out.println("  - " + line);
        }
    }

    private static void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts yet.");
            return;
        }
        for (BankAccount a : accounts) {
            System.out.printf("%s  %-15s R%.2f%n", a.getAccountNumber(), a.getOwnerName(), a.getBalance());
        }
    }

    /**
     * I ask for an account number and search my list for it.
     * I return null if it isn't found, so every caller must check for null.
     */
    private static BankAccount findAccountFromUser() {
        System.out.print("Account number (e.g. ACC1001): ");
        String number = input.nextLine().trim();

        for (BankAccount a : accounts) {
            if (a.getAccountNumber().equalsIgnoreCase(number)) {
                return a;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // I wrote these two helpers so the program doesn't crash when someone types letters.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number, like 150 or 99.50.");
            }
        }
    }
}
