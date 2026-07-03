/**
 * QUESTION ONE (c)
 * CurrentAccount extends Account
 *
 * A current account is allowed to go negative, but only up to its
 * agreed overdraft limit.
 */
public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double resultingBalance = getBalance() - amount;
        if (resultingBalance < -overdraftLimit) {
            // Would breach the overdraft limit — refuse.
            return false;
        }
        setBalance(resultingBalance);
        return true;
    }
}
