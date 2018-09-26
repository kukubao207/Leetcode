606. Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

我的思路
递归做法
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
    string tree2str(TreeNode* t) {
        string res="";
        if(t==NULL)
            return res;
        PreOrder(t,res);
        return res.substr(1,res.length()-2);
    }
    void PreOrder(TreeNode *t,string &res)
    {
        if(t==NULL)
            return ;
        res=res+"("+to_string(t->val);
        if(t->left==NULL&&t->right!=NULL)
            res=res+"()";
        PreOrder(t->left,res);
        PreOrder(t->right,res);
        res=res+")";
    }

};

别人的思路
string tree2str(TreeNode* t) {
    if (t == NULL)
        return "";
    string s = to_string(t->val);
    if (t->left)
        s += '(' + tree2str(t->left) + ')';
    else if (t->right)
        s += "()";
    if (t->right)
        s += '(' + tree2str(t->right) + ')';
    return s;
}
