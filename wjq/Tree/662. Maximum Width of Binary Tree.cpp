662. Maximum Width of Binary Tree

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

我的思路
这题要对树进行编号,设当前节点编号为i，一个左子结点的编号为2*i，一个右子结点编号为2*i+1
然后就是BFS，对每一层求出当前这一层的终止结点的编号减去起始结点的编号即为当前层的宽度。

class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        int max_width=0;
        if(root==NULL)
            return max_width;

        queue<TreeNode *> q;
        queue<int> id;

        q.push(root);
        id.push(1);
        while(!q.empty())
        {
            int sz = q.size();
            int start=id.front(),end=0;
            for(int i=0;i<sz;i++)
            {
                root= q.front();
                q.pop();
                end = id.front();
                id.pop();
                if(root->left!=NULL)
                {
                    id.push(2*end);
                    q.push(root->left);
                }
                if(root->right!=NULL)
                {
                    id.push(2*end+1);
                    q.push(root->right);
                }
            }
            if(end-start+1>max_width)
                max_width=end-start+1;
        }
        return max_width;
    }
};

