package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.AHA_Movement;

public class countingLogic {
    public static void main(String[] args) {
        int pushCount = 0;
        int pushes = 1;
        int size = 0;
        while(true){
            if(size == 8 ){
                size = 0;
                pushes++;
            }
            if(pushes ==3){
                break;
            }
            pushCount = pushCount + pushes;
            size++;

        }
        System.out.println(pushCount);
    }
}
