import java.util.Scanner;

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
       try
       {
           ba.withdraw(2000);
       } catch (InsufficientFundsException e)
       {
           System.out.println(e.getMessage());
       }
        System.out.println("After withdrawal: "+ba.getAccountBalance());

        //Withdraw more than the balance. Try 10000.
        // Expected: the “Insufficient funds” message and the balance unchanged at 3000.
        try
        {
            ba.withdraw(10000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
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
        try
        {
            ba.withdraw(3000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
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
        try
        {
            ca.withdraw(15000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("After overdraft "+ca.getAccountBalance());

        //Current: withdraw 15000 again, expect it to be rejected (-25000 is past the limit)
        try
        {
            ca.withdraw(15000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }

        //Plain BankAccount: over-withdraw is still rejected
        try
        {
            ba2.withdraw(11000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("After withdrawal: "+ba2.getAccountBalance());

        //Put a SavingsAccount and a CurrentAccount in BankAccount variables and call withdraw on each (polymorphism)
        BankAccount ba3 = new SavingsAccount("1000004567","Bruce Jordan",0.05);
        BankAccount ba4 = new CurrentAccount("11111100","Funke Akindele",20000);
        ba3.deposit(30000);
        ba4.deposit(30000);
        try
        {
            ba3.withdraw(40000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("The account balance for "+ba3.getAccountName()+" is "+ba3.getAccountBalance());
        try
        {
            ba4.withdraw(40000);
        } catch (InsufficientFundsException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("The account balance for "+ba4.getAccountName()+" is "+ba4.getAccountBalance());
        //=======================================================================================================================================
        //Over-withdraw Tests (InsufficientFundsException)
        //===========================================================================================================
        //BankAccount ba2 has 10050.75. Withdraw 11000, expect the exception message.
        try {
            ba2.withdraw(11000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Transaction attempt Finished ");
        }
        System.out.println("ba2 balance: " + ba2.getAccountBalance());   // 10050.75
        //BankAccount ba2 has 10050.75. Withdraw 5000, expect it to run no exception message.
        try {
            ba2.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Transaction attempt Finished ");
        }
        System.out.println("ba2 balance: " + ba2.getAccountBalance());   // 5050.75
        //=========================================================================================================================
        //Scanner Menu
        //=========================================================================================================================
        //Create a Scanner on System.in in Main (or a new BankApp class with its own main)
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        BankAccount account = null;
        while(choice != 5)
        {
            System.out.println("1. Create Account.");
            System.out.println("2. Deposit.");
            System.out.println("3. Withdraw.");
            System.out.println("4. View Balance.");
            System.out.println("5. Exit.");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :
                    //1 Create account: ask for number, name and type (savings or current),
                    // create the right object and keep it in a variable
                    System.out.println("Please Enter your Account Number");
                    String input_accountnumber = sc.next();
                    sc.nextLine();
                    System.out.println("Please Enter your Account Name");
                    String input_accountname = sc.nextLine();
                    System.out.println("Please Enter your Account type: Savings or Current ");
                    String input_accounttype = sc.next();
                    //create account based on user input
                    if(input_accounttype.equalsIgnoreCase("savings"))
                    {
                        account = new SavingsAccount(input_accountnumber,input_accountname,0.05);
                        System.out.println("Savings Account created for "+account.getAccountName());
                    }
                    else if (input_accounttype.equalsIgnoreCase("current"))
                    {
                        account = new CurrentAccount(input_accountnumber,input_accountname,20000);
                        System.out.println("Current Account created for "+account.getAccountName());
                    }
                    else
                    {
                        System.out.println("Invalid account type");
                        break;
                    }
                    break;
                case 2 :
                    //must have an account before this action
                    // Deposit: ask for an amount and call deposit
                    if (account == null)
                    {
                        System.out.println("You need to create an account first.");
                        break;
                    }
                    else
                    {
                        System.out.println("How much would you like to deposit? ");
                        double  input_deposit = sc.nextDouble();
                        account.deposit(input_deposit);
                    }
                    break;
                case 3 :
                    //Withdraw: ask for an amount and call withdraw inside try/catch
                    if (account == null)
                    {
                        System.out.println("You need to create an account first.");
                        break;
                    }
                    else
                    {
                        System.out.println("How much would you like to withdraw? ");
                        double  input_withdraw = sc.nextDouble();
                        try
                        {
                            account.withdraw(input_withdraw);
                        }
                        catch (InsufficientFundsException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4 :
                    //View balance: print name, number and balance
                    if (account == null)
                    {
                        System.out.println("You need to create an account first.");
                        break;
                    }
                    else
                    {
                        System.out.println(account.getAccountName());
                        System.out.println(account.getAccountNumber());
                        System.out.println(account.getAccountBalance());
                    }
                    break;
                case 5 :
                    //Exit: print a goodbye message and end the loop
                    System.out.println("Thank you for banking with us , Goodbye");
                    break;
                default : System.out.println("Invalid input");
            }
        }



}

}
