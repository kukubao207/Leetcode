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

我的思路
题意要求对树进行广度优先搜索的变形：蜿蜒的广度优先搜索，就是隔一层变换左右的搜索方位。
用一个bool变量来记录这一次应该从哪个方向开始，每层的搜索用一个数组来保存这一次的搜索结果。
一开始我没有做出来，忘记了BFS的写法，一个while嵌套一个for循环，每个for循环搜索一层，这一层一共有q.size()个元素，
这是非常关键的，因为上一层搜索完毕之后，上一层的所有元素都被pop出来了，上一层所有元素的子节点都push进了队列，那么
这时候队列里的元素个数就是要搜索的这一层总共的元素。
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
