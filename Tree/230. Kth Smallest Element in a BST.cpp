230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

题意
在BST中找第k小的元素
我的思路
对于一个升序的序列来说，要找第k小的，就是从最小的元素开始走k步。
以中根遍历搜索BST即可得到一个升序的序列。
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
