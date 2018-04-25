107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

解题思路
这道题非常简单，实现二叉树的层次遍历即可，然后用堆栈将每一层的数组压入，最后反转数组（pop并save）
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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        if(root==NULL)
            return res;
        //level order
        stack<vector<int>> temp;
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty())
        {
            int n=q.size();
            vector<int> v;
            for(int i=0;i<n;i++)
            {
                root=q.front();
                q.pop();
                v.push_back(root->val);
                if(root->left!=NULL)
                    q.push(root->left);
                if(root->right!=NULL)
                    q.push(root->right);
            }
            temp.push(v);
        }
        //pop and save
        while(!temp.empty())
        {
            res.push_back(temp.top());
            temp.pop();
        }
        return res;
    }
};

别人的解法
递归做法
vector<vector<int> > levelOrder(TreeNode *root) {
	vector<vector<int> > retVal;

	levelOrder(root, retVal, 0);

	reverse(retVal.begin(), retVal.end());

	return retVal;
}

void levelOrder(TreeNode* root, vector<vector<int> > &v, int currLevel) {
	if (root == NULL) {
		return;
	}

	if (v.empty() || currLevel > (v.size() - 1)) {
		v.push_back(vector<int>());
	}

	v[currLevel].push_back(root->val);

	levelOrder(root->left, v, currLevel + 1);
	levelOrder(root->right, v, currLevel + 1);
}
