112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

�ҵ�˼·
����Ҫ�ж����дӸ��ڵ㵽Ҷ�ڵ��·�����Ƿ���ں�Ϊ�ض�ֵ��·����
Ҫ��ʹ��ĳ��·������Ϊsum��Ҳ�������Ϊ����������·���ϵ�ÿ���ڵ㣬��sumһ������ȥ֮������sumΪ0��
�ɴ˵õ��ݹ�˼·,�ȸ�������ÿ��һ����㣬�ȴ�sum�м�ȥ�������ֵ�����ж��������Ƿ�ΪҶ�ڵ㣬��Ϊ
Ҷ�ڵ㣬�жϴ�ʱsum�Ƿ�Ϊ�㼴�ɡ�
Ȼ��ݹ�����������

class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if(root==NULL)
            return false;
        sum-=root->val;
        if(root->left==NULL&&root->right==NULL)
            return sum==0;
        bool l=hasPathSum(root->left,sum);
        bool r=hasPathSum(root->right,sum);
        return l||r;
    }
};

���˵�˼·���ҵ�һ��
The basic idea is to subtract the value of current node from sum until it
reaches a leaf node and the subtraction equals 0, then we know that we got
a hit. Otherwise the subtraction at the end could not be 0.

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
