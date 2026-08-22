package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution1{
    public ArrayList<Integer> iteratorTree(Node root){
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        ArrayList<Integer> arr = new ArrayList<>();
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            arr.add(curr.data);
            if(curr.right != null){
                stack.add(curr.right);
            }
            if(curr.left != null){
                stack.add(curr.left);
            }
        }
        return arr;
    }
}
public class BinaryTreeIterator1 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
