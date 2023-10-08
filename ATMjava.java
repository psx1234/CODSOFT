package codesoft;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATMMachine {
    private BankAccount account;

    public ATMMachine(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Please select an option (1/2/3/4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawAmount)) {
                        System.out.printf("Withdrew $%.2f. New balance: $%.2f%n", withdrawAmount, account.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                    }
                    break;
                case "2":
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (account.deposit(depositAmount)) {
                        System.out.printf("Deposited $%.2f. New balance: $%.2f%n", depositAmount, account.checkBalance());
                    } else {
                        System.out.println("Deposit failed. Please enter a valid amount.");
                    }
                    break;
                case "3":
                    System.out.printf("Current balance: $%.2f%n", account.checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

public class ATMjava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());

        BankAccount userAccount = new BankAccount(initialBalance);
        ATMMachine atm = new ATMMachine(userAccount);
        atm.run();
    }
}
