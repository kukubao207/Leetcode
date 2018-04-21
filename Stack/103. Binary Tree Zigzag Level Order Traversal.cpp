103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

�ҵ�˼·
����Ҫ��������й�����������ı��Σ����ѵĹ���������������Ǹ�һ��任���ҵ�������λ��
��һ��bool��������¼��һ��Ӧ�ô��ĸ�����ʼ��ÿ���������һ��������������һ�ε����������
һ��ʼ��û����������������BFS��д����һ��whileǶ��һ��forѭ����ÿ��forѭ������һ�㣬��һ��һ����q.size()��Ԫ�أ�
���Ƿǳ��ؼ��ģ���Ϊ��һ���������֮����һ�������Ԫ�ض���pop�����ˣ���һ������Ԫ�ص��ӽڵ㶼push���˶��У���ô
��ʱ��������Ԫ�ظ�������Ҫ��������һ���ܹ���Ԫ�ء�
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode *> q;
        vector<vector<int>> v;
        if(root==NULL)
            return v;
        bool flag=true;
        q.push(root);
        while(!q.empty())
        {
            int sz=q.size();
            vector<int> temp(sz);
            for(int i=0;i<sz&&!q.empty();i++)
            {
                root=q.front();
                q.pop();
                if(flag)
                    temp[i]=root->val;
                else
                    temp[sz-1-i]=root->val;
                if(root->left!=NULL)
                    q.push(root->left);
                if(root->right!=NULL)
                    q.push(root->right);
            }
            flag=!flag;
            v.push_back(temp);
        }
        return v;
    }
};
