95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

我的思路
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
    vector<TreeNode*> generateTrees(int n) {
        if(n==0)
        {
            vector<TreeNode *> res;
            return res;
        }
        return gen(1,n);
    }
    vector<TreeNode *> gen(int start,int end)
    {
        vector<TreeNode *> result;

        if(start>end)
        {
            result.push_back(NULL);
            return result;
        }

        for(int i=start;i<=end;i++)
        {
            vector<TreeNode *> left = gen(start,i-1);
            vector<TreeNode *> right = gen(i+1,end);

            for(int j=0;j<left.size();j++)
            {
                for(int k=0;k<right.size();k++)
                {
                    TreeNode *root = new TreeNode(i);
                    root->left=left[j];
                    root->right=right[k];
                    result.push_back(root);
                }
            }
        }
        return result;
    }
};
