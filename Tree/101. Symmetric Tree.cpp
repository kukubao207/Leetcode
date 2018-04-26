101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

�ҵ�˼·
�ݹ�ⷨ recursively
�Ȱ���������һ������ת��Ȼ�����������Ա��Ƿ���ȫ��ͬ��

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
    bool isSymmetric(TreeNode* root) {
        if(root==NULL)
            return true;
        root->left=InvertTree(root->left);
        return SameTree(root->left,root->right);
    }
    TreeNode* InvertTree(TreeNode *root){
        if(root==NULL)
            return NULL;
        TreeNode *temp=root->left;
        root->left=InvertTree(root->right);
        root->right=InvertTree(temp);
        return root;
    }
    bool SameTree(TreeNode *t1,TreeNode *t2){
        if(t1==NULL)
            return t2==NULL;
        if(t2==NULL)
            return t1==NULL;
        //now t1!=NULL&&t2!=NULL
        return t1->val==t2->val&&SameTree(t1->left,t2->left)&&SameTree(t1->right,t2->right);
    }
};

�����ⷨ iteratively

