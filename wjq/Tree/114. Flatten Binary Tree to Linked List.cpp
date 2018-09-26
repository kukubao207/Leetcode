114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

我的思路
递归
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
    TreeNode *prev=NULL;
    void flatten(TreeNode* root) {
        if(root==NULL)
            return ;
        flatten(root->right);
        flatten(root->left);
        root->right=prev;
        root->left=NULL;
        prev=root;
    }


};

迭代
class Solution {
public:
    TreeNode *prev=NULL;
    void flatten(TreeNode* root) {
        while(root)
        {
            if(root->left==NULL)
                root=root->right;
            else{
                if(root->right)
                {
                    TreeNode *l=root->left;
                    while(l->right!=NULL)
                        l=l->right;
                    l->right=root->right;
                }
                root->right=root->left;
                root->left=NULL;
                root=root->right;
            }
        }
    }
};
