package Tree.medium;

import java.util.ArrayList;
import java.util.List;

//894. All Possible Full Binary Trees
//A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//
//Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
//
//Each node of each tree in the answer must have node.val = 0.
//
//You may return the final list of trees in any order.
//
//
//
//Example 1:
//
//Input: 7
//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//Explanation:
//
//
//
//Note:
//
//1 <= N <= 20
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        //偶数是不能构成满二叉树的
        List<TreeNode> res = new ArrayList<>();
        if(N % 2 == 0)
            return res;
        if(N == 1){
            TreeNode root = new TreeNode(0);
            res.add(root);
            return res;
        }
        for(int i = 1; i < N; i = i + 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
