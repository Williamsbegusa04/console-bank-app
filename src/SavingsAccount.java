public class SavingsAccount extends BankAccount {
    private double interestRate ;

    public double getInterestRate()
    {
        return interestRate;
    }

    public SavingsAccount (String accountNumber , String accountName, double interestRate)
    {
        super(accountNumber, accountName);
        this.interestRate = interestRate;
    }

    public void addInterest()
    {
        double amount = getAccountBalance()*interestRate;
        adjustBalance(amount);
    }

}
