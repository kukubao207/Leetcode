package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//919. Complete Binary Tree Inserter
//A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
//
//Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
//
//CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
//CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
//CBTInserter.get_root() will return the head node of the tree.
//
//
//Example 1:
//
//Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
//Output: [null,1,[1,2]]
//Example 2:
//
//Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
//Output: [null,3,4,[1,2,3,4,5,6,7,8]]
//
//
//Note:
//
//The initial given tree is complete and contains between 1 and 1000 nodes.
//CBTInserter.insert is called at most 10000 times per test case.
//Every value of a given or inserted node is between 0 and 5000.
public class CompleteBinaryTreeInserter {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root;
    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        ConvertToQueue(root);
    }
    public void ConvertToQueue(TreeNode root){
        if(root == null)
            return;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            if(node.left != null)
                queue.add(node.left);
            else break;
            if(node.right != null)
                queue.add(node.right);
            else break;
            queue.poll();//满子树节点才会poll
        }
    }

    public int insert(int v) {
        if(!queue.isEmpty()){
            TreeNode node = queue.peek();
            TreeNode cur = new TreeNode(v);
            if(node.left == null)
                node.left = cur;
            else if(node.right == null){
                node.right = cur;
                queue.poll();//满子树才会poll
            }
            queue.add(cur);
            return node.val;//返回插入的paremt
        }
        return -1;
    }

    public TreeNode get_root() {
        return this.root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
