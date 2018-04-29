111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

�ҵ�˼·
���������漰Ҷ�ӽڵ���жϣ�������ȸ��������ڵݹ���������֮ǰ�ж��Ƿ�Ϊ����
����������������ÿ������Ҷ�ӽڵ㶼Ҫ�жϵ�ǰ·������count�Ƿ����С·��������Ҷ�ӽڵ�ڵ��������ٵ�·����
��ҪС��С�Ļ�������С·����
�ݹ�����������ʱ��·���������ӡ�
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
    int minD=INT_MAX;
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        findMinDepth(root,1);
        return minD;
    }
    void findMinDepth(TreeNode *root,int count){
        if(root==NULL)
            return;
        if(root->left==NULL&&root->right==NULL&&minD>count)
            minD=count;
        findMinDepth(root->left,count+1);
        findMinDepth(root->right,count+1);
    }
};

���˵�˼·
�������������������Ⱥ���С��ȵĽⷨ

104��

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}
111��Ҫע������

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        //��Ϊ��ĿҪ��������ڵ㵽Ҷ�ӽڵ����̸߶ȣ���ô������������������в�ͬ��
        //���������������жϣ���ô���������Ȳ����ǵ�Ҷ�ӽڵ��
        if(root.left == null)
            return minDepth(root.right) + 1;

        if(root.right == null)
            return minDepth(root.left) + 1;

        //����������������һ���ģ�ֻ�ǻ���Math.min����
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return Math.min(leftMinDepth,rightMinDepth)+1;
    }
}
