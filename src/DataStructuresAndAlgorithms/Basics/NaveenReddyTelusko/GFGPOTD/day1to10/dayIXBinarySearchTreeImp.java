package DataStructuresAndAlgorithms.Basics.NaveenReddyTelusko.GFGPOTD.day1to10;
// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int x) {
//         data = x;
//         left = right = null;
//     }
// }
public class dayIXBinarySearchTreeImp {
    class Solution {

        public boolean isSubtree(Node root1, Node root2) {
            // If big tree is empty → can't contain anything
            if (root1 == null) return false;

            // If trees match at this node
            if (isSame(root1, root2)) return true;

            // Otherwise check left and right
            return isSubtree(root1.left, root2) ||
                    isSubtree(root1.right, root2);
        }

        public boolean isSame(Node a, Node b) {
            // Both null → same
            if (a == null && b == null) return true;

            // One null → not same
            if (a == null || b == null) return false;

            // Value mismatch → not same
            if (a.data != b.data) return false;

            // Check left and right
            return isSame(a.left, b.left) &&
                    isSame(a.right, b.right);
        }
    }
}
/*
Check if subtree Given two binary trees with roots root1 (for tree T) and root2 (for tree S),
each containing at most N nodes.
Determine whether tree S is a subtree of tree T.
Return true if S is a subtree of T, otherwise return false. Note:
A tree S is considered a subtree of T if there exists a node in T such that the subtree rooted at that
node is identical to S. Two trees are identical if they have the same structure
and the same node values. Examples:Input: root1 = [1, 2, 3, N, N, 4], root2 = [3, 4]Output: true
Explanation: In the tree rooted at root1, the subtree starting at node 3 is identical to the tree
rooted at root2 (same structure and node values).
 Hence, root2 is a subtree of root1, so the output is true.

 Nice — this is exactly the kind of “new but manageable” problem you should face during POTD 👍
Let’s break it very simply, without dragging you deep into full tree theory.

🌳 What the question is saying (in plain English)

You have:

Tree T (root1) → big tree
Tree S (root2) → small tree

👉 You need to check:
Does S appear anywhere inside T exactly the same?

In your example:

T =       1
        /   \
       2     3
            /
           4

S =     3
       /
      4

👉 Starting at node 3 in T → it matches S exactly
So answer = true

🧠 Core idea (THIS is what you need to learn)

There are only 2 things happening:

1. Traverse the big tree (T)

Check every node:

“Can subtree start here?”

2. Compare two trees

Check:

“Are these two trees exactly same?”

🔑 Final Logic

At every node in T:

If trees match → return true
Otherwise → go left or right
 */