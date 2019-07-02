package Tree.easy;

import java.util.ArrayList;
import java.util.List;

//257. Binary Tree Paths
//Given a binary tree, return all root-to-leaf paths.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
public class BinaryTreePaths {
    //回溯
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String str = "";
        helper(root, res, str);
        return res;
    }

    public void helper(TreeNode root, List<String> res, String str) {
        if(root == null)
            return;
        else if(root.left == null && root.right == null){
            str = str + root.val;
            res.add(str);
        }else{
            str = str + root.val + "->";
        }
        helper(root.left, res, str);
        helper(root.right, res, str);
//        str = str.substring(0,str.length() - 1);//对于string，此步骤可不要，等号赋值的可以回到过去
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
