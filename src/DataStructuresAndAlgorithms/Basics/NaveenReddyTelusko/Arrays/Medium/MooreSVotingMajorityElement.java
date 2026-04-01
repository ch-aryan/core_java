package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Arrays.Medium;

public class MooreSVotingMajorityElement {
    public static int algorithm(int [] arr){
        int element = 0;
        int count =0;
        
        for(int i=0;i<arr.length;i++){
            if(count==0){
                element = arr[i];
            }
            if(element == arr[i]){
                count ++;
            }else{
                count--;
            }
        }
        count =0;
        for(int i=0;i<arr.length;i++){
            if(element == arr[i]){
                count++;
            }
        }
        return (count > arr.length/2) ? element : -1; // ternary operator
        // conditon ? true : false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,1,2,2};
        int result  = algorithm(arr);
        System.out.println(result);
    }
    
}
/*
🧠 Intuition (Very Important)

👉 Think like this:

Majority element appears more than n/2 times
So it will always dominate all other elements combined

💡 Idea:

Cancel out different elements one by one
The majority element will still survive

🔥 Core Logic (Step-by-step)

We maintain:

candidate → possible majority element
count → its frequency balance
Rules:
If count == 0 → choose new candidate
If element == candidate → count++
Else → count-- */