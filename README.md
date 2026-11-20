# Bank Account Console App

A small Java console app I made for practice. It simulates a basic bank where you can open accounts, deposit, withdraw, transfer money between accounts and see each account's history.

## What I practised
- Classes and objects (`BankAccount`)
- Encapsulation: private fields and rules kept inside the class
- `ArrayList` for storing a changing number of accounts
- Menu loops with `switch`
- Handling bad input without the program crashing

## How to run
You need Java 17 or newer.

```bash
cd src
javac *.java
java BankApp
```

## Example
```
1. Open account
...
Choose an option: 1
Enter the owner's name: Thabo
Account ACC1001 opened for Thabo.
```

## Known limitations
- Data is only kept in memory, so it's lost when the program closes.
- I used `double` for money to keep it simple. A real banking app should use `BigDecimal` to avoid rounding errors.
- There are no PINs or logins.

## Ideas for later
- Save accounts to a text file
- Add interest for savings accounts using inheritance
