105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

我的思路
通过先根遍历和中根遍历递归构造二叉树，这题的难点就在于递归参数的推导和边界条件的思考。
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return build(preorder,inorder,0,inorder.size()-1,0,preorder.size()-1);
    }
    TreeNode* build(vector<int>& preorder, vector<int>& inorder,int is,int ie,int ps,int pe)
    {
        if(ps>pe||is>ie)
            return NULL;
        TreeNode *root=new TreeNode(preorder[ps]);
        int same=-1;
        for(int i=is;i<=ie;i++)
            if(inorder[i]==preorder[ps])
            {
                same=i;
                break;
            }
        root->left=build(preorder,inorder,is,same-1,ps+1,ps+same-is);
        root->right=build(preorder,inorder,same+1,ie,ps+same-is+1,pe);
        return root;
    }
};
