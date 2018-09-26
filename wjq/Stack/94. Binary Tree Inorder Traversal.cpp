94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

我的解法

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

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorder(result,root);
        return result;
    }
    void inorder(vector<int> &result,TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(result,root->left);
        result.push_back(root->val);
        inorder(result,root->right);
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

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root==NULL)
            return result;
        stack<TreeNode*> s;
        s.push(root);
        while(!s.empty())
        {
            root=s.top();
            if(root->left!=NULL)
            {
                s.push(root->left);
                root->left=NULL;        //*****这里比较重要，防止下次还访问左结点
            }
            else
            {
                result.push_back(root->val);
                if(root->right!=NULL)
                    s.push(root->right);
                s.pop();                //无论如何，这个父节点的工作：
                                        //1.帮助寻找子节点 2.自身值记录 都已经完成，没他的事儿了。
            }
        }
        return result;
    }

};
