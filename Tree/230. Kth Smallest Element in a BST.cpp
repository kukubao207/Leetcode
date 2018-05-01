230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 �� k �� BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

����
��BST���ҵ�kС��Ԫ��
�ҵ�˼·
����һ�������������˵��Ҫ�ҵ�kС�ģ����Ǵ���С��Ԫ�ؿ�ʼ��k����
���и���������BST���ɵõ�һ����������С�
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
    int step=0,result=0;
    int kthSmallest(TreeNode* root, int k) {
        inOrder(root,k);
        return result;
    }
    void inOrder(TreeNode *root,int &k){
        if(root==NULL||step==k)
            return ;
        inOrder(root->left,k);
        if((++step)==k)
            result=root->val;
        inOrder(root->right,k);
    }
};
