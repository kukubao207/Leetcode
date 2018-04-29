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

我的思路
题意要判断树中从根节点到叶节点的路径中是否存在和为特定值的路径。
要想使得某条路径结点和为sum，也可以理解为，对于这条路径上的每个节点，用sum一个个减去之后，最终sum为0。
由此得到递归思路,先根遍历，每到一个结点，先从sum中减去这个结点的值，再判断这个结点是否为叶节点，若为
叶节点，判断此时sum是否为零即可。
然后递归左右子树。

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

别人的思路和我的一样
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
