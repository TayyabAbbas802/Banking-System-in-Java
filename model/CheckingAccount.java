// File: model/CheckingAccount.java
package model;

/**
 * A checking account with transaction fees.
 */
public class CheckingAccount extends Account {
    private final double feePerTransaction;

    public CheckingAccount() {
        this(0.0, 24.44);
    }

    public CheckingAccount(double balance, double feePerTransaction) {
        super(balance);
        this.feePerTransaction = feePerTransaction;
    }

    @Override
    public boolean credit(double amount) {
        return super.credit(amount - feePerTransaction);
    }

    @Override
    public boolean debit(double amount) {
        return super.debit(amount + feePerTransaction);
    }
}
