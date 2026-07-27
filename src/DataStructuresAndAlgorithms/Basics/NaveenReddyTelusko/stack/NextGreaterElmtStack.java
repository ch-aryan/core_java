package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.stack;

import java.util.ArrayList;

public class NextGreaterElmtStack {

        public ArrayList<Integer> nextLargerElement(int[] arr) {
            // code here
            ArrayList<Integer> res = new ArrayList<>();
            for(int i =0; i<arr.length-1 ; i++)
            {
                boolean flag = false;
                for(int j = i+1; j<arr.length; j++)
                {
                    if(arr[j] > arr[i]){
                        res.add(arr[j]);
                        flag = true;
                        break;
                    }else{
                        flag = false;
                    }
                }
                if(flag == false){
                    res.add(-1);
                }
            }
            res.add(-1);
            return res;

    }
    //strivers monotonic stack/
//    for (int i = n - 1; i >= 0; i--) {
//        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
//            stack.pop();
//        }
//
//        if (stack.isEmpty()) {
//            res[i] = -1;
//        } else {
//            res[i] = stack.peek();
//        }
//
//        stack.push(arr[i]);
//    }
}
