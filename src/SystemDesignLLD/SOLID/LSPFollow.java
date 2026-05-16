package SystemDesignLLD.SOLID;
abstract class NonWithdrawAbleAcc{
    protected int balance;
    void deposit(int amt){
        balance += amt;
    }
    void getBalance(){
        System.out.println(balance);
    }
}
abstract class  WithDrawAcc extends NonWithdrawAbleAcc{
    abstract void withDraw(int amt);
}
class SavingAcc extends WithDrawAcc{
    @Override
    void withDraw(int amt) {
        balance -= amt;
        System.out.println("savings withdrawl successfull");
    }
}
class CurrentAcc extends WithDrawAcc{
    @Override
    void withDraw(int amt) {
        balance -= amt;
        System.out.println("currentAcc withdrawl successfull");
    }
}
class FixedDeposit1 extends NonWithdrawAbleAcc{

}
public class LSPFollow {
    public static void main(String[] args) {
    WithDrawAcc savings = new SavingAcc();
    savings.deposit(111);
    savings.withDraw(11);
       savings.getBalance();
        System.out.println("???????/");
    WithDrawAcc current = new CurrentAcc();
    current.deposit(10);
    current.withDraw(5);
    current.getBalance();
        System.out.println("*************8");
    NonWithdrawAbleAcc fixed =  new FixedDeposit1();
    fixed.deposit(100);
    fixed.getBalance();
    }
}
/*
✅ Why This Follows LSP
All WithdrawableAccount objects truly support withdrawal.
FixedDepositAccount is no longer forced to implement invalid behavior.
Substitution is safe.

Formal LSP Rules (Advanced)
1️⃣ Signature Rule

Child method signature must remain compatible.

✅ Valid
class Parent {
    Number getValue() { return 10; }
}

class Child extends Parent {
    @Override
    Integer getValue() { return 20; } // narrower return type
}
2️⃣ Property Rule (Invariant)
Invariant

A condition that must always remain true.

Example:

Bank balance should never be negative.
❌ Bad
class BadAccount extends WithdrawableAccount {
    @Override
    public void withdraw(double amount) {
        balance -= amount; // may become negative
    }
}
✅ Good
class SafeAccount extends WithdrawableAccount {
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
3️⃣ History Constraint

A child must not invalidate expected past behavior.

Example:
If parent supports withdrawal, child must not suddenly disable it.

This is exactly why FixedDepositAccount should not extend Account with withdraw().
4️⃣ Pre-condition Rule

Child may weaken preconditions, but must not strengthen them.

Parent
// accepts any positive amount
❌ Bad Child
// only allows multiples of 1000

The child is stricter, which breaks client expectations.

5️⃣ Post-condition Rule

Child may provide stronger guarantees, but not weaker ones.

Parent Guarantee
Withdrawal reduces balance.
Child Guarantee
Withdrawal reduces balance and logs transaction.

This is stronger and valid.
6️⃣ Exception Rule

Child should throw the same or narrower exceptions.

❌ Bad

Parent does not expect an exception, but child throws a broad exception.

✅ Good

Child throws either:

No exception
Same exception
More specific exception
🏢 Real-World Example from Your Matrimony Project

Suppose:

PaymentMethod
 ├── UPI
 ├── BankTransfer
 └── CashPayment

If PaymentMethod.pay() is expected to complete a payment,
then every subclass must honor that contract. A subclass should not throw “Not Supported” unexpectedly.
🏆 Interview Answer

The Liskov Substitution Principle states that subclasses must be replaceable for their parent classes without breaking program correctness.
 Child classes must preserve the parent contract, including method behavior, invariants, preconditions,
 postconditions, and exception expectations.

🧠 Memory Trick
LSP = Child Must Behave Like Parent Promised
🔥 Golden Rule

If a subclass needs to throw UnsupportedOperationException, return fake values, or leave methods empty,
the inheritance hierarchy is likely wrong.
Your sir was referring to Covariance, which is part of the Signature Rule in the Liskov Substitution Principle. This was explicitly covered in your notes as:

Return type must be the same or narrower (child type).

🎯 Covariance in LSP
Definition

Covariance means that an overridden method in the child class can return a more specific type than the parent method.

This is allowed in Java and fully supports LSP.

🧠 Simple Meaning

Parent says:

“I will return an Animal.”

Child says:

“I will return a Dog.”

Since Dog is an Animal, this is perfectly valid.

📊 Visualization
Animal
 └── Dog

Parent method: Animal getPet()
Child method : Dog    getPet()

Because every Dog is an Animal, the child keeps the parent’s promise.

✅ Java Example (Covariant Return Type)
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}

class Parent {
    Animal getAnimal() {
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    Dog getAnimal() {   // Covariant return type
        return new Dog();
    }
}
✅ Usage
public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        Animal animal = obj.getAnimal();
        animal.sound();   // Bark
    }
}
✅ Output
Bark
🎯 Why This Works

The client expects an Animal.

The child returns a Dog.

Since Dog IS-A Animal, the substitution remains safe.

❌ Contravariance (Not Allowed for Return Types)
class Parent {
    Dog getDog() {
        return new Dog();
    }
}

class Child extends Parent {
    @Override
    Animal getDog() {   // ❌ Compilation error
        return new Animal();
    }
}

This is invalid because the child returns a broader type.

📌 Rule Summary
Method Parameters
Must remain compatible.
In Java overriding, parameter types must effectively stay the same.
Return Types
Same type ✅
Subclass (more specific) ✅ → Covariance
Superclass (more general) ❌
🧠 Visual Summary
Parent return type: Animal
Child return type : Dog

Dog IS-A Animal
Therefore valid (Covariance)

🏦 Bank Example
class Account {}

class SavingsAccount extends Account {}

class Bank {
    Account openAccount() {
        return new Account();
    }
}

class SavingsBank extends Bank {
    @Override
    SavingsAccount openAccount() {
        return new SavingsAccount();
    }
}

The parent promises an Account; the child returns a more specific SavingsAccount.

🏆 Interview Answer

Covariance allows an overriding method to return a more specific type than the method in the parent class. This is valid because the returned object still satisfies the parent contract and therefore preserves substitutability.

🔥 Memory Trick
Covariance = Child Can Return a Child Type
🎯 Golden Rule



If the parent returns type T, the child may return T or any subclass of T.

🚀 Final Signature Rule Summary
Signature Rule
├── Method name must match
├── Parameters must be compatible
└── Return type:
    ├── Same type ✅
    └── Subtype ✅ (Covariance)
 */