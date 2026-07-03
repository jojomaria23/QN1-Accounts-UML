/**
 * QUESTION ONE (b)
 * «abstract» Account implements Statement
 *
 * Holds the state and behaviour common to every kind of account.
 * withdraw() is left {abstract} because SavingsAccount and
 * CurrentAccount each enforce a different withdrawal rule.
 */
public abstract class Account implements Statement {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }

    /**
     * {abstract} — every subclass must decide its own withdrawal rule.
     * Returns true if the withdrawal succeeded, false otherwise.
     */
    public abstract boolean withdraw(double amount);

    @Override
    public String generateStatement() {
        return "Account No: " + accountNumber + " | Current Balance: UGX " + String.format("%.2f", balance);
    }
}
