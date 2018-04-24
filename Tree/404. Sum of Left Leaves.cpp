404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

我的思路
递归做法
需要注意的是，如何判断一个节点为左叶子节点？
判断条件为
1.该节点为某节点的左子树
2.该节点的左右子节点均为NULL

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
    int res=0;
    int sumOfLeftLeaves(TreeNode* root) {
        sum(root);
        return res;
    }
    void sum(TreeNode *root)
    {
        if(root==NULL)
            return ;
        if(root->left!=NULL&&root->left->left==NULL&&root->left->right==NULL)
            res+=root->left->val;
        sum(root->left);
        sum(root->right);
    }
};

别人的解法
最关键的东西是一致的，必须判断什么时候遇到的是一个左叶子节点。
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        if (!root)
        return 0;
        if (root->left && !root->left->left && !root->left->right)
            return root->left->val + sumOfLeftLeaves(root->right);
        return sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
    }
};
