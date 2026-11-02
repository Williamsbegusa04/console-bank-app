public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber,String accountName,double overdraftLimit)
    {
        super(accountNumber,accountName);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException
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
            throw new InsufficientFundsException("Insufficient funds , you've hit your Overdraftlimit. your balance is: "+getAccountBalance()+"and you requested for: "
                    +amount+"Your OverdraftLimit is: "+overdraftLimit);
        }
        else
        {
            adjustBalance(-amount);
        }
    }
}
