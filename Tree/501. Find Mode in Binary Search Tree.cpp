501. Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

�ҵ�˼·
����Ҫ����O(1)�ռ�������BST��ͳ�Ƴ�����Ƶ����ߵ����֡�
���BST�����ԣ��и������Ϳ��������������������ֽ�㣬��Ŀ��ת��Ϊͳ��һ���Ѿ��ź���������г���Ƶ����ߵ��������֡�
1.�ȶ����������һ��������ͳ�Ƴ����ִ����������ֳ����˶��ٴΡ�
2.�ڶ����������һ��������ͳ�Ƴ���������Ϊ����������Щ���֡�
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
    int maxFrq=0,cur=0,count=0;
    vector<int> result;
    vector<int> findMode(TreeNode* root) {
        if(root==NULL)
            return result;

        cur=root->val;
        findFrq(root);

        cur=root->val;
        count=0;
        findSame(root);
        return result;
    }
    void findFrq(TreeNode *root){
        if(root==NULL)
            return ;
        findFrq(root->left);
        if(cur==root->val)
            count++;
        else
        {
            cur=root->val;
            count=1;
        }

        if(count>maxFrq)
            maxFrq=count;
        findFrq(root->right);
    }
    void findSame(TreeNode *root){
        if(root==NULL)
            return;
        findSame(root->left);
        if(cur==root->val)
            count++;
        else
        {
            cur=root->val;
            count=1;
        }
        if(count==maxFrq)
            result.push_back(root->val);
        findSame(root->right);
    }
};
