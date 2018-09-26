111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

我的思路
由于题意涉及叶子节点的判断，因此用先根遍历，在递归左右子树之前判断是否为根。
这样搜索整棵树，每次遇到叶子节点都要判断当前路径长度count是否比最小路径（根到叶子节点节点数量最少的路径）
还要小，小的话更新最小路径。
递归左右子树的时候，路径长度增加。
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
    int minD=INT_MAX;
    int minDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        findMinDepth(root,1);
        return minD;
    }
    void findMinDepth(TreeNode *root,int count){
        if(root==NULL)
            return;
        if(root->left==NULL&&root->right==NULL&&minD>count)
            minD=count;
        findMinDepth(root->left,count+1);
        findMinDepth(root->right,count+1);
    }
};

别人的思路
他归纳了求树的最大深度和最小深度的解法

104：

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}
111：要注意陷阱

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        //因为题目要求是求根节点到叶子节点的最短高度，那么情况与求最高深度是略有不同的
        //如果不进行下面的判断，那么求出来的深度并不是到叶子节点的
        if(root.left == null)
            return minDepth(root.right) + 1;

        if(root.right == null)
            return minDepth(root.left) + 1;

        //下面与求最大深度是一样的，只是换成Math.min即可
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return Math.min(leftMinDepth,rightMinDepth)+1;
    }
}
