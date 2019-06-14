package Tree.medium;
// 94. 二叉树的中序遍历
//给定一个二叉树，返回它的中序 遍历。
//
//示例:
//
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    //中序遍历：左中右
    //1.递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            if(root.left != null){
                dfs(root.left, res);
            }
            res.add(root.val);
            if(root.right != null){
                dfs(root.right, res);
            }
        }
    }

    //2.迭代
    //利用栈模拟遍历过程
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){//一直向左便利，一直到便利到叶子节点
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    //先序迭代遍历(类似)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){//一直向左便利，一直到便利到叶子节点
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
    //后序迭代遍历(稍复杂)
    //从左子树回退到根节点，还是从右子树回退到根节点???
    // 如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，此时就应该访问根节点。
    //相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，还是从右子树返回进而决定下一步的操作。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> stack1 = new Stack();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(cur);
                stack1.push(left);
                cur = cur.left;
            }
            while(!stack.isEmpty() && stack1.peek() == right){
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack1.pop();
                res.add(stack.pop().val);
            }
            if(!stack.isEmpty() && stack1.peek() == left){
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack1.pop();
                stack1.push(right);
                cur = stack.peek().right;
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
