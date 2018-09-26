108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

�ҵ�˼·

�ݹ�������
���������ǵ����ģ��ɰ�����ֳ����룬
ȡ��ǰ�����м�ֵ��Ϊ��ǰ�ĸ��ڵ㣬
���������벿�ֵݹ鹹����������
������Ұ벿�ֵݹ鹹����������
ϸ�ڲ���Ҫע��ݹ鴫��Ĳ���ֵ��
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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return createHBST(nums,0,nums.size());
    }
    TreeNode* createHBST(vector<int> &nums,int left,int right)
    {
        if(left>=right)
            return NULL;
        int mid=(left+right)/2;
        TreeNode *root=new TreeNode(nums[mid]);
        root->left=createHBST(nums,left,mid);
        root->right=createHBST(nums,mid+1,right);
        return root;
    }
};

���˵�������ע��ϸ��
public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}
