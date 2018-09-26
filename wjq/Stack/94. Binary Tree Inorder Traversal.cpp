94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

�ҵĽⷨ

1.�ݹ�˼·
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

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorder(result,root);
        return result;
    }
    void inorder(vector<int> &result,TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(result,root->left);
        result.push_back(root->val);
        inorder(result,root->right);
    }
};

2.����˼·

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

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        if(root==NULL)
            return result;
        stack<TreeNode*> s;
        s.push(root);
        while(!s.empty())
        {
            root=s.top();
            if(root->left!=NULL)
            {
                s.push(root->left);
                root->left=NULL;        //*****����Ƚ���Ҫ����ֹ�´λ���������
            }
            else
            {
                result.push_back(root->val);
                if(root->right!=NULL)
                    s.push(root->right);
                s.pop();                //������Σ�������ڵ�Ĺ�����
                                        //1.����Ѱ���ӽڵ� 2.����ֵ��¼ ���Ѿ���ɣ�û�����¶��ˡ�
            }
        }
        return result;
    }

};
