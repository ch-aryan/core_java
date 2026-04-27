package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class NotesClockAnti {
}
/*
This is a very important concept — once this clicks, all matrix rotation problems become easy. Let’s build it from intuition, not memorization.

🔹 Step 1: Understand direction using a real-life example

Imagine a clock ⏰

Moving from 12 → 3 → 6 → 9 → 12
👉 That direction is clockwise
Moving from 12 → 9 → 6 → 3 → 12
👉 That is anti-clockwise
🔹 Step 2: Apply this to a matrix

Take your matrix:

1 2 3
4 5 6
7 8 9
🔹 90° Clockwise Rotation

👉 Think: everything shifts to the right direction

Result:
7 4 1
8 5 2
9 6 3
🔥 Key Pattern:
First column → becomes first row (reversed)
Movement direction:
👉 Top → Right → Bottom → Left
🔹 90° Anti-Clockwise Rotation

👉 Think: everything shifts to the left direction

Result:
3 6 9
2 5 8
1 4 7
🔥 Key Pattern:
First row → becomes first column (reversed)
Movement direction:
👉 Top → Left → Bottom → Right
🔹 Step 3: What is Cycle Rotation?

Now your main doubt 👇

Cycle means:

We rotate 4 elements at a time in a loop.

Example (corners):
(0,0) → (0,2) → (2,2) → (2,0)

These 4 positions form a cycle

🔹 For Clockwise Rotation (your code)

Cycle movement:

Top → Right
Right → Bottom
Bottom → Left
Left → Top

That’s why your code gives:

7 4 1
8 5 2
9 6 3

✔ Correct for clockwise

🔹 For Anti-Clockwise Rotation

Cycle changes direction:

Top → Left
Left → Bottom
Bottom → Right
Right → Top

👉 Same idea, just reverse direction

🔹 Simple Memory Trick (Very Important)
Rotation	Think like
Clockwise	Turning a steering wheel right 🚗
Anti-clockwise	Turning left 🚗
🔹 Another Trick (Interview Gold)

Instead of cycle logic:

Clockwise:
Transpose
Reverse rows
Anti-clockwise:
Transpose
Reverse columns
🔹 Final clarity for YOU
Your cycle code = perfect
Your confusion = only about direction
Once you fix direction → you can solve any rotation
 */