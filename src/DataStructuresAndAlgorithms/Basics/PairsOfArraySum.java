package DataStructuresAndAlgorithms.Basics;

public class PairsOfArraySum {
    public static void main(String[] args) {
        int[] arr = {1,5,4,14,6,2,10,13,12,8};
        int sum = 15;
        for(int i =0;i<arr.length-1;i++){
            for(int j=i;j < arr.length;j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println(i +" " + j);
                }
            }
        }
    }
}
