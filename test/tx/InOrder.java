package tx;

import java.util.Stack;

public class InOrder {
    public static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args){
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(0);
    }
}
