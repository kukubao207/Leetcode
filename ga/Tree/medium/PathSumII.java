package Tree.medium;
import java.util.ArrayList;
import java.util.List;
//113.Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//Note: A leaf is a node with no children.

//Example:
//Given the below binary tree and sum = 22,
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1

//Return:
//[[5,4,11,2],[5,8,4,5]]
public class PathSumII {
    //回溯
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, sum, res, list);
        return res;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val)
                res.add(new ArrayList<Integer>(list));
        helper(root.left, sum - root.val, res, list);
        helper(root.right, sum - root.val , res, list);
        list.remove(list.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
