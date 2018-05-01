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

����
���ұ߿�һ���������������ÿһ��ĵ�һ���ڵ㼯�ϡ�

�ҵ�˼· BFS
ÿһ����������һ��Ԫ�أ����Ǵ��ұ߿����ĵ�һ��Ԫ�ء�
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

���˵�˼· DFS

1. ����ÿһ��ֻ��Ҫ��һ��Ԫ�أ�ÿ�ζ��ȵݹ�����������
2. ��ǰ�ݹ���Ⱥͽ�����ĳ�����ͬʱ��ֱ�ӰѸ�Ԫ�ؼ��뵽������С�
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
