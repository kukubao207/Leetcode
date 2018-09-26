671. Second Minimum Node In a Binary Tree

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

�ҵ�˼·

����ͨ��˼·����������������Ԫ�ؼ���set������setĬ������ֱ�ӷ���set�ĵڶ���Ԫ�ء�

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
    set<int> se;
    int findSecondMinimumValue(TreeNode* root) {
        search(root);
        if(se.size()<=1)
            return -1;
        return *(++se.begin());
    }
    void search(TreeNode* root){
        if(root==NULL)
            return;
        se.insert(root->val);
        search(root->left);
        search(root->right);
    }
};

���˵�˼·
�ҵ�˼·��Ȼ�����Ż�������������������ȷ������Ӧ���ǡ�
ֻҪ��ǰ�ڵ��ֵ����ڵ��ֵ��ͬ����˵����û���ҵ��ڶ�С�Ľ�㣬�����Ըýڵ�������������������
�����ǰ�ڵ��ֵ����ڵ��ֵ��ͬ��˵���ҵ��˵ڶ�С�Ľ�㣬ֱ�ӷ��ظýڵ��ֵ��

class Solution {
public:
    int findSecondMinimumValue(TreeNode* root) {
        if (!root)
            return -1;
        return minval(root, root->val);
    }
private:
    int minval(TreeNode* p, int first) {
        if (p == NULL)
            return -1;
        if (p->val != first)
            return p->val;
        int left = minval(p->left, first)��
        int right = minval(p->right, first);
        // if all nodes of a subtree = root->val,
        // there is no second minimum value, return -1
        if (left == -1)
            return right;
        if (right == -1)
            return left;
        return min(left, right);
    }
};
