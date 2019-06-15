package Tree.easy;

import java.util.Stack;

//100. 相同的树
//给定两个二叉树，编写一个函数来检验它们是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//示例 1:
//
//输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//示例 2:
//
//输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//示例 3:
//
//输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
public class SameTree {
    //递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //迭代
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while(!stack.isEmpty()){
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if(t1 == null && t2 == null)
                continue;
            else if(t1 == null || t2 == null)
                return false;
            else if (t1.val != t2.val)
                return false;
            stack.add(t1.left);
            stack.add(t2.left);
            stack.add(t1.right);
            stack.add(t2.right);
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
