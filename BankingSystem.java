// File: BankingSystem.java
import model.*;
import service.UserService;
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("\n* * * Welcome to Tayyab Bank * * *");
            System.out.println("1. Signup\n2. Login\n3. Show Accounts\n4. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> handleSignup(sc, userService);
                case 2 -> handleLogin(sc, userService);
                case 3 -> userService.showAllAccounts();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void handleSignup(Scanner sc, UserService userService) {
        System.out.println("Enter Full Name:");
        String name = sc.nextLine();
        System.out.println("Enter Number:");
        String number = sc.nextLine();

        String email;
        while (true) {
            System.out.println("Enter Email:");
            email = sc.nextLine();
            if (email.contains("@")) break;
            System.out.println("Invalid email format.");
        }

        String password;
        while (true) {
            System.out.println("Enter Password (min 8 chars):");
            password = sc.nextLine();
            if (password.length() >= 8) break;
            System.out.println("Password too short.");
        }

        userService.addAccount(new UserAccount(name, number, email, password));
        System.out.println("Account created successfully!");
    }

    private static void handleLogin(Scanner sc, UserService userService) {
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        UserAccount user = userService.authenticate(email, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Login successful!");
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("1. Saving Account\n2. Checking Account\n3. Logout");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> handleSavingsAccount(sc, user);
                case 2 -> handleCheckingAccount(sc, user);
                case 3 -> loggedIn = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void handleSavingsAccount(Scanner sc, UserAccount user) {
        SavingsAccount sa = user.getSavingsAccount();
        System.out.println("1. Deposit\n2. Withdraw\n3. Calculate Interest");
        int action = sc.nextInt();
        switch (action) {
            case 1 -> {
                System.out.println("Enter deposit amount:");
                sa.credit(sc.nextDouble());
                System.out.println("New Balance: " + sa.getBalance());
            }
            case 2 -> {
                System.out.println("Enter withdrawal amount:");
                sa.debit(sc.nextDouble());
                System.out.println("New Balance: " + sa.getBalance());
            }
            case 3 -> System.out.println("Interest: " + sa.calculateInterest());
            default -> System.out.println("Invalid action");
        }
    }

    private static void handleCheckingAccount(Scanner sc, UserAccount user) {
        CheckingAccount ca = user.getCheckingAccount();
        System.out.println("1. Deposit\n2. Withdraw");
        int action = sc.nextInt();
        switch (action) {
            case 1 -> {
                System.out.println("Enter deposit amount:");
                ca.credit(sc.nextDouble());
                System.out.println("New Balance: " + ca.getBalance());
            }
            case 2 -> {
                System.out.println("Enter withdrawal amount:");
                ca.debit(sc.nextDouble());
                System.out.println("New Balance: " + ca.getBalance());
            }
            default -> System.out.println("Invalid action");
        }
    }
}
