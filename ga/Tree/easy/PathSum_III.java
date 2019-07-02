package Tree.easy;
//437. Path Sum III
//You are given a binary tree in which each node contains an integer value.
//
//Find the number of paths that sum to a given value.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
//
//The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
//
//Example:
//
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//Return 3. The paths that sum to 8 are:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11
public class PathSum_III {
    //双重递归
    //首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。
    public int pathSum(TreeNode root, int sum) {//先序遍历
       if(root == null)
           return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
    int count = 0;
    public void dfs(TreeNode root, int sum){
        if(root == null)
            return;
        sum = sum - root.val;
        if(sum == 0)
            count++;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
