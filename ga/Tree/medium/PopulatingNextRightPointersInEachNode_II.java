package Tree.medium;

import java.util.LinkedList;
import java.util.Queue;

//117. Populating Next Right Pointers in Each Node II
//Given a binary tree
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//
//
//Example:
//
//
//
//Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
//
//Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
//
//Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
//
//
//Note:
//
//You may only use constant extra space.
//Recursive approach is fine, implicit stack space does not count as extra space for this problem.
public class PopulatingNextRightPointersInEachNode_II {
    //1.递归(注意优先级)
    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left != null){
            if(root.right != null){
                // 若右子树不为空，则左子树的 next 即为右子树
                root.left.next = root.right;
            }else{
                // 若右子树为空，则左子树的 next 由根节点的 next 得出
                root.left.next = nextNode(root.next);
            }
        }
        if(root.right != null){
            // 右子树的 next 由根节点的 next 得出
            root.right.next = nextNode(root.next);
        }
        // 先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
        // 需要 root.left.next 下的节点的信息，若 root.right 下的节点未完全连
        // 接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
        // 返回错误的信息。可能出现的错误情况如下图所示。此时，底层最左边节点将无
        // 法获得正确的 next 信息：
        //                    o root
        //                   / \
        //     root.left  o —— o  root.right
        //               /      / \
        //              o —— o   o(这里遍历不到next)
        //             /          / \
        //            o          o   o
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node nextNode(Node node){
        while(node != null){
            if(node.left != null)
                return node.left;
            if(node.right != null)
                return node.right;
            node = node.next;
        }
        return null;
    }

    //2.迭代
    public Node connect1(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                Node node = queue.poll();
                count--;
                if(count > 0)
                    node.next = queue.peek();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
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
