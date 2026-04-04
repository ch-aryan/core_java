package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class MIN_MAX {
    public static void main(String[] args) {
        int [] arr = {12,24,22, 1, 89,9, 3};
        //so to know which number is smaller and which is greater we use.
        int max = Integer.MIN_VALUE;// we do opposite here.
        int min = Integer.MAX_VALUE;// same opposite here.

        for(int i: arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        System.out.println(max +" max in array");
        System.out.println(min + " min in array");
    }
}
