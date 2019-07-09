package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//623. Add One Row to Tree
//Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
//
//The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
//
//Example 1:
//Input:
//A binary tree as following:
//       4
//     /   \
//    2     6
//   / \   /
//  3   1 5
//
//v = 1
//
//d = 2
//
//Output:
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     /
// 3   1   5
//
//Example 2:
//Input:
//A binary tree as following:
//      4
//     /
//    2
//   / \
//  3   1
//
//v = 1
//
//d = 3
//
//Output:
//      4
//     /
//    2
//   / \
//  1   1
// /     \
//3       1
//Note:
//The given d is in range [1, maximum depth of the given tree + 1].
//The given binary tree has at least one tree node.
public class AddOneRowToTree {
    //1.递归
    //时间复杂度O(n)
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d < 1 || root == null)
            return root;
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;//如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
            return newRoot;
        }
        if(d == 2){//单独考虑
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return root;
        }
        root.left = addOneRow(root.left, v, d - 1);
        root.right = addOneRow(root.right, v, d - 1);
        return root;
    }

    //2.层次遍历
    //时间复杂度O(n)
    //空间复杂度O(n)？？？
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int curDepth = 1;
            while(!queue.isEmpty()){
                if(curDepth == d - 1){//到达需要处理的层
                    for(TreeNode p: queue){//把上一层的所有节点的左右孩子进行替换
                        TreeNode left = new TreeNode(v);
                        TreeNode right = new TreeNode(v);
                        left.left = p.left;
                        right.right = p.right;
                        p.left = left;
                        p.right = right;
                    }
                    return root;
                }else{//就是普通的层次遍历
                    int count = queue.size();
                    while(count > 0){
                        TreeNode node = queue.poll();
                        if(node.left != null)
                            queue.add(node.left);
                        if(node.right != null)
                            queue.add(node.right);
                        count --;
                    }
                    curDepth++;
                }
            }
            return root;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
