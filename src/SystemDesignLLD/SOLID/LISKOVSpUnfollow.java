package SystemDesignLLD.SOLID;
abstract class Account{
    protected double balance;

    public void deposit(double amount){
    balance = balance + amount;
    }
    public abstract void withdrawl(double amount);
}
class SavingAccount extends Account{
    @Override
    public void deposit(double amount) {// if we don't override that's also fine
        super.deposit(amount);
    }

    @Override
    public void withdrawl(double amount) {
        balance -= amount;
        System.out.println("successful");

    }
}
class FixedDeposit extends Account{
    @Override
    public void withdrawl(double amount) {
        throw new UnsupportedOperationException("cannot withdrawl");

    }
}
public class LISKOVSpUnfollow {
    public static void main(String[] args) {
        Account account = new FixedDeposit();
        account.deposit(10000);
        account.withdrawl(1000);   // 💥 Runtime exception
    }
    }

/*
🎯 Liskov Substitution Principle (LSP)
Definition

If a program works with a parent class object, it should also work correctly with any child class object.

🧠 Simple Meaning

If Child extends Parent, then:

Parent obj = new Child();

should work without breaking behavior.

🏦 Classic Example: Bank Accounts

We have:

SavingsAccount
CurrentAccount
FixedDepositAccount

❌ Why This Breaks LSP

The client expects:

Any Account can withdraw.

But:

FixedDepositAccount cannot withdraw.

So substituting child for parent breaks the program.

📊 Problem Visualization
Account
 ├── SavingsAccount        ✅ withdraw()
 ├── CurrentAccount        ✅ withdraw()
 └── FixedDepositAccount   ❌ throws exception
 */