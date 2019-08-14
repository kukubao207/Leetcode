package Stack.medium;

import java.util.Stack;

//173. Binary Search Tree Iterator
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//
//
//Example:
//
//
//
//BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // return 3
//iterator.next();    // return 7
//iterator.hasNext(); // return true
//iterator.next();    // return 9
//iterator.hasNext(); // return true
//iterator.next();    // return 15
//iterator.hasNext(); // return true
//iterator.next();    // return 20
//iterator.hasNext(); // return false
//
//
//Note:
//
//next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
//You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
public class BSTIterator {
    //二叉搜索树 中序遍历按从小到大输出
    Stack<TreeNode> stack;
    int res;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        if(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res = cur.val;
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stack.isEmpty())
            return true;
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
