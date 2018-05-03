652. Find Duplicate Subtrees

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

����
����ظ�����

˼·
��������������ÿ��һ���ڵ㣬�õ��Ըýڵ�Ϊ������������������string�ַ�����
�������ַ�������unordered_map�У�ÿ�������ظ����ַ��������ֵ+1��=2ʱ˵���ظ����Ѹýڵ���������С�

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
    unordered_map<string,int> m;
    vector<TreeNode *> result;
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        post(root);
        return result;
    }
    string post(TreeNode *root)
    {
        if(root==NULL)
            return "#";
        string left = post(root->left);
        string right = post(root->right);
        string str = to_string(root->val)+","+left+","+right;
        if(m.find(str)==m.end())
            m[str]=1;
        else
            m[str]++;
        if(m[str]==2)
            result.push_back(root);
        return str;
    }
};
