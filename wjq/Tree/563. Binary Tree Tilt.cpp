563. Binary Tree Tilt

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

我的思路
思路非常简单，完全按照题意来的。
1.当前节点的filt=abs(左子树的所有节点的值的和-右子树的所有节点的值的和)。
2.递归求出左子树的filt
3.递归求出右子树的filt
4.三者相加即为答案
但我的解法效率太低，每次都要计算左右子树的和，有很多重复计算的部分
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
    int findTilt(TreeNode* root) {
        if(root==NULL)
            return 0;
        return abs(sum(root->left)-sum(root->right))+findTilt(root->left)+findTilt(root->right);
    }
    int sum(TreeNode* root){
        if(root==NULL)
            return 0;
        return root->val+sum(root->left)+sum(root->right);
    }

};
别人的代码
思路是用PostOrder来进行计算，因为postOrder每次先访问左右子节点，最后才访问根，这与这道题的解法不谋而合，
先计算左右子节点的差的绝对值，加入到结果中，再把左节点的和、右节点的和返回给上一层。
能够做到，在计算左子树、右子树的和的同时计算左子树、右子树的filt。
class Solution {
public:
    int findTilt(TreeNode* root) {
        if(root == NULL) return 0;

        int res = 0;

        postorder(root, res);

        return res;
    }
private:
    int postorder(TreeNode* root, int& res){
        if(root == NULL) return 0;

        int leftsum= postorder(root->left,res);

        int rightsum = postorder(root->right,res);

        res += abs(leftsum - rightsum);

        return leftsum + rightsum + root->val;

    }
};
