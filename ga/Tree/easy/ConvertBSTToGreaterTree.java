package Tree.easy;
//538. Convert BST to Greater Tree
//Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
//Example:
//
//Input: The root of a Binary Search Tree like this:
//              5
//            /   \
//           2     13
//
//Output: The root of a Greater Tree like this:
//             18
//            /   \
//          20     13
public class ConvertBSTToGreaterTree {
    //BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
       if(root == null)
           return null;
        convertBST(root.right);
        root.val = root.val + num;
        num = root.val;
        convertBST(root.left);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
