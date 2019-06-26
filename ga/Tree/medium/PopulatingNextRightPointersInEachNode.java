package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//116.You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//Initially, all next pointers are set to NULL.
public class PopulatingNextRightPointersInEachNode {
    //1.递归
    public Node connect(Node root) {
        if(root == null || root.left == null)
            return root;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    //2.迭代  类似于层次遍历
    public Node connect1(Node root) {
        if(root == null || root.left == null)
            return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                Node node = queue.poll();
                if(node.left == null)
                    break;
                node.left.next = node.right;
                queue.add(node.left);
                node.right.next = (node.next == null)? null : node.next.left;
                queue.add(node.right);
                count--;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
