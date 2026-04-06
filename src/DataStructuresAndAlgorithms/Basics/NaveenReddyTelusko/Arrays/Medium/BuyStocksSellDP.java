package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class BuyStocksSellDP {
    public static void AlgoBASSDP(int [] arr){
        int profit = 0;
        int buy = arr[0];
        int max = 0;
        for(int i=1;i<arr.length;i++){

            if(arr[i] - buy > 0){
                profit = arr[i] - buy;
                max = Math.max(profit,max);
            }
            buy = Math.min(buy, arr[i]);
        }
        System.out.println(max);
    }
    public static void AlgoBASSDPAI(int [] arr){
        int buy = arr[0];
        int max = 0;

        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i] - buy);
            buy = Math.min(buy, arr[i]);
        }

        System.out.println(max);
    }



    public static void main(String[] args) {
        int[] arr = {7,1,3,5,6,4};
        int [] arr1 = {8,6,4,2};
        AlgoBASSDP(arr);
        System.out.println("***************");
        AlgoBASSDP(arr1);

    }
}
/* 1. What problem is this?

This is the classic:

👉 “Best Time to Buy and Sell Stock (Single Transaction)”

You are given stock prices for each day
You can:
Buy once
Sell once
Goal: maximize profit
⚡ 2. Your Algorithm – What are you doing?

Your key idea:

buy = minimum price seen so far
profit = current price - buy
max = maximum profit till now
🔁 Step-by-step logic:
Track the lowest price (buy)
For every day:
Check if selling today gives profit
Update max profit
Update lowest price
🧠 Dry understanding (your example)

For:

[7,1,3,5,6,4]
Day	Price	Buy	Profit	Max
0	7	7	-	0
1	1	1	0	0
2	3	1	2	2
3	5	1	4	4
4	6	1	5	5
5	4	1	3	5

✅ Final Answer = 5

📊 3. Time & Space Complexity
⏱ Time: O(n) (single loop)
📦 Space: O(1) (no extra space)

Perfect optimal solution.

🤔 4. Why is this called a DP problem?

This is where many people get confused — good question.

🔑 DP definition:

Dynamic Programming =
👉 solving a problem using previous computed results

💡 Hidden DP inside your code:

You are doing this:

minPrice[i] = min(minPrice[i-1], arr[i])
maxProfit[i] = max(maxProfit[i-1], arr[i] - minPrice[i])

But instead of arrays, you optimized to variables:

buy = Math.min(buy, arr[i]);   // previous state used
max = Math.max(max, arr[i] - buy); // depends on past

👉 You are using previous state → current decision

⚠️ Important Insight

This is:

✅ DP optimized to greedy

🧩 5. So what type of problem is this?

This problem sits in 3 categories:

✅ 1. Greedy (Primary classification)
Always track minimum
Make best local decision

👉 Your solution is greedy

✅ 2. Dynamic Programming (Conceptual form)
Uses previous state
Can be written with DP arrays
✅ 3. Array / Sliding Window pattern
Single pass over array
Track min/max
🎯 6. Interview Answer (Very Important 🔥)

If interviewer asks:

👉 “Is this DP or Greedy?”

You should say:

“This problem can be solved using Dynamic Programming, but it is optimized to a Greedy solution by tracking the minimum price and maximum profit in a single pass.”

💥 This is a top-tier answer

🧠 7. Small Improvement in Your Code

Your code is already good, but can be simplified:

public static void AlgoBASSDP(int [] arr){
    int buy = arr[0];
    int max = 0;

    for(int i = 1; i < arr.length; i++){
        max = Math.max(max, arr[i] - buy);
        buy = Math.min(buy, arr[i]);
    }

    System.out.println(max);
}

👉 No need for profit variable separately.

🚀 8. Final Verdict on Your Code

✔ Correct
✔ Optimal
✔ Interview-level
✔ Clean logic
✔ Good understanding

💬 Real Talk

You’re not just coding anymore —
you’re starting to recognize patterns (DP vs Greedy).

That’s exactly the level where product-based company prep begins.

 */
