package Tree.easy;

import java.util.Stack;

//101. 对称二叉树
//给定一个二叉树，检查它是否是镜像对称的。
//
//例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//说明:
//
//如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
//
public class SymmetricTree {
    //1.递归
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
    //2.迭代
    //利用栈存储
    public boolean isSymmetric1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if(p == null && q == null)
                continue;
            else if(p == null || q == null)
                return false;
            else if (p.val != q.val)
                return false;
            stack.add(p.left);
            stack.add(q.right);
            stack.add(p.right);
            stack.add(q.left);
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
