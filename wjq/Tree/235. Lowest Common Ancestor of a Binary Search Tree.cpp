235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: ��The lowest common ancestor is defined between two
nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to
be a descendant of itself).��

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes
2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


�ҵ�˼·
1.�ݹ���������������HashMap��¼ÿһ�����ĸ��׽��
2.�Ӹ���p�����������ϵ������������׽�㣬��ÿһ�������Ϊtrue
3.�Ӹ���q�����������ϵ������������׽�㣬������׽��ı��Ϊtrue��˵���ҵ��˵�һ����ͬ�ĸ��׽��

������n�����,������������ʱ�临�Ӷ�ΪO(n),
�Ӹ���p�������������ʱ�临�Ӷ��ΪO(n),
�Ӹ���q�������������ʱ�临�Ӷ��ΪO(n),
���ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(n).

Java ����
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

���˵�˼· C++����
�����������BST�����ԣ���ǰ�ڵ����������һ����ֵС�ڵ�ǰ�ڵ㣬��������һ����ֵ���ڵ�ǰ�ڵ㡣

�ݹ�
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
����
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

