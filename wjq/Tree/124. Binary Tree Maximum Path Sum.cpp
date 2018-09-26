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

����
���ڵ��ֵ���Ը�������������һ·���ڵ�͵����ֵ��

˼·
�ݹ�˼·���������ϵ�ÿ���ڵ㣬�ýڵ���������ǣ��������ܷ��ظ���һ�����ͣ��������ܷ��ظ���һ������
����������ֻ��Ϊ����������ߵ�·���ҾͲ�Ҫ�ˣ��ұߵ�����ֻ��Ϊ�������ұߵ�·����Ҳ��Ҫ�ˣ�
��ֱ�Ӹ����ҵ�parent�ڵ㣬����ߵ�·�����ֻ�����ұ����ֵ���������ǲ��Ǹ����������Ҹ��׽��ȥ�ܵ��ˡ�

����ĳ���ڵ���˵��������ǰ�ڵ��·��������=�����������ͣ�������ʡ�ԣ�+�����������ͣ�������ʡ�ԣ�+�����ֵ

����
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
