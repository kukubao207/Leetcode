222. Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

����
����һ��complete binary tree�Ľ�����
This is a clean and smart solution, my understanding is as follows:

˼·
A fully completed tree has node number: count = 2 ^ depth - 1
for example: [1,2,3]
depth is 2
count = 2 ^ 2 - 1 = 3
�Ƚϵ�ǰ���ڵ�����һ�к�����һ�еĸ߶�
�����ͬ��˵������������������ù�ʽ���������,
���򷵻� �ݹ������� �������Ľ�����+�������Ľ�����+1
The search pattern is very similar to binary search,
the difference of heights ethier exsits in left side, or right side
Due to the reason stated in point 3,
the time complexity is h ^ 2,
there is h times for each level,
and h times for calculating height at each level

����
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
    int countNodes(TreeNode* root) {
        if(root==NULL)
            return 0;

        int leftDep=leftDepth(root->left);
        int rightDep=rightDepth(root->right);

        if(leftDep==rightDep)
            return (1<<(leftDep+1))-1;
        else
            return 1+countNodes(root->left)+countNodes(root->right);
    }
    int leftDepth(TreeNode* root)
    {
        int dep=0;
        while(root)
        {
            dep++;
            root=root->left;
        }
        return dep;
    }
    int rightDepth(TreeNode *root)
    {
        int dep=0;
        while(root)
        {
            dep++;
            root=root->right;
        }
        return dep;
    }
};
