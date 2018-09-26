100. Same Tree

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

我的思路
用队列进行BFS搜索。
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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p==NULL&&q==NULL)
            return true;
        else if(p==NULL||q==NULL)
            return false;
        queue<TreeNode *> q1,q2;
        q1.push(p);
        q2.push(q);
        while(!q1.empty()&&!q2.empty())
        {
            p=q1.front();
            q1.pop();
            q=q2.front();
            q2.pop();
            if(p->val!=q->val||(p->left==NULL&&q->left!=NULL)||(p->left!=NULL&&q->left==NULL)||(p->right==NULL&&q->right!=NULL)||(p->right!=NULL&&q->right==NULL))
                return false;
            if(p->left!=NULL)
            {
                q1.push(p->left);
                q2.push(q->left);
            }
            if(p->right!=NULL)
            {
                q1.push(p->right);
                q2.push(q->right);
            }
        }
        return true;
    }
};

别人的递归思路

1.如果p为空或者q为空，只有当p==q==NULL时，返回true
2.此时p和q都不为空，只要判断两个根中的值是否相等，再递归判断左右子树是否相同即可。


bool isSameTree(TreeNode *p, TreeNode *q) {
    if (p == NULL || q == NULL)
        return (p == q);
    return (p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right));
}
