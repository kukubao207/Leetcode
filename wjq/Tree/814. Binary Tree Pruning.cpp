814. Binary Tree Pruning

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.


Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]



Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]



Note:

The binary tree will have at most 100 nodes.
The value of each node will only be 0 or 1.

我的思路

题意，一个树中只有0结点和1结点，要求删除一些0结点，这些被删除的0结点的子树中不包含1结点。

思考过程是这样的，很显然这是一道要求改变树的结构的题，那么递归函数的返回值肯定是TreeNode *，
考虑用怎样的递归去完成这项删除，一开始定下来是后根遍历，先把左右子树中符合要求的0结点删完，
再去判断本结点是否保留，不保留那也返回NULL.

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
    TreeNode* pruneTree(TreeNode* root) {
        if(root==NULL)
            return NULL;
        if(root->left==NULL&&root->right==NULL&&root->val==0)
            return NULL;
        root->left=pruneTree(root->left);
        root->right=pruneTree(root->right);
        if(root->left==NULL&&root->right==NULL&&root->val==0)
            return NULL;
        return root;
    }
};

别人的思路
和我是类似的，但比我少了两行。
TreeNode* pruneTree(TreeNode* root) {
    if (!root)
        return NULL;
    root->left = pruneTree(root->left);
    root->right = pruneTree(root->right);
    if (!root->left && !root->right && root->val == 0)
        return NULL;
    return root;
}

