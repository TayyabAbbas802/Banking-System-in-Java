// File: model/SavingsAccount.java
package model;

/**
 * A savings account that earns interest.
 */
public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount() {
        this(0.0, 0.05);
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }
}