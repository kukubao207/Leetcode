235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to
be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes
2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


我的思路
1.递归搜索整棵树，用HashMap记录每一个结点的父亲结点
2.从给的p结点出发，不断地向上搜索父亲结点，将每一个结点标记为true
3.从给的q结点出发，不断地向上搜索父亲结点，如果父亲结点的标记为true，说明找到了第一个相同的父亲结点

假设有n个结点,搜索整棵树的时间复杂度为O(n),
从给的p结点向上搜索的时间复杂度最坏为O(n),
从给的q结点向上搜索的时间复杂度最坏为O(n),
因此时间复杂度为O(n),空间复杂度为O(n).

Java 代码
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parent=new HashMap<>();
    Map<TreeNode,Boolean> same=new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
            return null;

        findparent(root);

        while(p!=null){
            same.put(p,true);
            p=parent.get(p);
        }
        while(q!=null){
            if(same.get(q)!=null&&same.get(q)==true)
                return q;
            q=parent.get(q);
        }
        return root;
    }
    void findparent(TreeNode root){
        if(root.left!=null){
            parent.put(root.left,root);
            findparent(root.left);
        }
        if(root.right!=null){
            parent.put(root.right,root);
            findparent(root.right);
        }
    }
}

别人的思路 C++做法
很巧妙，利用了BST的特性，当前节点的左子树任一结点的值小于当前节点，右子树任一结点的值大于当前节点。

递归
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (p -> val < root -> val && q -> val < root -> val)
            return lowestCommonAncestor(root -> left, p, q);
        if (p -> val > root -> val && q -> val > root -> val)
            return lowestCommonAncestor(root -> right, p, q);
        return root;
    }
};
迭代
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* cur = root;
        while (true) {
            if (p -> val < cur -> val && q -> val < cur -> val)
                cur = cur -> left;
            else if (p -> val > cur -> val && q -> val > cur -> val)
                cur = cur -> right;
            else
                return cur;
        }
    }
};

