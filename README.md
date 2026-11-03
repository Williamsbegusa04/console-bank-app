# Console Bank App

A simple Java console application that simulates basic banking, built to practise object-oriented programming.

## Features

- Create a savings or current account
- Deposit money
- Withdraw money
- View account balance
- Overdraft on current accounts
- Interest on savings accounts
- Input validation (bad input does not crash the program)

## Requirements

- JDK 21 or higher

## How to Run

### In IntelliJ IDEA

1. Open the project folder in IntelliJ.
2. Open `Main.java`.
3. Click the green Run button next to `main`.

### From a terminal

From the project folder, run:

```
javac -d out src/*.java
java -cp out Main
```

## Example

```
1. Create Account.
2. Deposit.
3. Withdraw.
4. View Balance.
5. Exit.
1
Please Enter your Account Number
2105973315
Please Enter your Account Name
Williams Begusa
Please Enter your Account type: Savings or Current
Savings
Savings Account created for Williams Begusa
2
How much would you like to deposit?
5000
3
How much would you like to withdraw?
1000
4
Williams Begusa
2105973315
4000.0
```

## Classes

| Class | Description |
|---|---|
| `BankAccount` | Base class with account number, name, balance, deposit and withdraw |
| `SavingsAccount` | Extends `BankAccount`, adds 5% interest |
| `CurrentAccount` | Extends `BankAccount`, allows an overdraft of 20000 |
| `InsufficientFundsException` | Custom exception thrown when a withdrawal is not allowed |
| `Main` | Contains the tests and the console menu |

## Next Steps

- Store many accounts using collections
- Convert the project to Maven