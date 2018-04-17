144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

我的做法

1.递归思路
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        preorder(res,root);
        return res;
    }
    void preorder(vector<int> &res,TreeNode* root)
    {
        if(root==NULL)
            return;
        res.push_back(root->val);
        preorder(res,root->left);
        preorder(res,root->right);
    }
};
2.迭代思路
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if(root==NULL)
            return res;
        stack<TreeNode *> s;
        s.push(root);
        res.push_back(root->val);
        while(!s.empty())
        {
            root=s.top();
            if(root->left!=NULL)
            {
                s.push(root->left);
                res.push_back(root->left->val);
                root->left=NULL;
                continue;
            }
            if(root->right!=NULL)
            {
                s.push(root->right);
                res.push_back(root->right->val);
                root->right=NULL;

                continue;
            }
            s.pop();
        }
        return res;
    }

};

别人的解法
class Solution {
public:
vector<int> preorderTraversal(TreeNode *root) {
        if (root==NULL) {
            return vector<int>();
        }
        vector<int> result;
        stack<TreeNode *> treeStack;
        treeStack.push(root);
        while (!treeStack.empty()) {
            TreeNode *temp = treeStack.top();
            result.push_back(temp->val);
            treeStack.pop();
            if (temp->right!=NULL) {
                treeStack.push(temp->right);
            }
            if (temp->left!=NULL) {
                treeStack.push(temp->left);
            }
        }
        return result;
    }
};
