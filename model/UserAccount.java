// File: model/UserAccount.java
package model;

public class UserAccount {
    private String name;
    private String number;
    private String email;
    private String password;
    private SavingsAccount savingsAccount;
    private CheckingAccount checkingAccount;

    public UserAccount() {
        this.savingsAccount = new SavingsAccount();
        this.checkingAccount = new CheckingAccount();
    }

    public UserAccount(String name, String number, String email, String password) {
        this();
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public SavingsAccount getSavingsAccount() { return savingsAccount; }
    public CheckingAccount getCheckingAccount() { return checkingAccount; }
}