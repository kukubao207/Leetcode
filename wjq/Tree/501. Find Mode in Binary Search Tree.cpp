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

我的思路
题意要求在O(1)空间内搜索BST，统计出出现频率最高的数字。
针对BST的特性，中根遍历就可以以升序搜索所有数字结点，题目就转变为统计一个已经排好序的数组中出现频率最高的所有数字。
1.先对这个数组做一次搜索，统计出出现次数最多的数字出现了多少次。
2.在对这个数组做一次搜索，统计出出现数字为最多次数的那些数字。
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
