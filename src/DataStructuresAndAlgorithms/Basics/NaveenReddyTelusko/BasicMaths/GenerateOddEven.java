package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.BasicMaths;

public class GenerateOddEven {
    public static void main(String[] args) {
        for(int i =0; i<100;i++){
            if(i%2== 0)
            System.out.println("even "+ i);
        }

        for(int i =1 ; i<100; i = i+2){
            System.out.println("odd "+i);
        }
    }
}
