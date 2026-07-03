/**
 * Simple demo driver so the required screenshot has something to show.
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("C001", "Nakato Sarah");

        SavingsAccount savings = new SavingsAccount("SA-1001", 200000, 5);
        CurrentAccount current = new CurrentAccount("CA-2001", 50000, 100000);

        customer.addAccount(savings);
        customer.addAccount(current);

        System.out.println(savings.generateStatement());
        System.out.println(current.generateStatement());

        savings.addInterest();
        System.out.println("After interest: " + savings.generateStatement());

        boolean savingsResult = savings.withdraw(500000); // should fail, exceeds balance
        System.out.println("Savings withdraw 500000 allowed? " + savingsResult);

        boolean currentResult = current.withdraw(120000); // should succeed within overdraft
        System.out.println("Current withdraw 120000 allowed? " + currentResult);
        System.out.println(current.generateStatement());

        System.out.println(customer.getName() + "'s total worth: UGX " + customer.totalWorth());
    }
}
