package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;
//stack implementation using Array
public class StackInnerImplementation {
    static int top = -1;
    static int arr [] = new int[10];
public static void push(int num) {
    if (top >= arr.length) {
        System.out.println("stack size has got exceeded");
    }
        top = top + 1;
        arr[top] = num;

    }

    public static void printStack(){
        for(int i = 0; i<=top ; i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
        StackInnerImplementation.push(19);
        StackInnerImplementation.push(20);
        StackInnerImplementation.printStack();
    }
}
