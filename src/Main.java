//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        //Bank Account Tests
        //=============================================================================================================================
        //Create an account. Print the owner name, account number and balance.
        // Expected balance: 0.
        BankAccount ba = new BankAccount("2105973315","Williams Begusa");
        System.out.println(ba.getAccountName());
        System.out.println(ba.getAccountNumber());
        System.out.println(ba.getAccountBalance());

        //Normal deposit. Deposit 5000, print the balance. Expected: 5000.
        ba.deposit(5000);
        System.out.println("After deposit: "+ba.getAccountBalance());

        //Normal withdrawal. Withdraw 2000, print the balance. Expected: 3000.
        ba.withdraw(2000);
        System.out.println("After withdrawal: "+ba.getAccountBalance());

        //Withdraw more than the balance. Try 10000.
        // Expected: the “Insufficient funds” message and the balance unchanged at 3000.
        ba.withdraw(10000);
        System.out.println("After  failed  withdrawal: "+ba.getAccountBalance());

        //Deposit a negative amount. Try -50.
        // Expected: an error message and the balance unchanged.
        ba.deposit(-50);
        System.out.println("After negative deposit balance is: "+ba.getAccountBalance());

        //Deposit zero.
        // Expected: an error message and the balance unchanged.
        ba.deposit(0);
        System.out.println("After deposit: "+ba.getAccountBalance());

        //Withdraw exactly the full balance.
        // Expected: this works and the balance is 0.
        ba.withdraw(3000);
        System.out.println("After withdrawal: "+ba.getAccountBalance());

        //Two separate accounts. Create a second account with different details,
        // deposit into only one, and print both balances.
        // Expected: the other account’s balance doesn’t change.
        BankAccount ba2 = new BankAccount("1101010101","Tobi Amusan");
        ba2.deposit(10000);
        System.out.println("The account balance for "+ba.getAccountName()+" is "+ba.getAccountBalance());
        System.out.println("The account balance for "+ba2.getAccountName()+" is "+ba2.getAccountBalance());

        //Deposit 50.75 into the new account.
        // Expected: the new accounts balance should be 10050.75.
        ba2.deposit(50.75);
        System.out.println("After deposit: "+ba2.getAccountBalance());
        //============================================================================================================================================
        //Savings and Current  Account  Tests
        //============================================================================================================================================
        //Savings: 5% rate, deposit 10000, call addInterest, expect 10500
        SavingsAccount sa = new SavingsAccount("929828828","Agatha Scofield",0.05);
        sa.deposit(10000);
        sa.addInterest();
        System.out.println("After adding Interest new balance becomes "+sa.getAccountBalance());   //10500

        //Current: 20000 limit, deposit 5000, withdraw 15000, expect balance -10000
        CurrentAccount ca = new CurrentAccount("125535467","Michael Lee",20000);
        ca.deposit(5000);
        ca.withdraw(15000);
        System.out.println("After overdraft "+ca.getAccountBalance());

        //Current: withdraw 15000 again, expect it to be rejected (-25000 is past the limit)
        ca.withdraw(15000);//insufficient funds

        //Plain BankAccount: over-withdraw is still rejected
        ba2.withdraw(11000);
        System.out.println("After withdrawal: "+ba2.getAccountBalance());

        //Put a SavingsAccount and a CurrentAccount in BankAccount variables and call withdraw on each (polymorphism)
        BankAccount ba3 = new SavingsAccount("1000004567","Bruce Jordan",0.05);
        BankAccount ba4 = new CurrentAccount("11111100","Funke Akindele",20000);
        ba3.deposit(30000);
        ba4.deposit(30000);
        ba3.withdraw(40000);
        System.out.println("The account balance for "+ba3.getAccountName()+" is "+ba3.getAccountBalance());
        ba4.withdraw(40000);
        System.out.println("The account balance for "+ba4.getAccountName()+" is "+ba4.getAccountBalance());
        //=======================================================================================================================================

    }

}
