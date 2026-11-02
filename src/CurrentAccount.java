public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber,String accountName,double overdraftLimit)
    {
        super(accountNumber,accountName);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
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
        else if (getAccountBalance() - amount<-overdraftLimit)
        {
            System.out.println("Insufficient funds");
        }
        else
        {
            adjustBalance(-amount);
        }
    }
}
