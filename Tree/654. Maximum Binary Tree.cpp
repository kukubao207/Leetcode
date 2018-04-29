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

�ҵ�˼·
����ǳ��򵥣�������ݹ鼴�ɣ��ҵĽⷨ����һ����㶼��Ҫ��һ��forѭ����ʱ�临�Ӷ�O(n^2)��
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

���˵�˼·
�ҵ�˼·Ч�ʽϵͣ���һ�´���O(N)�Ľⷨ
�ؼ�˼·��ά��һ���ݼ�ջ��

ͨ��һ��forѭ���������鹹���һ������
���ڵ�ǰ����Ԫ��
�����ջ��Ԫ��С����ôջ��Ԫ�ص��Һ��Ӿ��Ǹýڵ㡣
�����ջ��Ԫ�ش���ô���ϵذ�ջ��Ԫ��pop���������һ����pop������Ԫ�ؾ��ǵ�ǰԪ�ص����ӡ�

�ٸ�����3,2,1,6,0,5��
����3��ֱ����ջ��
����2��ջ��Ԫ��Ϊ3����2������3���Һ�����2��ͬʱ2��ջ��
����1��ջ��Ԫ��Ϊ2����1������2���Һ�����1��ͬʱ1��ջ��
����6��ջ��Ԫ��Ϊ1����6С������1Ϊ6�����ӣ�ͬʱ1��ջ��
�����жϣ�ջ��Ԫ��Ϊ2����6С������2Ϊ6�����ӣ�ͬʱ2��ջ��
�����жϣ�ջ��Ԫ��Ϊ3����6С������3Ϊ6�����ӣ�ͬʱ3��ջ��
��ʱջΪ�գ������жϣ�6��ջ��
����0��ջ��Ԫ��Ϊ6����0������6���Һ�����0��ͬʱ0��ջ��
����5��ջ��Ԫ��Ϊ0����5С������0Ϊ5���Һ��ӣ�ͬʱ0��ջ��
�����жϣ�ջ��Ԫ��Ϊ6����5������5Ϊ6���Һ��ӣ�ͬʱ5��ջ��
��ʱѭ��������ջ��Ԫ��Ϊ��6,5��
��ʱ����6�����˵�����ṹ���������ʹ������
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
