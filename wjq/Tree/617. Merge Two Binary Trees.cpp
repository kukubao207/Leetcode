617. Merge Two Binary Trees

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
Note: The merging process must start from the root nodes of both trees.

我的思路

用广度优先搜索算法，我不会更改Tree1和Tree2。
第一次搜索Tree1，然后建立一个Tree3与Tree1一模一样。
第二次搜索Tree2：
    如果Tree2上的结点，Tree3已经存在了，那么只要把Tree2结点上的值加到Tree3中的结点中。
    如果Tree2上的结点，Tree3中不存在，那么需要建立一个新的结点并把Tree2中的值赋给他。

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
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        if(t1==NULL&&t2==NULL)
            return NULL;
        TreeNode *t3=new TreeNode(0);
        if(t1!=NULL)
        {
            t3->val+=t1->val;
            bfs(t1,t3);
        }
        if(t2!=NULL)
        {
            t3->val+=t2->val;
            bfs(t2,t3);
        }
        return t3;
    }

    void bfs(TreeNode *t,TreeNode *&t3)
    {
        queue<TreeNode *> q,q3;
        q.push(t);
        q3.push(t3);
        while(!q.empty())
        {
            TreeNode *cur=q.front();
            TreeNode *cur3=q3.front();
            q.pop();
            q3.pop();
            if(cur->left!=NULL)
            {
                if(cur3->left==NULL)
                    cur3->left=new TreeNode(cur->left->val);
                else
                    cur3->left->val+=cur->left->val;
                q3.push(cur3->left);
                q.push(cur->left);
            }
            if(cur->right!=NULL)
            {
                if(cur3->right==NULL)
                    cur3->right=new TreeNode(cur->right->val);
                else
                    cur3->right->val+=cur->right->val;
                q3.push(cur3->right);
                q.push(cur->right);
            }
        }
    }
};

别人的思路
递归做法

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }
}

class Solution {
public:
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        if ( t1 && t2 ) {
            TreeNode * root = new TreeNode(t1->val + t2->val);
            root->left = mergeTrees(t1->left, t2->left);
            root->right = mergeTrees(t1->right, t2->right);
            return root;
        } else {
            return t1 ? t1 : t2;
        }
    }
};
