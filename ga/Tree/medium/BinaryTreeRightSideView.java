package Tree.medium;

//199.Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

//Example:

//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:

import java.util.*;

//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
public class BinaryTreeRightSideView {
    //递归
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res, int curDepth) {
        if(root == null)
            return;
        //每层遍历的第一个节点加入结果中
        if(res.size() == curDepth)
            res.add(root.val);//res一层只存放第一次出现的数字
        //先访问右孩子
        helper(root.right, res, curDepth + 1);
        helper(root.left, res, curDepth + 1);
    }

    //迭代 层次遍历的变形
    public List<Integer> rightSideView1(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(root.val);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){//一层遍历结束
                TreeNode node = queue.poll();
                if(node.right != null)
                    queue.add(node.right);
                if(node.left != null)
                    queue.add(node.left);
                count--;
            }
            if(!queue.isEmpty())
                res.add(queue.peek().val);
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
