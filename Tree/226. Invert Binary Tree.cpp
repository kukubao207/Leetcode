226. Invert Binary Tree

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

我的思路

递归做法
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
    TreeNode* invertTree(TreeNode* root) {
        if(root==NULL)
            return NULL;
        TreeNode *temp=root->left;
        root->left=invertTree(root->right);
        root->right=invertTree(temp);
        return root;
    }
};
迭代做法
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
    TreeNode* invertTree(TreeNode* root) {
        if(root==NULL)
            return NULL;
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode *cur=q.front();
            q.pop();

            TreeNode *temp=cur->left;
            cur->left=cur->right;
            cur->right=temp;

            if(cur->left!=NULL)
                q.push(cur->left);
            if(cur->right!=NULL)
                q.push(cur->right);
        }
        return root;
    }
};

