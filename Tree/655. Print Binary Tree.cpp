655. Print Binary Tree

Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   /
  3
 /
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].


思路

1.计算该树的高度
2.通过高度计算树的宽度，width=1<<height-1
3.构造一个全为空的结果集
4.先根遍历该树，将结点的值填入结果集
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
    vector<vector<string>> printTree(TreeNode* root) {
        int height = findHeight(root);
        int width = (1<<height)-1;
        vector<vector<string>> res;
        for(int i=0;i<height;i++)
        {
            vector<string> temp;
            for(int j=0;j<width;j++)
                temp.push_back("");
            res.push_back(temp);
        }

        fillTable(root,0,0,width,res);
        return res;
    }
    int findHeight(TreeNode *root){
        if(root==NULL)
            return 0;
        return 1+max(findHeight(root->left),findHeight(root->right));
    }
    void fillTable(TreeNode *root,int depth,int start,int end,vector<vector<string>> &res)
    {
        if(root==NULL)
            return;
        int mid=(start+end)/2;
        res[depth][mid]=to_string(root->val);
        if(root->left!=NULL)
            fillTable(root->left,depth+1,start,mid,res);
        if(root->right!=NULL)
            fillTable(root->right,depth+1,mid+1,end,res);
    }
};
