package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Easy;

public class FindMaxConsecutive1s {

        public int findMaxConsecutiveOnes(int[] nums) {

            int max = 0;
            int count =0;
            for(int i=0;i<nums.length;i++){

                if(nums[i] == 1){
                    count ++;
                    max = Math.max(max,count);
                }else{
                    count = 0;
                }
            }
            return max;
        }
    }

/* 🧠 What You Did Right
✔ Single pass → O(n)
✔ No extra space → O(1)
✔ Correct reset logic
✔ Updating max at right place

👉 This is exactly what interviewers expect ✅

⚖️ Can It Be Better?

👉 No — this is already optimal

Time: O(n)  ✅ (minimum possible)
Space: O(1) ✅

👉 You cannot do better than:

Reading array once
💡 Small Optional Improvement (Style Only)

You could write slightly cleaner:

if(nums[i] == 1){
    count++;
}else{
    count = 0;
}
max = Math.max(max, count);

👉 Same logic, just cleaner flow

🧪 Dry Insight

You are basically doing:

Count streak of 1s → reset on 0 → track max streak
🚀 Pattern You Just Learned

This is a very important pattern:

"Longest continuous streak / subarray"
🔥 Where This Pattern Appears Again
Longest subarray with sum = k
Longest substring problems
Sliding window problems

👉 You’ll reuse this idea MANY times

🎯 Final Verdict
Your solution = 10/10 ✅
Optimal = YES ✅
Interview ready = YES 🔥 */