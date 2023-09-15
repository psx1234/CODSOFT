package codsoft;

import java.util.Scanner;

public class ATM {
    private static double accountBalance = 1000.0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            displayOptions();
            int choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                deposit();
            } else if (choice == 3) {
                withdraw();
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                isRunning = false;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + accountBalance);
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            accountBalance += depositAmount;
            System.out.println("Deposit of $" + depositAmount + " was successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= accountBalance) {
            accountBalance -= withdrawAmount;
            System.out.println("Withdrawal of $" + withdrawAmount + " was successful.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
