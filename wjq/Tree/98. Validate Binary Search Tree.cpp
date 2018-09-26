98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

����
�ж�һ�����Ƿ�ΪBST

�ҵ�˼·
BST���ص������и��������Եõ�һ���������У�
�����ֻ��Ҫ�и������������������һ�����н���ֵ�Ƿ��������м��ɡ�

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
    bool result=true;
    int i=0,pre=0;
    bool isValidBST(TreeNode* root) {
        preOrder(root);
        return result;
    }
    void preOrder(TreeNode *root){
        if(root==NULL)
            return;
        preOrder(root->left);
        if(root->val<=pre&&i!=0)
            result=false;
        i++;
        pre=root->val;
        preOrder(root->right);
    }
};

���˵�˼·
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* prev = NULL;
        return validate(root, prev);
    }
    bool validate(TreeNode* node, TreeNode* &prev) {
        if (node == NULL)
            return true;
        if (!validate(node->left, prev))
            return false;
        if (prev != NULL && prev->val >= node->val)
            return false;
        prev = node;
        return validate(node->right, prev);
    }
};
