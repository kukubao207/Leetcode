package Tree.medium;
//236. Lowest Common Ancestor of a Binary Tree
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//Example 1:
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
//Example 2:
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//
//
//Note:
//
//All of the nodes' values will be unique.
//p and q are different and both values will exist in the binary tree.
public class LowestCommonAncestorOfABinaryTree {//所有的递归的返回值有4种可能性，null、p、q、公共祖先
    //注意p,q必然存在树内, 且所有节点的值唯一!!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = lowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
