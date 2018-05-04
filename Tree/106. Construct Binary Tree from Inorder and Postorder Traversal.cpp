106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

我的思路
题意是用中根遍历序列和后根遍历序列构建一棵树，递归即可。
递归的参数是根据找到same元素之后inorder左边序列和右边序列的长度来确定的。
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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return build(inorder,postorder,0,inorder.size()-1,0,postorder.size()-1);
    }
    TreeNode* build(vector<int>& inorder, vector<int>& postorder,int is,int ie,int ps,int pe) {
        if(is>ie||ps>pe)
            return NULL;
        int same=0;
        for(int i=is;i<=ie;i++)
            if(inorder[i]==postorder[pe])
            {
                same=i;
                break;
            }
        TreeNode *root=new TreeNode(postorder[pe]);
        root->left=build(inorder,postorder,is,same-1,ps,pe-(ie-same)-1);
        root->right=build(inorder,postorder,same+1,ie,pe-(ie-same),pe-1);
        return root;

    }
};

优化
每次到一个结点，都要搜索一次相等元素，这样效率低，如果直接把inorder序列中的元素和对应下标保存在
HashMap中，就能节省时间
class Solution {
public:
    unordered_map<int,int> m;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for(int i=0;i<inorder.size();i++)
            m[inorder[i]]=i;
        return build(inorder,postorder,0,inorder.size()-1,0,postorder.size()-1);
    }
    TreeNode* build(vector<int>& inorder, vector<int>& postorder,int is,int ie,int ps,int pe) {
        if(is>ie||ps>pe)
            return NULL;
        int same=m[postorder[pe]];
        TreeNode *root=new TreeNode(postorder[pe]);
        root->left=build(inorder,postorder,is,same-1,ps,pe-(ie-same)-1);
        root->right=build(inorder,postorder,same+1,ie,pe-(ie-same),pe-1);
        return root;

    }
};
