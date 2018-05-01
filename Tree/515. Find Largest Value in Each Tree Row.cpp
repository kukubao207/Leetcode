515. Find Largest Value in Each Tree Row

You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]

我的思路
BFS，每一层找一个最大值，加入结果集中
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
    vector<int> largestValues(TreeNode* root) {
        vector<int> result;
        if(root==NULL)
            return result;
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty())
        {
            int sz=q.size();
            int max_num=q.front()->val;
            for(int i=0;i<sz;i++)
            {
                TreeNode *cur = q.front();
                q.pop();
                if(cur->val>max_num)
                    max_num=cur->val;
                if(cur->left!=NULL)
                    q.push(cur->left);
                if(cur->right!=NULL)
                    q.push(cur->right);
            }
            result.push_back(max_num);
        }
        return result;
    }
};

别人的思路
DFS
每次遇到一个结点，判断当前深度是否等于结果集长度，如果是的话，说明要扩展结果集了。
如果不是的话，只要对比当前节点值和结果集中对应层的最大值的大小即可。

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
