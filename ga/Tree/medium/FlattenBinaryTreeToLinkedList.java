package Tree.medium;
//114.Given a binary tree, flatten it to a linked list in-place.

//For example, given the following tree:

import java.util.Stack;

//    1
//   / \
//  2   5
// / \   \
//3   4   6
//The flattened tree should look like:
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

//      1
//     / \
//    2   9
//   / \   \
//  3   8   10
// / \
//4   5
//   / \
//  6   7
public class FlattenBinaryTreeToLinkedList {
    //1.递归
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right !=null)
            root = root.right;
        root.right = tmp;
    }
    //2.迭代
    public void flatten1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;
                while(node.right != null)
                    node = node.right;
                node.right = tmp;
                root = tmp;
            }
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
