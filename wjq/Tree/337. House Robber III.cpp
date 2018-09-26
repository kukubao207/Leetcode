337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

题意
求不相邻的结点和的最大值

思路1
对于一个任一结点来说，都有偷或者不偷两种选择。
偷，那么两个子节点就不能偷了。偷的价值=根节点的值+ 递归左结点的左右子树 + 递归右结点的左右子树。
不偷，那么两个子节点就可以偷。不偷的价值=递归左右子树。
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
    int rob(TreeNode* root) {
        return robHouse(root);
    }

    int robHouse(TreeNode *root){
        if(root==NULL)
            return 0;
        //偷当前节点
        int r=root->val;
        if(root->left!=NULL)
            r+=robHouse(root->left->left)+robHouse(root->left->right);
        if(root->right!=NULL)
            r+=robHouse(root->right->left)+robHouse(root->right->right);
        //不偷当前节点
        int nr = robHouse(root->left)+robHouse(root->right);
        return r>nr?r:nr;

    }
};

思路2
对于思路1，我们会发现，对于robHouse(root)，需要递归计算的这些量：
robHouse(root->left->left),robHouse(root->left->right),
robHouse(root->right->left),robHouse(root->right->left),
robHouse(root->left),robHouse(root->right).
但在计算robHouse(root->left)时，同样需要：
robHouse(root->left->left),robHouse(root->left->right)
同理对于计算robHouse(root->right)，需要
robHouse(root->right->left),robHouse(root->right->right)
解决方案：
直接把当前节点能偷的最大价值放入在unordered_map中，这样回溯到上一层时，
再想计算该节点的最大价值，需要下面的值就会直接返回这个值，而不需要重复计算。
class Solution {
public:
    unordered_map <TreeNode *,int> m;
    int rob(TreeNode* root) {
        return robHouse(root);
    }
    int robHouse(TreeNode *root){
        if(root==NULL)
            return 0;
        if(m.find(root)!=m.end())
            return m[root];
        //偷当前节点
        int r=root->val;
        if(root->left!=NULL)
            r+=robHouse(root->left->left)+robHouse(root->left->right);
        if(root->right!=NULL)
            r+=robHouse(root->right->left)+robHouse(root->right->right);
        //不偷当前节点
        int nr = robHouse(root->left)+robHouse(root->right);
        //求出最大值
        int maxValue = max(r,nr);
        m[root]=maxValue;
        return maxValue;
    }
};

思路3
贪心方案，对于每一个结点，我们都有偷或不偷两种选择，把这两种选择的值都记录下来放在数组里
数组中第一个元素表示不偷的最大价值，第二个元素表示偷的最大价值。
那么在对当前的结点做决策的时候，我们就能够根据左右子树记录的值来进行决策。
class Solution {
public:
    int rob(TreeNode* root) {
        vector<int> res=robHouse(root);
        return max(res[0],res[1]);
    }
    vector<int> robHouse(TreeNode *root){
        if(root==NULL)
        {
            vector<int> a(2,0);
            return a;
        }

        vector<int> robLeft = robHouse(root->left);
        vector<int> robRight = robHouse(root->right);
        vector<int> res(2,0);
        //当前节点不偷，那子树可以选择偷或不偷，取其最大。
        res[0] = max(robLeft[0],robLeft[1])+max(robRight[0],robRight[1]);
        //当前节点偷，那子树必须选择不偷
        res[1] = root->val + robLeft[0] + robRight[0];
        return res;
    }
};




