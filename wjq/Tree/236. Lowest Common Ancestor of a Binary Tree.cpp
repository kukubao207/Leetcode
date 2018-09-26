236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).��

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

����
�����������������������

˼·
���鼯��˼�룬unordered_map<TreeNode*,TreeNode*> parent������ÿһ�����ڵ�ĸ��׽�㣬
ͨ��parent����p�ĸ��ڵ�·��������ÿһ����㵽unordered_map<TreeNode*,bool> map�С�
ͨ��parent����q�ĸ��ڵ�·�������������ĵ�һ��������map�еĽ�㡣
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

�ҵ�˼·�Ľ�����ʵ�ϣ�������·���Ľ���㣬�������Ǳ�������
�Ľ��´��룬ʡȥ�ڶ���unordered_map

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

���˵�˼·
ֱ�ӶԸ�����ݹ����
���������ȥ�����������p��q������������������������
�ײ��ݹ������һ�㣬�ҵ���ߴ���һ��Ŀ�����������ҵ��ұߴ���һ��Ŀ������
һ������һ����㣬��ߴ���һ��Ŀ����ͬʱ�ұߴ���һ��Ŀ��������ô�������������������ȡ�

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
