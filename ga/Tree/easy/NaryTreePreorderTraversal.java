package Tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//589. N-ary Tree Preorder Traversal
//Given an n-ary tree, return the preorder traversal of its nodes' values.
//
//For example, given a 3-ary tree:
//
//
//
//
//
//
//
//Return its preorder traversal as: [1,3,5,6,2,4].
//
//
//
//Note:
//
//Recursive solution is trivial, could you do it iteratively?
public class NaryTreePreorderTraversal {
    //时间复杂度O(n)
    //1.递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        res.add(root.val);
        for (Node c : root.children) {
            preorder(c);
        }
        return res;
    }
    //2.迭代
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.add(cur.val);
            for(int i = cur.children.size() - 1; i >= 0; i--)//倒着push
                stack.push(cur.children.get(i));
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
