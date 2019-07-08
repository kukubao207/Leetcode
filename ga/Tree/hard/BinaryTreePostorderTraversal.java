package Tree.hard;

//145.Given a binary tree, return the postorder traversal of its nodes' values.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Example:
//Input: [1,null,2,3]
//   1
//   \
//   2
//  /
// 3
//Output: [3,2,1]
//Follow up: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePostorderTraversal {
    //1.递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }
    //2.迭代
    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> stack1 = new Stack();
        int left = 1;
        int right = 2;
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.add(cur);
                stack1.add(left);
                cur = cur.left;
            }
            while(!stack.isEmpty() && stack1.peek() == right){
                res.add(stack.pop().val);
                stack1.pop();
            }
            if(!stack.isEmpty() && stack1.peek() == left){
                stack1.pop();
                stack1.push(right);
                cur = stack.peek().right;
            }
        }
        return res;
    }

    //3.迭代（主要就是push和pop两步）
    public List<Integer> postorderTraversal2(TreeNode root) {
        List res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left == null && cur.right == null ||
                    (pre != null && (pre == cur.left || pre == cur.right))){//如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈(万一右孩子为空时，pre=cur.left)
                pre = cur;
                res.add(cur.val);
                stack.pop();
            }else{//pop的时候才是从左到右
                if(cur.right != null) stack.push(cur.right);//先将右结点压栈
                if(cur.left != null) stack.push(cur.left); //再将左结点入栈
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
