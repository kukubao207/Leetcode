110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

我的思路
一开始理解错了，题目的意思是每一个结点的左右子树都是高度平衡二叉树，所谓高度理解为子树最长的一条路径的高度。
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root==NULL)
            return true;
        if(root->left==NULL&&root->right==NULL)
            return true;
        else if(root->left==NULL&&root->right!=NULL)
            return height(root->right)<=1;
        else if(root->left!=NULL&&root->right==NULL)
            return height(root->left)<=1;
        else{
            int lh=height(root->left);
            int rh=height(root->right);
            return abs(lh-rh)<=1&&isBalanced(root->left)&&isBalanced(root->right);
        }
    }
    int height(TreeNode *root){
        if(root==NULL)
            return 0;
        int lh=height(root->left)+1;
        int rh=height(root->right)+1;
        return max(lh,rh);
    }
};

别人的思路 JAVA代码
在求最大子树高度的同时，直接对比左右子树的高度,只对树做一次搜索，时间复杂度O(n)

public class Solution {
private boolean result = true;

public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return result;
}
public int maxDepth(TreeNode root) {
    if (root == null)
        return 0;
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    if (Math.abs(l - r) > 1)
        result = false;
    return 1 + Math.max(l, r);
}
}
