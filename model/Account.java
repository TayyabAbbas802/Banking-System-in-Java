package model;

/**
 * Represents a general bank account with basic operations.
 */
public class Account {
    protected double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(double balance) {
        this.balance = Math.max(0.0, balance);
    }

    public boolean credit(double amount) {
        this.balance += amount;
        return true;
    }

    public boolean debit(double amount) {
        if (balance < amount) {
            System.out.println("Debit amount exceeded account balance.");
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}