package Tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//429. N-ary Tree Level Order Traversal
//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example, given a 3-ary tree:
//
//
//
//
//
//
//
//We should return its level order traversal:
//
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//Note:
//
//The depth of the tree is at most 1000.
//The total number of nodes is at most 5000.
public class NaryTreeLevelOrderTraversal {
    //层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0){
                Node node = queue.poll();
                list.add(node.val);
                for(Node child: node.children)
                    queue.add(child);
                count--;
            }
            res.add(list);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
