113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

题意
求根节点到叶子结点和为sum的路径

我的思路
非常简单，DFS
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
    vector<vector<int>> res;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> v;
        dfs(root,v,0,sum);
        return res;
    }
    void dfs(TreeNode *root,vector<int> &v,int tempsum,int sum)
    {
        if(root==NULL)
            return;
        if(root->left==NULL&&root->right==NULL)
        {
            if(tempsum+root->val==sum)
            {
                v.push_back(root->val);
                res.push_back(v);
                v.pop_back();
            }
            return;
        }
        v.push_back(root->val);
        dfs(root->left,v,tempsum+root->val,sum);
        dfs(root->right,v,tempsum+root->val,sum);
        v.pop_back();

    }
};
