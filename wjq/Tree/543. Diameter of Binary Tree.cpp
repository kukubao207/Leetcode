543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

解题思路
一开始我理解错了，没有看到 This path may or may not pass through the root.
所以写了一个必须穿过根的算法，在这里先记录下来，以后可能遇到穿过根的直径，可以拿出来试试。
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    stack<int> s;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        if(root->left==NULL&&root->right==NULL)
            return 0;
        int height1=dfs(root)-1;

        if(s.top()==0)
            root->left=NULL;
        else
            root->right=NULL;

        int height2=dfs(root)-1;
        return height1+height2;
    }
    int dfs(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        int lh=1+dfs(root->left);
        int rh=1+dfs(root->right);
        if(lh>rh)
            s.push(0);
        else
            s.push(1);
        return lh>rh?lh:rh;
    }
};

那么此题的解题思路就非常简单了，求出每个节点左子树和右子树的高度相加，不断和maxLength比较即可。
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int max_length=0;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        dfs(root);
        return max_length-2;
    }
    int dfs(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        int lh=1+dfs(root->left);
        int rh=1+dfs(root->right);
        if(lh+rh>max_length)
            max_length=lh+rh;
        return lh>rh?lh:rh;
    }
};

看下别人的解法
思路一致，代码更优美一些。
class Solution {
public:
    int maxdiadepth = 0;

    int dfs(TreeNode* root){
        if(root == NULL)
            return 0;
        int leftdepth = dfs(root->left);
        int rightdepth = dfs(root->right);
        if(leftdepth + rightdepth > maxdiadepth)
            maxdiadepth = leftdepth + rightdepth;
        return max(leftdepth +1, rightdepth + 1);
    }

    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return maxdiadepth;
    }
};
