package Tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//590. N-ary Tree Postorder Traversal
//Given an n-ary tree, return the postorder traversal of its nodes' values.
//
//For example, given a 3-ary tree:
//
//
//
//
//
//
//
//Return its postorder traversal as: [5,6,3,2,4,1].
//
//
//Note:
//
//Recursive solution is trivial, could you do it iteratively?
public class NaryTreePostorderTraversal {
    //时间复杂度O(n)
    //1.递归
    public List<Integer> postorder(Node root) {
        if(root == null)
            return new ArrayList<>();
        List res = new ArrayList();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List res){
        if(root == null)
            return;
        for(Node c: root.children){
            helper(c, res);
        }
        res.add(root.val);
    }

    //2.迭代
    public List<Integer> postorder1(Node root) {
        if(root == null)
            return new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        List res = new ArrayList<>();
        Node pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.peek();
            if(cur.children.size() == 0 || (pre != null && cur.children.contains(pre))){//输出的两个条件：某点是叶子节点或者某点的child节点已经被访问过（回溯到某点）
                res.add(cur.val);
                pre = cur;
                stack.pop();
            }else{
                for(int i = cur.children.size() - 1; i >= 0; i--)//逆序push 这样拿出来是从左到右
                    stack.push(cur.children.get(i));
            }
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
