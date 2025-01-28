/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactionsystem;

/**
 *
 * @author M I C R O S P A C E
 */
import java.util.Scanner;
    
public class TransactionSystem {

    private double balance;

    // Constructor
    public TransactionSystem(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the system with an initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        TransactionSystem system = new TransactionSystem(initialBalance);

        while (true) {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    system.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    system.withdraw(withdrawAmount);
                    break;
                case 3:
                    system.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
