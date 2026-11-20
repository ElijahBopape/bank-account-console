# Bank Account Console App

Hey, thanks for stopping by! 👋

This is a little Java console app I built while practising object-oriented programming. It pretends to be a very small bank: you can open accounts, deposit and withdraw money, move money between accounts, and look at each account's transaction history. No real money involved, I promise.

## What you'll need

Just one thing: **Java 17 or newer** (the JDK, not only the JRE, because you'll be compiling the code).

Not sure if you have it? Open a terminal and run:

```bash
java -version
javac -version
```

If both print a version of 17 or higher, you're good to go. If not, grab a free JDK from [Adoptium](https://adoptium.net/) and install it first.

## Running it

From the project folder:

```bash
cd src
javac *.java
java BankApp
```

That's it. You should see a menu pop up.

## Taking it for a spin

The menu looks like this:

```
1. Open account
2. Deposit
3. Withdraw
4. Transfer
5. View account and history
6. List all accounts
0. Exit
```

Try opening two accounts, deposit some money into one, then transfer part of it to the other. Each new account gets a number like `ACC1001`, and you'll use that number for everything else:

```
Choose an option: 1
Enter the owner's name: Thabo
Account ACC1001 opened for Thabo.
```

Go ahead and try to break it too. Type letters where it wants numbers, or try to withdraw more than you have. I tried to make sure it handles that politely instead of crashing.

## What I was practising

- Classes and objects (the `BankAccount` class does most of the work)
- Encapsulation: keeping fields private so the balance can only change through proper deposits and withdrawals
- `ArrayList` for keeping a list of accounts that grows as you go
- A menu loop with `switch`
- Dealing with bad input without the whole thing falling over

## Things I know aren't perfect

I'd rather be upfront about these:

- Everything lives in memory, so when you close the program, all the accounts disappear.
- I used `double` for money to keep things simple. A real bank should use `BigDecimal` so it doesn't get tiny rounding errors.
- There are no PINs or logins, so anyone at the keyboard can do anything.

## What I'd like to add next

- Saving accounts to a file so they survive a restart
- A savings account that earns interest, which would be a nice excuse to practise inheritance

If you've got any feedback, I'd genuinely love to hear it!
