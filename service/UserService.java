// File: service/UserService.java
package service;

import model.UserAccount;
import java.util.*;

public class UserService {
    private final List<UserAccount> accounts = new ArrayList<>();

    public void addAccount(UserAccount account) {
        accounts.add(account);
    }

    public UserAccount authenticate(String email, String password) {
        for (UserAccount acc : accounts) {
            if (acc.getEmail().equals(email) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts created yet.");
            return;
        }
        for (UserAccount acc : accounts) {
            System.out.println("= = = = = = = = = = = = = =");
            System.out.println("Full Name: " + acc.getName());
            System.out.println("Account Number: " + acc.getNumber());
            System.out.println("Savings Balance: " + acc.getSavingsAccount().getBalance());
            System.out.println("Checking Balance: " + acc.getCheckingAccount().getBalance());
        }
    }
}
