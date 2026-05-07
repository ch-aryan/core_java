package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}// i need to understand the binary search trees first.
public class dayVIIIBinarySearchTreeLength {
    public static int getSize(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);

        return 1 + leftSize + rightSize;
    }
}
/*
Size of Binary Tree
Difficulty: BasicAccuracy: 82.91%Submissions: 74K+Points: 1
Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of nodes in the tree.

Examples:

Input:
1 - left is 2 and right is 3. so overall nodes are 3.
Output:  3
Explanation: There are 3 nodes in the given binary tree, so its size is 3.
 */
