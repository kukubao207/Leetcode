package Tree.hard;
//968. Binary Tree Cameras
//Given a binary tree, we install cameras on the nodes of the tree.
//
//Each camera at a node can monitor its parent, itself, and its immediate children.
//
//Calculate the minimum number of cameras needed to monitor all nodes of the tree.
//
//
//
//Example 1:
//
//
//Input: [0,0,null,0,0]
//Output: 1
//Explanation: One camera is enough to monitor all nodes if placed as shown.
//Example 2:
//
//
//Input: [0,0,null,0,null,0,null,null,0]
//Output: 2
//Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
//
//Note:
//
//The number of nodes in the given tree will be in the range [1, 1000].
//Every node has value 0.
public class BinaryTreeCameras {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        TreeNode dummy = new TreeNode(0);//虚拟节点
        dummy.left = root;//根节点没有上层来监控 只能自己监控自己 如果根节点和左右子节点为未监控状态 必须设为监控器
        dfs(dummy);
        return res;
    }
    // dfs 节点有三种状态
    // 0：初始状态，如果节点为null可以返回，也就是不影响其他节点
    // 1：未监控状态，当两个节点都是0时，我们直接设置当前节点为未监控状态
    // 2：监控态，如果子节点含有未监控状态(1)状态，则此节点必须添加摄像头，同时返回当前状态为监控态,表明此节点已经被监控，当子节点为此状态时，父节点不需要添加摄像头，可以返回初始态
    private int dfs(TreeNode node) {
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left + right == 0)
            return 1;
        else if(left == 1 || right == 1){
            res++;
            return 2;
        }else
            return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
