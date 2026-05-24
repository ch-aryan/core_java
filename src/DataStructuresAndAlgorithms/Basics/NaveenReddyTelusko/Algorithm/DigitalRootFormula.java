package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Algorithm;

public class DigitalRootFormula {
    /*
    This is one of the most beautiful math tricks in programming.
It is called the Digital Root Formula.

What is Digital Root?
Keep adding digits until one digit remains.

Example:

9875
= 9+8+7+5
= 29

29
= 2+9
= 11

11
= 1+1
= 2
Digital Root = 2

Strange Pattern
Look carefully:

Number	Digit Sum	Final
1	1	1
2	2	2
3	3	3
9	9	9
10	1	1
11	2	2
18	9	9
19	10 → 1	1
27	9	9
36	9	9
99	18 → 9	9
Notice something?

The answers repeat every 9.

Core Mathematics
This is the real secret:

A number and its digit sum have same remainder when divided by 9.
Example:

9875

9+8+7+5 = 29
2+9 = 11
1+1 = 2
Now check modulo 9:

9875 % 9 = 2
Same answer.

Another:

38

3+8 = 11
1+1 = 2
And:

38 % 9 = 2
Again same.

Why Does This Happen?
Take any number:

472
Expand:

4×100 + 7×10 + 2
Now modulo 9:

100 % 9 = 1
10 % 9 = 1
So:

4×1 + 7×1 + 2
= 4+7+2
= 13
That is why digit sums preserve modulo 9.

Then Why Not Just n % 9 ?
Problem:

9 % 9 = 0
But actual answer should be:

9
Similarly:

18 % 9 = 0
But digital root is 9.

So we need a special handling.

Final Formula
1 + (n - 1) % 9
This shifts the range properly.

Visualization
Normal modulo gives:

1→1
2→2
3→3
...
8→8
9→0
But we want:

1→1
2→2
3→3
...
8→8
9→9
So we shift everything left by 1.

Let’s Test
Example 1
n = 38
Formula:

1 + (38 - 1) % 9
= 1 + 37 % 9
= 1 + 1
= 2
Correct.

Example 2
n = 18
1 + (18 - 1) % 9
= 1 + 17 % 9
= 1 + 8
= 9
Correct.

Why Special Case for 0?
Because:

1 + (-1 % 9)
is invalid logic for digital root.

Digital root of 0 is simply:

0
So:

if(n == 0){
    return 0;
}
Final Understanding
This formula works because:

Repeated digit sums follow modulo 9 cycle.
Digital Root is basically:

Modulo 9
BUT
0 replaced with 9
except actual zero itself.
     */
}
