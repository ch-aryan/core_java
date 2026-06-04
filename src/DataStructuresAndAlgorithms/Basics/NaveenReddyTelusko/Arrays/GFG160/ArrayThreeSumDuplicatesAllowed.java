package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.GFG160;

public class ArrayThreeSumDuplicatesAllowed {
    public static int twoPointers(int [] arr, int tar ) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < tar) {
                    j++;
                } else if (sum > tar) {
                    k--;
                } else if (sum == tar) {
                    if (arr[j] == arr[k]) {
                        int m = k - j + 1;
                        count = count + m * (m - 1) / 2;
                        break;
                    }
                    int leftCount = 0;
                    int rightCount = 0;
                    int leftV = arr[j];
                    int rightV = arr[k];
//                    if(arr[j]!=arr[k]){
                    while (j <= k && arr[j] == leftV) {
                        j++;
                        leftCount++;
                    }
                    while (j <= k && arr[k] == rightV) {
                        k--;
                        rightCount++;
                    }
                    count = count + leftCount * rightCount;
                }
            }
            }
            return count;

    }
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,1,1};
        int tar = 3;
      int res =   twoPointers(arr, tar);
        System.out.println(res);


    }
}
/*
When a match is found:

Case 1
arr[j] == arr[k]

Then all elements between them are the same.

Count all pairs at once:

m = k - j + 1;

count += m * (m - 1) / 2;

and stop for that i.

Case 2
arr[j] != arr[k]

Count how many duplicates exist on the left and right.

Example:

1 1 2 2 2
  ^     ^
  j     k

There are:

leftCount = 2   // two 1's
rightCount = 3  // three 2's

Then:

count += leftCount * rightCount;

because every left duplicate can pair with every right duplicate.

You're actually very close. Your two-pointer framework is correct. The only thing missing is handling duplicate values when a valid sum is found.
That's the entire reason GFG marks this as Medium instead of Easy.

When a match is found:

Case 1
arr[j] == arr[k]

Then all elements between them are the same.

Count all pairs at once:

m = k - j + 1;

count += m * (m - 1) / 2;

and stop for that i.

Case 2
arr[j] != arr[k]

Count how many duplicates exist on the left and right.

Example:

1 1 2 2 2
  ^     ^
  j     k

There are:

leftCount = 2   // two 1's
rightCount = 3  // three 2's

Then:

count += leftCount * rightCount;

because every left duplicate can pair with every right duplicate.

You're actually very close. Your two-pointer framework is correct. The only thing missing is handling duplicate values when a valid sum is found.
 That's the entire reason GFG marks this as Medium instead of Easy.
 */