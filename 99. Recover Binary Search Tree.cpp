99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

����
������ǰ�����BST��ֵ��λ�ã�ʹ���Ϊһ��BST��

�ҵ�˼· �ռ临�Ӷ�O(n) ʱ�临�Ӷ�O(n)
�����и������ѵ�ǰ������ϵ�ֵ��¼������a�У�
sort��a��������
�����и������������е�ֵ�����������ÿ���ڵ��ϡ�

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
    int a[10005];
    void recoverTree(TreeNode* root) {
        int index=0,j=0;
        inOrder(root,index);
        sort(a,a+index);
        inOrder2(root,j);
    }
    void inOrder(TreeNode *root,int &index)
    {
        if(root==NULL)
            return;
        inOrder(root->left,index);
        a[index++]=root->val;
        inOrder(root->right,index);
    }
    void inOrder2(TreeNode *root,int &j)
    {
        if(root==NULL)
            return;
        inOrder2(root->left,j);
        root->val=a[j++];
        inOrder2(root->right,j);
    }
};

���˵�˼·

