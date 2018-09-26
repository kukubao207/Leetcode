543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

����˼·
һ��ʼ�������ˣ�û�п��� This path may or may not pass through the root.
����д��һ�����봩�������㷨���������ȼ�¼�������Ժ����������������ֱ���������ó������ԡ�
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
    stack<int> s;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        if(root->left==NULL&&root->right==NULL)
            return 0;
        int height1=dfs(root)-1;

        if(s.top()==0)
            root->left=NULL;
        else
            root->right=NULL;

        int height2=dfs(root)-1;
        return height1+height2;
    }
    int dfs(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        int lh=1+dfs(root->left);
        int rh=1+dfs(root->right);
        if(lh>rh)
            s.push(0);
        else
            s.push(1);
        return lh>rh?lh:rh;
    }
};

��ô����Ľ���˼·�ͷǳ����ˣ����ÿ���ڵ����������������ĸ߶���ӣ����Ϻ�maxLength�Ƚϼ��ɡ�
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
    int max_length=0;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        dfs(root);
        return max_length-2;
    }
    int dfs(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        int lh=1+dfs(root->left);
        int rh=1+dfs(root->right);
        if(lh+rh>max_length)
            max_length=lh+rh;
        return lh>rh?lh:rh;
    }
};

���±��˵Ľⷨ
˼·һ�£����������һЩ��
class Solution {
public:
    int maxdiadepth = 0;

    int dfs(TreeNode* root){
        if(root == NULL)
            return 0;
        int leftdepth = dfs(root->left);
        int rightdepth = dfs(root->right);
        if(leftdepth + rightdepth > maxdiadepth)
            maxdiadepth = leftdepth + rightdepth;
        return max(leftdepth +1, rightdepth + 1);
    }

    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return maxdiadepth;
    }
};
