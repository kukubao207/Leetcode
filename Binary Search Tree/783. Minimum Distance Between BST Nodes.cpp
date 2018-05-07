783. Minimum Distance Between BST Nodes

Given a Binary Search Tree (BST) with the root node root, return the minimum difference
between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also
between node 3 and node 2.

Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

思路
中根遍历搜索BST即可得到一个升序序列，通过做差来判断最小差是多少。
注意第一个节点是没有前面的结点的，不能做判断。

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
    TreeNode *prev=new TreeNode(0),*p=prev;
    int minDiffInBST(TreeNode* root) {
        inorder(root);
        return minDiff;
    }
    void inorder(TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(root->left);
        if(prev!=p&&root->val-prev->val<minDiff)
            minDiff=root->val-prev->val;
        prev=root;
        inorder(root->right);
    }
};
