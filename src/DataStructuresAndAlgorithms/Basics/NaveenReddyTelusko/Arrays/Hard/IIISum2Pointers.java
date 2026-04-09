package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Hard;
import java.util.*;
public class IIISum2Pointers {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
//-2,-2,-2,-1,-1,-1,0,0,0,2,2,2.
            // skip duplicate i
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return res;
    }
}
/*
📘 1. Problem Type

👉 3Sum Problem

Find all unique triplets such that:


a+b+c=0
🧠 2. Core Logic Used

👉 Sorting + Two Pointer Technique

⚙️ 3. Steps of Algorithm
🔹 Step 1: Sort the array
Arrays.sort(nums);

👉 Why?

Helps apply two-pointer
Makes duplicate handling easy
🔹 Step 2: Fix one element (i)
for(int i = 0; i < nums.length; i++)

👉 Treat nums[i] as first element

🔹 Step 3: Use two pointers
int left = i + 1;
int right = nums.length - 1;

👉 Now find two numbers such that:

nums[left]+nums[right]=−nums[i]
🔹 Step 4: Move pointers
int sum = nums[i] + nums[left] + nums[right];
If sum == 0 → found triplet ✅
If sum < 0 → move left++ (need bigger sum)
If sum > 0 → move right-- (need smaller sum)
⚠️ 4. CRITICAL PART (Most Important 🔥)
🔴 1. Skip duplicate i
if(i > 0 && nums[i] == nums[i-1]) continue;

👉 Prevents same starting element

🔴 2. Skip duplicate left and right
while(left < right && nums[left] == nums[left+1]) left++;
while(left < right && nums[right] == nums[right-1]) right--;

👉 Prevents duplicate triplets

🧠 5. Why This Works

👉 Because array is sorted:

Moving left++ → increases sum
Moving right-- → decreases sum

👉 So we can control sum efficiently

🚀 6. Why This Approach is Better
Approach	Time	Space
Brute Force	O(n³)	O(1)
Hashing	O(n²)	O(n)
Two Pointer	O(n²)	O(1) ✅
🔥 Advantages:
No extra space (better than HashMap)
Faster than brute force
Cleaner duplicate handling
Interview favorite ⭐
🧩 7. Key Insight
👉 Fix one element → reduce problem to 2Sum
3Sum→2Sumprobleminsideloop
⚠️ 8. Common Mistakes

❌ Forget sorting
❌ Forget duplicate skipping
❌ Wrong pointer movement
❌ Not checking left < right

🧪 9. Example Flow
[-4, -1, -1, 0, 1, 2]

For i = -1:

left = next element
right = end
find pairs → [-1, 0, 1], [-1, -1, 2]
🎯 10. One-Line Revision

👉 Fix one element, use two pointers to find remaining pair, and skip duplicates.

🔥 11. Pattern Name (VERY IMPORTANT)

👉 This is called:

👉 “Sorting + Two Pointer Pattern”

Used in:

3Sum
4Sum
Pair sum problems
Closest sum problems
 */