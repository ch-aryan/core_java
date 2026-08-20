package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.Trees;

import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
class Solution{
    public Node binaryTreeRepresentation(ArrayList<Integer> nodes){
    ArrayList<Node> arr = new ArrayList<>();
    Node root = new Node(nodes.get(0));
    arr.add(root);
    for(int i = 0; i<nodes.size(); i++){
        Node current = arr.get(i);
        int leftI = 2 * i+1;
        int rightI = 2*i+2;

        if(leftI < nodes.size()){
            Node left = new Node(nodes.get(leftI));
            current.left = left;
            arr.add(left);
        }
        if(rightI < nodes.size()){
            Node right = new Node(nodes.get(rightI));
            current.right = right;
            arr.add(right);
        }
    }
    return root;
    }
}
public class BinaryTree1 {
    public static void main(String[] args) {
    Solution obj = new Solution();
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
        Node node = obj.binaryTreeRepresentation(arr);
        while(node  != null){
            System.out.println(node.data);
            node = node.left;

        }
    }
}
