public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double accountBalance;

    public String getAccountNumber() {
        return accountNumber;

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }


    public BankAccount(String accountNumber, String accountName)
    {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = 0.0;
    }

    public void deposit(double amount)
    {
        if(amount ==0)
        {
            System.out.println("You can't Deposit an amount of 0");
        }
        else if (amount<0)
        {
            System.out.println("You have entered a negative amount to deposit");
        }
        else
        {
            accountBalance += amount;
        }
    }
    public void withdraw(double amount)
    {
        if(amount ==0)
        {
            System.out.println("You can't Withdraw an amount of 0");
        }
        else if (amount<0)
        {
            System.out.println("You have entered a negative amount to withdraw, please enter a valid amount");
        }
        else if (amount> accountBalance)
        {
            System.out.println("Insufficient funds");
        }
        else
        {
            accountBalance -= amount;
        }
    }

}
