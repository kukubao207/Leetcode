package Tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//662. Maximum Width of Binary Tree
//Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
//
//The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
//
//Example 1:
//
//Input:
//
//           1
//         /   \
//        3     2
//       / \     \
//      5   3     9
//
//Output: 4
//Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
//Example 2:
//
//Input:
//
//          1
//         /
//        3
//       / \
//      5   3
//
//Output: 2
//Explanation: The maximum width existing in the third level with the length 2 (5,3).
//Example 3:
//
//Input:
//
//          1
//         / \
//        3   2
//       /
//      5
//
//Output: 2
//Explanation: The maximum width existing in the second level with the length 2 (3,2).
//Example 4:
//
//Input:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//Output: 8
//Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
//
//
//Note: Answer will in the range of 32-bit signed integer.
public class MaximumWidthOfBinaryTree {
    //1.DFS
    /**
     假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
     用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
     节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
     加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
     **/
    //时间复杂度O(n)
    //空间复杂度O(n)
    int maxWidth = 0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        dfs(root, 1, 1, left);
        return maxWidth;
    }
    public void dfs(TreeNode root, int level, int index, List<Integer> left){
        if(root == null)
            return;
        if(level > left.size())
            left.add(index);
        maxWidth = Math.max(maxWidth, index - left.get(level - 1) + 1);
        dfs(root.left, level + 1, index * 2, left);
        dfs(root.right, level + 1, index * 2 + 1, left);
    }
    //2.两次BFS
    //时间复杂度O(n)
    //空间复杂度O(n)——最宽的一行节点数
    public int widthOfBinaryTree1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 记录节点编号，节点编号为n  左子节点为 2*n  右子节点为 2*n+1
        Queue<Integer> queuePos = new LinkedList<Integer>();  //记录节点的编号
        queue.add(root);
        queuePos.add(1);
        int res = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            int start = Integer.MAX_VALUE; int end = 0;//每一层的start和end都要重新计算
            while(count > 0){
                TreeNode node = queue.poll();
                int pos = queuePos.poll();
                if(node.left != null){
                    queue.add(node.left);
                    queuePos.add(2 * pos);
                    start = start < 2 * pos ? start : 2 * pos;
                    end = end > 2 * pos ? end: 2 * pos;
                }if(node.right != null){
                    queue.add(node.right);
                    queuePos.add(2 * pos + 1);
                    start = start < 2 * pos + 1 ? start : 2 * pos + 1;
                    end = end > 2 * pos + 1 ? end : 2 * pos + 1;
                }
                count--;
            }
            res = end != 0 && start != Integer.MAX_VALUE && res < end - start + 1 ? end - start + 1 : res;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
