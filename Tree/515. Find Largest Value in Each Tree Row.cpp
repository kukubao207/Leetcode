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

�ҵ�˼·
BFS��ÿһ����һ�����ֵ������������
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

���˵�˼·
DFS
ÿ������һ����㣬�жϵ�ǰ����Ƿ���ڽ�������ȣ�����ǵĻ���˵��Ҫ��չ������ˡ�
������ǵĻ���ֻҪ�Աȵ�ǰ�ڵ�ֵ�ͽ�����ж�Ӧ������ֵ�Ĵ�С���ɡ�

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
