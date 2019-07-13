package Tree.medium;
//701. Insert into a Binary Search Tree
//Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
//
//Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
//
//For example,
//
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//And the value to insert: 5
//You can return this binary search tree:
//
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
//This tree is also valid:
//
//         5
//       /   \
//      2     7
//     / \
//    1   3
//         \
//          4
public class InsertintoaBinarySearchTree {
    //1.递归
    //时间复杂度O(nlogn)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(val < root.val)
            root.left = insertIntoBST(root.left, val);
        if(val > root.val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    //2.迭代
    //时间复杂度O(n)
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        TreeNode p = root;
        while(p != null){
            if(val < p.val){
                if(p.left == null){
                    p.left = new TreeNode(val);
                    break;
                }
                p = p.left;
            }
            if(val > p.val){
                if(p.right == null){
                    p.right = new TreeNode(val);
                    break;
                }
                p = p.right;
            }
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
