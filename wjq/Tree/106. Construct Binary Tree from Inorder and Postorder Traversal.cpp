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

�ҵ�˼·
���������и��������кͺ���������й���һ�������ݹ鼴�ɡ�
�ݹ�Ĳ����Ǹ����ҵ�sameԪ��֮��inorder������к��ұ����еĳ�����ȷ���ġ�
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

�Ż�
ÿ�ε�һ����㣬��Ҫ����һ�����Ԫ�أ�����Ч�ʵͣ����ֱ�Ӱ�inorder�����е�Ԫ�غͶ�Ӧ�±걣����
HashMap�У����ܽ�ʡʱ��
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
