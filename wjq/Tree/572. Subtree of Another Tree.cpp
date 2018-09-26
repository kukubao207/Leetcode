572. Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

我的思路
写一个递归函数判断两个树是否相同，再写一个递归函数判断某树是否存在一个子树和某数相同。
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
    bool isSubtree(TreeNode* s, TreeNode* t) {
        if(s==NULL)
            return false;
        if(isSame(s,t))
            return true;
        if(isSubtree(s->left,t))
            return true;
        if(isSubtree(s->right,t))
            return true;
        return false;
    }
    bool isSame(TreeNode *t1,TreeNode *t2){
        if(t1==NULL)
            return t2==NULL;
        if(t2==NULL)
            return t1==NULL;
        //now they are not NULL;
        return t1->val==t2->val&&isSame(t1->left,t2->left)&&isSame(t1->right,t2->right);
    }
};
