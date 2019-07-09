package Tree.medium;
//654. Maximum Binary Tree
//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
//
//Example 1:
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//Note:
//The size of the given array will be in the range [1,1000].
public class MaximumBinaryTree {
    //时间复杂度O(n*n)
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end)
            return null;
        int maxIndex = getMax(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = helper(nums, start, maxIndex - 1);
        node.right = helper(nums, maxIndex + 1, end);
        return node;
    }
    public int getMax(int[] nums, int start, int end){
        int max = nums[start];
        int maxIndex = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
