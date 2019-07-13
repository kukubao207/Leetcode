package Tree.medium;

import java.util.*;

//863. All Nodes Distance K in Binary Tree
//We are given a binary tree (with root node root), a target node, and an integer value K.
//
//Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
//
//
//
//Example 1:
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//Output: [7,4,1]
//
//Explanation:
//The nodes that are a distance 2 from the target node (with value 5)
//have values 7, 4, and 1.
//
//
//
//Note that the inputs "root" and "target" are actually TreeNodes.
//The descriptions of the inputs above are just serializations of these objects.
//
//
//Note:
//
//The given tree is non-empty.
//Each node in the tree has unique values 0 <= node.val <= 500.
//The target node is a node in the tree.
//0 <= K <= 1000.
public class AllNodesDistanceKInBinaryTree {
    //1.先建立图(dfs)然后bfs dfs+bfs

    //2.直接二叉树上操作就可以，先用dfs找到target以及记录下target的parent，
    // 然后对target到离target为K的parent进行K到0的层次遍历就可以得到答案。要注意已经层次遍历过的节点不要再次层次遍历，否则答案会错误

    //利用map存储每个节点及其对应的父节点，在对二叉树进行层序遍历的同时向父节点方向遍历。即以target为中心向四周扩散，直到扩散至第K层，找到所有第K层的节点。
    Map<TreeNode, TreeNode> pmap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, null);
        return helper(root, target, K);
    }
    public List<Integer> helper(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();//层次遍历
        Set<TreeNode> set = new HashSet<>();//存放已经访问过的节点(走到parent再走左（右）孩子)，重复走一条线
        queue.add(target);
        set.add(target);
        int level = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> subRes = new ArrayList<>();
            while(count > 0){
                TreeNode node = queue.poll();
                subRes.add(node.val);
                if(node.left != null && set.add(node.left))
                    queue.add(node.left);
                if(node.right != null && set.add(node.right))
                    queue.add(node.right);
                if(pmap.containsKey(node) && set.add(pmap.get(node)))
                    queue.add(pmap.get(node));
                count--;
            }
            if(level++ == k)
                res = new ArrayList<>(subRes);
            else
                subRes.clear();
        }
        return res;
    }
    public void dfs(TreeNode root, TreeNode parent){
        if(root == null)
            return;
        if(parent != null){
            pmap.put(root, parent);
        }
        parent = root;
        dfs(root.left, parent);
        dfs(root.right, parent);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
