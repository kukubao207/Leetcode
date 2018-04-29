814. Binary Tree Pruning

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.


Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]



Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]



Note:

The binary tree will have at most 100 nodes.
The value of each node will only be 0 or 1.

�ҵ�˼·

���⣬һ������ֻ��0����1��㣬Ҫ��ɾ��һЩ0��㣬��Щ��ɾ����0���������в�����1��㡣

˼�������������ģ�����Ȼ����һ��Ҫ��ı����Ľṹ���⣬��ô�ݹ麯���ķ���ֵ�϶���TreeNode *��
�����������ĵݹ�ȥ�������ɾ����һ��ʼ�������Ǻ���������Ȱ����������з���Ҫ���0���ɾ�꣬
��ȥ�жϱ�����Ƿ�������������Ҳ����NULL.

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
    TreeNode* pruneTree(TreeNode* root) {
        if(root==NULL)
            return NULL;
        if(root->left==NULL&&root->right==NULL&&root->val==0)
            return NULL;
        root->left=pruneTree(root->left);
        root->right=pruneTree(root->right);
        if(root->left==NULL&&root->right==NULL&&root->val==0)
            return NULL;
        return root;
    }
};

���˵�˼·
���������Ƶģ��������������С�
TreeNode* pruneTree(TreeNode* root) {
    if (!root)
        return NULL;
    root->left = pruneTree(root->left);
    root->right = pruneTree(root->right);
    if (!root->left && !root->right && root->val == 0)
        return NULL;
    return root;
}

