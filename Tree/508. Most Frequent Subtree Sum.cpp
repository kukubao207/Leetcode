508. Most Frequent Subtree Sum

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

题意
    给定一棵树，求出出现次数最频繁的子树和。
我的思路
用后根遍历来做，用unordered_map来保存某个子树和出现的次数，用max_count保存出现最多的子树和的次数。
class Solution {
public:
    unordered_map<int,int> m;
    int max_count=0;
    vector<int> result;
    vector<int> findFrequentTreeSum(TreeNode* root) {
        sum(root);
        return result;
    }
    int sum(TreeNode *root)
    {
        if(root==NULL)
            return 0;
        int leftSum=sum(root->left);
        int rightSum=sum(root->right);
        int s=root->val+leftSum+rightSum;
        m[s]++;
        if(m[s]==max_count)
            result.push_back(s);
        else if(m[s]>max_count)
        {
            max_count=m[s];
            result.clear();
            result.push_back(s);
        }
        return s;
    }
};
