654. Maximum Binary Tree

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].

我的思路
这题非常简单，按题意递归即可，我的解法构造一个结点都需要做一个for循环，时间复杂度O(n^2)。
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
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        return construct(nums,0,nums.size());
    }
    TreeNode* construct(vector<int>& nums,int l,int r) {
        if(l>=r)
            return NULL;
        int max_num=INT_MIN,max_index=-1;
        for(int i=l;i<r;i++)
            if(nums[i]>max_num)
            {
                max_num=nums[i];
                max_index=i;
            }
        TreeNode *root=new TreeNode(max_num);
        root->left=construct(nums,l,max_index);
        root->right=construct(nums,max_index+1,r);
        return root;
    }
};

别人的思路
我的思路效率较低，看一下大神O(N)的解法
关键思路：维护一个递减栈。

通过一个for循环遍历数组构造出一棵树。
对于当前数组元素
如果比栈顶元素小，那么栈顶元素的右孩子就是该节点。
如果比栈顶元素大，那么不断地把栈顶元素pop出来，最后一个被pop出来的元素就是当前元素的左孩子。

举个例子3,2,1,6,0,5。
对于3，直接入栈。
对于2，栈顶元素为3，比2大，设置3的右孩子是2，同时2入栈。
对于1，栈顶元素为2，比1大，设置2的右孩子是1，同时1入栈。
对于6，栈顶元素为1，比6小，设置1为6的左孩子，同时1出栈，
继续判断，栈顶元素为2，比6小，设置2为6的左孩子，同时2出栈，
继续判断，栈顶元素为3，比6小，设置3为6的左孩子，同时3出栈，
此时栈为空，结束判断，6入栈。
对于0，栈顶元素为6，比0大，设置6的右孩子是0，同时0入栈。
对于5，栈顶元素为0，比5小，设置0为5的右孩子，同时0出栈，
继续判断，栈顶元素为6，比5大，设置5为6的右孩子，同时5入栈。
此时循环结束，栈内元素为，6,5。
此时对于6结点来说，树结构长这样，和答案相符。
      6
    /   \
   3     5
    \    /
     2  0
       \
        1


class Solution {
public:
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {

        stack<TreeNode *> s;
        for(int i=0;i<nums.size();i++)
        {
            TreeNode *cur=new TreeNode(nums[i]);
            while(!s.empty()&&s.top()->val < cur->val)
            {
                cur->left=s.top();
                s.pop();
            }
            if(!s.empty())
                s.top()->right=cur;
            s.push(cur);
        }
        TreeNode *result=NULL;
        while(!s.empty())
        {
            result=s.top();
            s.pop();
        }
        return result;
    }

};
