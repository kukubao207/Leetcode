package Tree.easy;

import java.util.ArrayList;
import java.util.List;

//897. Increasing Order Search Tree
//Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
//
//Example 1:
//Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//       5
//      / \
//    3    6
//   / \    \
//  2   4    8
// /        / \
//1        7   9
//
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
//            \
//             7
//              \
//               8
//                \
//                 9
//Note:
//
//The number of nodes in the given tree will be between 1 and 100.
//Each node will have a unique integer value from 0 to 1000.
public class IncreasingOrderSearchTree {
    //1.先中序遍历保存结果  再重新构造树
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        TreeNode node = new TreeNode(res.get(0));
        TreeNode tmp = node;
        for(int i = 1; i < res.size(); i++){
            node.left = null;
            node.right = new TreeNode(res.get(i));
            node = node.right;
        }
        return tmp;
    }
    //中序遍历
    public void helper(TreeNode root, List res){
        if(root == null)
            return ;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    //2.使用两个变量 pre记录前一个便利的TreeNode
    TreeNode pre = null;
    TreeNode first = null;
    public TreeNode increasingBST1(TreeNode root) {
        if (root != null) {
            inOrder(root);
        }
        return first;
    }
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (pre == null) {//第一次到达最左边的节点即为新树的根节点
                pre = root;
                first = root;
                pre.left = null;
            } else {
                pre.right = root;
                pre = root;
                pre.left = null;
            }
            inOrder(root.right);
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
