530. Minimum Absolute Difference in BST

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.


题意
求BST上两个结点的绝对值差的最小值

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
    int minDiff=INT_MAX;
    TreeNode *prev=NULL;
    int getMinimumDifference(TreeNode* root) {
        inorder(root);
        return minDiff;
    }
    void inorder(TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(root->left);
        if(prev!=NULL&&root->val-prev->val<minDiff)
            minDiff=root->val-prev->val;
        prev=root;
        inorder(root->right);
    }
};
