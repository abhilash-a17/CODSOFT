package pgrm;
import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Successfully deposited: Rs." + amount);
        } 
        else 
        {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Successfully withdrew: Rs." + amount);
        } 
        else if (amount > balance) 
        {
            System.out.println("Insufficient balance.");
        } 
        else 
        {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }
}

class ATM 
{
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) 
    {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() 
    {
        int choice;
        do {
            System.out.println("\n---ATM Menu--- \n1️.Check Balance \n2️.Deposit Money \n3️.Withdraw Money \n4️.Exit \nChoose an option: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Current Balance: Rs." + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs.");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 4);
    }
}

public class ATMInterface 
{
    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount(0); 
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
