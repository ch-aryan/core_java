package com.OopsFundamental.MultiThreading;
class MsWord extends Thread {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if(name.equals("TYPE")){
            type();
        }else if(name.equals("SPELL")){
            spell();
        }else{
            read();
        }
    }
    public void type(){
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("typing");
        }
    }
    public void spell(){
        for(; ;){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("spell");
        }
    }
    public void read(){
        for(; ;){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("reading");
        }
    }
}

public class DaemonThreads {
    public static void main(String[] args) {

        MsWord obj1 = new MsWord();
        MsWord obj2 = new MsWord();
        MsWord obj3 = new MsWord();

        obj1.setName("TYPE");
        obj2.setName("SPELL");
        obj3.setName("READ");

        obj2.setDaemon(true);
        obj3.setDaemon(true);

        obj2.setPriority(3);
        obj3.setPriority(4);


        obj1.start();
        obj2.start();
        obj3.start();

    }
}
/* ✅ ⭐ Why you are getting different output order

You expected something like:

Typing
Spell
Reading
Typing
Spell
Reading
Typing


But you got:

reading
typing
spell
spell
typing
reading
reading
typing
spell


👉 This is 100% correct behaviour in multithreading

There is no fixed execution order.

✅ ⭐ Real Reason (Deep but simple)

When you call:

obj1.start();
obj2.start();
obj3.start();


It DOES NOT mean:

obj1 runs first

then obj2

then obj3

Instead:

👉 All threads go into Runnable Queue

Then:

⭐ Thread Scheduler (OS + JVM) decides
who gets CPU first.

So actual runtime flow may be:

1️⃣ Scheduler gives CPU to READ thread
→ prints reading

2️⃣ Then switches to TYPE
→ prints typing

3️⃣ Then switches to SPELL
→ prints spell

4️⃣ Then SPELL again gets CPU slice
→ prints spell

This is called:

⭐ Context switching + time slicing

✅ ⭐ Very Important Concept You Must Remember

👉 Thread.sleep(3000) does NOT guarantee order

Sleep only means:

“Pause this thread for 3 seconds”

After waking:

👉 Thread again joins Runnable Queue

Scheduler again decides execution order.

So ordering becomes random-looking

✅ ⭐ Why Sometimes SPELL prints twice continuously

Because:

SPELL woke up

scheduler again gave CPU to SPELL

other threads still sleeping

So:

spell
spell


can happen.

✅ ⭐ Why daemon threads still printing many times

Because:

👉 TYPE thread takes about 9 seconds total

During this time:

SPELL infinite loop runs

READ infinite loop runs

So they may print many times before TYPE finishes.

Once TYPE finishes:

👉 JVM suddenly terminates program

So output stops abruptly.

✅ ⭐ Important Mental Model (VERY POWERFUL)

Think CPU like teacher giving mic to students

Student A talks

teacher takes mic

gives to Student C

then again to Student B

No fixed sequence.

This is thread scheduling reality

✅ ⭐ When Output Becomes Predictable

Only when you use:

✔ synchronization
✔ join() carefully
✔ locks
✔ single thread

Otherwise:

⭐ multithreading output order is non-deterministic

Notebook golden line:

👉 Thread execution order is not guaranteed because scheduling is controlled by JVM and operating system.

✅ ⭐ One More Deep Insight (Senior level)

Even:

same program

same system

same JVM

Still output order may change
because:

CPU interrupts

background OS tasks

JIT compilation timing

cache / memory latency

So concurrency behaviour is naturally unpredictable */