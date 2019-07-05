package Tree.easy;

import java.util.List;

//559. Maximum Depth of N-ary Tree
//Given a n-ary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//For example, given a 3-ary tree:
//
//
//
//
//
//
//We should return its max depth, which is 3.
//
//
//
//Note:
//
//The depth of the tree is at most 1000.
//The total number of nodes is at most 5000.
public class MaximumDepthOfNaryTree {
    //DFS递归写法
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int depth = 0;//计算新的子树高度从0开始  注意！！！不要写在函数体外面
        for(Node n : root.children){
            depth = Math.max(depth, maxDepth(n));
        }
        return depth + 1;
    }

    //层次遍历（depth++）不写了
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
