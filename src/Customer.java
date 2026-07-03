import java.util.ArrayList;
import java.util.List;

/**
 * QUESTION ONE (d)
 * Customer — aggregates Account.
 *
 * A Customer owns a collection of Accounts (aggregation: the Account
 * objects can exist and be reused independently of a particular
 * Customer object, e.g. a joint account record surviving elsewhere,
 * but in this simple model each Account belongs to exactly one
 * Customer at a time).
 */
public class Customer {

    private String customerId;
    private String name;
    private List<Account> accounts;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Returns the sum of the balances of all this customer's accounts.
     */
    public double totalWorth() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}
