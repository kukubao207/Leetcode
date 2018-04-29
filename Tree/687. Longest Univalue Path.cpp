687. Longest Univalue Path

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

�ҵ�˼·
��ѡ���˺��������Ҳ���ǰ��ж��������ڵݹ����������������档

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
    int longestPath=0;
    int longestUnivaluePath(TreeNode* root) {
        if(root==NULL)
            return 0;
        find(root);
        return longestPath;
    }
    int find(TreeNode *root){
        if(root==NULL)
            return 0;
        int lh=find(root->left);
        int rh=find(root->right);
        if(root->left!=NULL&&root->val==root->left->val)
            lh++;
        else
            lh=0;
        if(root->right!=NULL&&root->val==root->right->val)
            rh++;
        else
            rh=0;
        if(lh+rh>longestPath)
            longestPath=lh+rh;
        return lh>rh?lh:rh;
    }
};

���˵�˼·
���ǰ��ӽ���ֵ���ڵݹ�Ĳ�������������ڵ�ʱͨ���жϸ��ڵ�������ӽ���ֵ�Ƿ���ͬ������
���ص���0���Ƿ���max(left,right)+1.
int len = 0; // global variable
public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    len = 0;
    getLen(root, root.val);
    return len;
}

private int getLen(TreeNode node, int val) {
    if (node == null)
        return 0;
    int left = getLen(node.left, node.val);
    int right = getLen(node.right, node.val);
    len = Math.max(len, left + right);
    return val == node.val? Math.max(left, right)+1 : 0;
}
