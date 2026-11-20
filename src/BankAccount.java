/**
 * BankAccount
 *
 * I made this class to hold the data and rules for one bank account.
 * Keeping the rules (like "you can't withdraw more than you have") inside
 * the class means the rest of my program can't accidentally break them.
 */
public class BankAccount {

    // I made these fields private so they can only be changed through my methods.
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    // I keep a simple text history of everything that happens on the account.
    private final java.util.ArrayList<String> history = new java.util.ArrayList<>();

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        history.add("Account opened");
    }

    /**
     * I return true if the deposit worked and false if the amount was invalid.
     * Returning a boolean lets my menu show the right message to the user.
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false; // I don't allow zero or negative deposits
        }
        balance += amount;
        history.add(String.format("Deposit:    +R%.2f", amount));
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false; // invalid amount, or not enough money
        }
        balance -= amount;
        history.add(String.format("Withdrawal: -R%.2f", amount));
        return true;
    }

    /**
     * I move money from this account to another one.
     * I reuse withdraw() and deposit() so I don't repeat the checks.
     */
    public boolean transferTo(BankAccount other, double amount) {
        if (other == null || other == this) {
            return false;
        }
        if (!withdraw(amount)) {
            return false;
        }
        other.deposit(amount);
        history.add(String.format("Transfer to %s: R%.2f", other.getAccountNumber(), amount));
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public java.util.List<String> getHistory() {
        return history;
    }
}
