/**
 * QUESTION ONE (c)
 * SavingsAccount extends Account
 *
 * A savings account may never go below zero, and it can earn
 * interest on its balance.
 */
public class SavingsAccount extends Account {

    private double interestRate; // percentage, e.g. 5 means 5%

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (getBalance() - amount < 0) {
            // A savings account must never be allowed to go negative.
            return false;
        }
        setBalance(getBalance() - amount);
        return true;
    }

    /**
     * Adds rate% of the current balance onto the balance.
     */
    public void addInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        setBalance(getBalance() + interest);
    }
}
