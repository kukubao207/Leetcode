package Exam2020.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        Stack<String> stack1 = new Stack();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(cur);
                stack1.push("left");
                cur = cur.left;
            }
            while (!stack.isEmpty() && stack1.peek().equals("right")) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack1.pop();
                res.add(stack.pop().val);
            }
            if (!stack.isEmpty() && stack1.peek().equals("left")) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack1.pop();
                stack1.push("right");
                cur = stack.peek().right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack();

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null || pre == cur.right) {//当该节点的右子树为空或者该节点的右节点是上次遍历过的节点，则直接弹出
                res.add(cur.val);
                stack.pop();
                pre = cur;
                cur = null;//当弹出一个节点时，说明该树已经遍历完了，那么就要把cur设置为NULL
            } else {//否则就遍历右子树
                cur = cur.right;
                pre = null;
            }
        }

        return res;
    }
}
