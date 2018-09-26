437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

题意
求树中有多少条路径的节点和能达到sum。

思路1 时间复杂度最坏O(n^2) 最好O(logn)
从简单的问题开始想起，穿过根节点的路径和为sum的路径有多少条？
可以简单的写出递归算法如下。
int travel(TreeNode *root,int sum)
{
    if(root==NULL)
        return 0;
    int leftPathNum=travel(root->left,sum-root->val);
    int rightPathNum=travel(root->right,sum-root->val);
    return (root->val==sum?1:0)+leftPathNum+rightPathNum;
}

其实该问题就转化成了，对于树上的每个节点，求解上述函数的返回值，然后相加最后返回即可。
这样又可以写出递归函数如下
int pathSum(TreeNode* root, int sum) {
    if(root==NULL)
        return 0;
    return travel(root,sum)+pathSum(root->left,sum)+pathSum(root->right,sum);
}

最后 整合一下
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
    int pathSum(TreeNode* root, int sum) {
        if(root==NULL)
            return 0;
        return travel(root,sum)+pathSum(root->left,sum)+pathSum(root->right,sum);
    }
    int travel(TreeNode *root,int sum)
    {
        if(root==NULL)
            return 0;
        int leftPathNum=travel(root->left,sum-root->val);
        int rightPathNum=travel(root->right,sum-root->val);
        return (root->val==sum?1:0)+leftPathNum+rightPathNum;
    }
};

思路2 时间复杂度O(n)
前缀和算法
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
    unordered_map<int,int> prefixSum;
    int pathSum(TreeNode* root, int sum) {
        prefixSum[0]=1;
        return travel(root,0,sum);
    }
    int travel(TreeNode *root,int curSum,int target)
    {
        if(root==NULL)
            return 0;
        curSum+=root->val;
        int res=0;
        if(prefixSum.find(curSum-target)!=prefixSum.end())
            res=prefixSum[curSum-target];
        prefixSum[curSum]=(prefixSum.find(curSum)==prefixSum.end())?1:prefixSum[curSum]+1;
        res+=travel(root->left,curSum,target)+travel(root->right,curSum,target);
        prefixSum[curSum]=prefixSum[curSum]-1;
        return res;
    }
};
