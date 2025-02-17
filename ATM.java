import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Your current balance is $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }

    // Method to check the account balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
}

// ATM class to provide an interface for users
class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input
    public void start() {
        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

// Main class to run the ATM interface
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance: $1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}