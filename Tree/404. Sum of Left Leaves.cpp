404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

�ҵ�˼·
�ݹ�����
��Ҫע����ǣ�����ж�һ���ڵ�Ϊ��Ҷ�ӽڵ㣿
�ж�����Ϊ
1.�ýڵ�Ϊĳ�ڵ��������
2.�ýڵ�������ӽڵ��ΪNULL

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
    int res=0;
    int sumOfLeftLeaves(TreeNode* root) {
        sum(root);
        return res;
    }
    void sum(TreeNode *root)
    {
        if(root==NULL)
            return ;
        if(root->left!=NULL&&root->left->left==NULL&&root->left->right==NULL)
            res+=root->left->val;
        sum(root->left);
        sum(root->right);
    }
};

���˵Ľⷨ
��ؼ��Ķ�����һ�µģ������ж�ʲôʱ����������һ����Ҷ�ӽڵ㡣
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        if (!root)
        return 0;
        if (root->left && !root->left->left && !root->left->right)
            return root->left->val + sumOfLeftLeaves(root->right);
        return sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
    }
};
