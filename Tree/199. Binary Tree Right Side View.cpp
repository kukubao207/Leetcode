199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

题意
从右边看一棵树，求出看到的每一层的第一个节点集合。

我的思路 BFS
每一层遍历的最后一个元素，就是从右边看到的第一个元素。
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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        if(root==NULL)
            return res;
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty())
        {
            int sz=q.size(),temp=0;
            for(int i=0;i<sz;i++)
            {
                root=q.front();
                q.pop();
                temp=root->val;
                if(root->left!=NULL)
                    q.push(root->left);
                if(root->right!=NULL)
                    q.push(root->right);
            }
            res.push_back(temp);
        }
        return res;
    }
};

别人的思路 DFS

1. 树的每一层只需要挑一个元素（每次都先递归右子树）。
2. 当前递归深度和结果集的长度相同时，直接把该元素加入到结果集中。
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
