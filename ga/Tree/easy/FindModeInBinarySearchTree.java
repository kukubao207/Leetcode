package Tree.easy;

import java.util.ArrayList;
import java.util.List;

//501. Find Mode in Binary Search Tree
//Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//
//For example:
//Given BST [1,null,2,2],
//
//   1
//    \
//     2
//    /
//   2
//
//
//return [2].
//
//Note: If a tree has more than one mode, you can return them in any order.
//
//Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
public class FindModeInBinarySearchTree {
    //1.额外空间的话使用hashmap记录(<val,出现次数>)，记录出现次数最多的次数（max）
    //2.记录前一个数字,中序遍历处理
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[]{};
        inorder(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }


    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int cur = 1;
    int max = 0;
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(pre != null){
            if(pre.val == root.val){
                cur++;
            }else{
                cur = 1;
            }
        }
        if(cur == max)
            list.add(root.val);
        if(cur > max){
            list.clear();
            list.add(root.val);
            max = cur;
        }
        pre = root;
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
