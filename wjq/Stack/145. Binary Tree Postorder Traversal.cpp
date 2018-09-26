145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

递归解法
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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        post(root,res);
        return res;
    }
    void post(TreeNode *root,vector<int> &res)
    {
        if(root==NULL)
            return;
        post(root->left,res);
        post(root->right,res);
        res.push_back(root->val);
    }
};

非递归解法
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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if(root==NULL)
            return res;
        stack<TreeNode *> s;
        s.push(root);
        while(!s.empty()){
            TreeNode *cur=s.top();
            if(cur->left!=NULL){
                s.push(cur->left);
                cur->left=NULL;
            }
            else if(cur->right!=NULL){
                s.push(cur->right);
                cur->right=NULL;
            }
            else{
                res.push_back(cur->val);
                s.pop();
            }
        }
        return res;
    }

};

