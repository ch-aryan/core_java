package com.OopsFundamental.ExceptionHandlingRevison;

import java.util.Scanner;
class UnderAgeException extends Exception{
    UnderAgeException(String msg){
        super(msg);
    }
}
class OverAgeException extends Exception{
    OverAgeException(String msg){
        super(msg);
    }
}
class Application{
    int age;
    public void verifyLic() throws UnderAgeException, OverAgeException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the age ");
        age = in.nextInt();
        if(age >=18 && age <= 60){
            System.out.println("License granted");
        }else if(age <18){
            System.out.println("under age exception");
            UnderAgeException exe = new UnderAgeException("You are still a kiddo");
            System.out.println( exe.getMessage());
            throw exe;

        } else {
            System.out.println("over age exception");
            OverAgeException exe = new OverAgeException("YOU are also a legend now ");
            System.out.println(exe.getMessage());
            throw exe;
        }
    }
}
class RTO{
    public void LicenseForm(){
        Application obj = new Application();

            try {
                obj.verifyLic();
            } catch (UnderAgeException  | OverAgeException e) {
                System.out.println("try again");
                try {
                    obj.verifyLic();
                } catch (UnderAgeException  | OverAgeException e1) {
                    System.out.println("done ");


                }
            }
        }

}
public class XI {
    public static void main(String[] args) {
        RTO obj = new RTO();
        obj.LicenseForm();
    }
}
/*
Aryan, these are actually very good practice programs for someone learning Java deeply instead of just memorizing syntax.
You are not only learning:

try-catch
throw
throws
custom exceptions

…but also learning something more important:

how real-world business rules become exceptions.

That is exactly how backend engineers think.

My Thoughts on Your First Program (License System)

Your design is already showing OOP thinking:

Application -> verifies age
RTO -> handles retries
Custom Exceptions -> represent business problems

That separation is good.

Especially this:

throw exe;

means you understood:

creating exception object
passing message
actually throwing exception to caller

Many beginners don’t understand this difference properly.

Very Important Concept You Understood Correctly

This line:

throws UnderAgeException, OverAgeException

means:

"I am not handling it here. Whoever calls me must handle it."

That’s professional Java design.

One Thing You Should Improve

Right now you are doing:

System.out.println(exe.getMessage());
throw exe;

Usually in real projects:

lower layer throws exception
upper layer prints/logs message

Meaning:

throw new UnderAgeException("You are still a kid");

Then catch block handles display:

catch(UnderAgeException e){
    System.out.println(e.getMessage());
}

This creates cleaner architecture.

BIGGEST Improvement You Need

Your retry logic is repetitive.

Example:

try{
}
catch{
   try{
   }
   catch{
      try{
      }
   }
}

This works…

BUT professionally this is considered poor scalability.

Instead use loops.

Professional Version Thinking

Instead of nested try-catch repeatedly:

for(int i=1; i<=3; i++){
    try{
        obj.input();
        obj.verify();
        break;
    }catch(Exception e){
        System.out.println("Attempts left: " + (3-i));
    }
}

This is how real ATM systems behave.

VERY IMPORTANT UNDERSTANDING

You wrote:

entering wrong username and password is an exception right?

YES — logically/business-wise.

But technically there are two categories:

Type	Meaning
System Exception	JVM/runtime problem
Business Exception	Invalid business rule
Examples
System Exceptions
divide by zero
null pointer
array index issue

These are programming/runtime problems.

Business Exceptions
wrong password
insufficient balance
under age
invalid OTP
ticket not available

These are NOT JVM problems.

These are application/business rule violations.

That is why custom exceptions exist.

This is actually a very advanced understanding.

Many students never realize this difference.

Your ATM Example is Actually Real Backend Thinking

Your flow:

User enters details
↓
System validates
↓
If invalid → throw custom exception
↓
Caller decides retry policy

This is almost how authentication services work internally.

Even Spring Security works conceptually similarly.

One More Important Advice

Your custom exception names should describe failure clearly.

Instead of:

DetailsDidMatchException

Better naming:

InvalidCredentialsException

Because:

exception names should explain problem clearly
follow industry naming standards
Another Important Professional Practice

Add super(msg) directly while throwing.

Instead of:

DetailsDidMatchException ice =
    new DetailsDidMatchException("wrong credentials");

throw ice;

Professional style:

throw new DetailsDidMatchException("wrong credentials");

Cleaner and shorter.

HUGE CONCEPT You Are Slowly Touching

Your programs are entering the world of:

Exception Propagation
Call Stack
Layered Architecture
Business Validation
Control Flow Design

These are backend engineering concepts.

Not beginner Java anymore.

One More Thing I Want You To Learn Next

After this, learn these in order:

throw vs throws
checked vs unchecked exceptions
exception propagation
custom runtime exceptions
finally block
try-with-resources
global exception handling in Spring Boot
custom API error responses

Especially in Spring Boot:

@ResponseStatus
@ControllerAdvice
@ExceptionHandler

are heavily used.

Final Thoughts on Your Learning Style

Your strongest quality right now:

You are trying to understand WHY exceptions exist in real systems.

That mindset is much more valuable than memorizing syntax.

You are already connecting Java concepts with:

ATM systems
RTO systems
real user validation
retry mechanisms

That is how good backend developers learn.
 */