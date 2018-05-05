236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

题意
求两颗子树的最近公共祖先

思路
并查集的思想，unordered_map<TreeNode*,TreeNode*> parent来保存每一个树节点的父亲结点，
通过parent遍历p的父节点路径，保存每一个结点到unordered_map<TreeNode*,bool> map中。
通过parent遍历q的父节点路径，返回遇到的第一个存在于map中的结点。
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

    unordered_map<TreeNode*,TreeNode *> parent;
    unordered_map<TreeNode*,bool> m;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

        findParent(root);
        while(p!=NULL)
        {
            m[p]=true;
            p=parent[p];
        }
        while(q!=NULL)
        {
            if(m[q]==true)
                return q;
            q=parent[q];
        }
        return NULL;

    }
    void findParent(TreeNode *root)
    {
        if(root==NULL)
            return;
        if(root->left!=NULL)
        {
            parent[root->left]=root;
            findParent(root->left);
        }
        if(root->right!=NULL)
        {
            parent[root->right]=root;
            findParent(root->right);
        }
    }
};

我的思路改进，事实上，求两条路径的交叉点，在链表那边做过。
改进下代码，省去第二个unordered_map

class Solution {
public:

    unordered_map<TreeNode*,TreeNode *> parent;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {

        findParent(root);
        TreeNode *savep=p,*saveq=q;
        while(p!=q)
        {
            if(p!=root)
                p=parent[p];
            else
                p=saveq;
            if(q!=root)
                q=parent[q];
            else
                q=savep;
        }
        return p;

    }
    void findParent(TreeNode *root)
    {
        if(root==NULL)
            return;
        if(root->left!=NULL)
        {
            parent[root->left]=root;
            findParent(root->left);
        }
        if(root->right!=NULL)
        {
            parent[root->right]=root;
            findParent(root->right);
        }
    }
};

别人的思路
直接对该问题递归求解
后根遍历，去搜索这个树找p，q结点存在于左子树还是右子树
底层会递归告诉上一层，我的左边存在一个目标量，或者我的右边存在一个目标量。
一旦到了一个结点，左边存在一个目标量同时右边存在一个目标量，那么这个结点就是最近公共祖先。

class Solution {
public:

    unordered_map<TreeNode*,TreeNode *> parent;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL||root==p||root==q)
            return root;
        TreeNode *left=lowestCommonAncestor(root->left,p,q);
        TreeNode *right=lowestCommonAncestor(root->right,p,q);

        if(left!=NULL&&right!=NULL)
            return root;
        if(left==NULL&&right!=NULL)
            return right;
        if(left!=NULL&&right==NULL)
            return left;
        if(left==NULL&&right==NULL)
            return NULL;
    }

};
