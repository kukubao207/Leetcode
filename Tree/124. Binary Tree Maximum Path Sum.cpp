124. Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from
some starting node to any node in the tree along the parent-child
connections. The path must contain at least one node and does not
need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

题意
树节点的值可以负数，求树上任一路径节点和的最大值。

思路
递归思路，对于树上的每个节点，该节点想的事情是，左子树能返回给我一个最大和，右子树能返回给我一个最大和
如果左边最大和只能为负数，那左边的路径我就不要了，右边的最大和只能为负数，右边的路径我也不要了，
我直接告诉我的parent节点，我这边的路径最大只能是我本身的值，至于我是不是负数，是由我父亲结点去管的了。

对于某个节点来说，穿过当前节点的路径的最大和=左子树的最大和（负数则省略）+右子树的最大和（负数则省略）+本身的值

代码
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
    int max_value=INT_MIN;
    int maxPathSum(TreeNode* root) {
        compute(root);
        return max_value;
    }
    int compute(TreeNode *root){
        if(root==NULL)
            return 0;
        int left=max(0,compute(root->left));
        int right=max(0,compute(root->right));
        max_value=max(max_value,left+right+root->val);
        return max(left,right)+root->val;
    }
};
