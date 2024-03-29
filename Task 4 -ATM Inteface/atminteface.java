import java.util.Scanner;

class BankAccount {
    private double balance;

   

    public  BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }
}

public class atminterface {
    private BankAccount bankAccount;

    public atminterface(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Your balance: " + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        atminterface atm = new atminterface(account);
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            atm.displayMenu();
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            atm.executeOption(option);
        } while (option != 4);

        scanner.close();
    }
}
