package Tree.medium;

import java.util.ArrayList;
import java.util.List;

//129. Sum Root to Leaf Numbers
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
//Example 2:
//
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.
public class SumRootToLeafNumbers {
    //回溯
    int total = 0;
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return total;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null)
            total = total + toSum(list);
        dfs(root.left, list);
        dfs(root.right, list);
        list.remove(list.size() - 1);
    }
    public int toSum(List<Integer> list){
        String number = "";
        for(Integer l: list)
            number = number + l;
        return Integer.parseInt(number);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
