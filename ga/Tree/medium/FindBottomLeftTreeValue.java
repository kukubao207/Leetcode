package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//513. Find Bottom Left Tree Value
//Given a binary tree, find the leftmost value in the last row of the tree.
//
//Example 1:
//Input:
//
//    2
//   / \
//  1   3
//
//Output:
//1
//Example 2:
//Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//Output:
//7
//Note: You may assume the tree (i.e., the given root node) is not NULL.
public class FindBottomLeftTreeValue {
    //1.层次遍历
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            int tmp = count;
            while(count > 0){
                TreeNode node = queue.poll();
                if(count == tmp)
                    res = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
        }
        return res;
    }

    //2.深度搜索
    public int findBottomLeftValue1(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    int max = Integer.MIN_VALUE;
    int res;
    public void dfs(TreeNode root, int depth){
        if(root != null){
            if(root.left == null && root.right == null){//last row
                if(max < depth){//第一次遍历时记录,且是最深层
                    max = depth;
                    res = root.val;
                }
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
