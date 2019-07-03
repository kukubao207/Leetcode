package Tree.medium;

import java.awt.geom.QuadCurve2D;
import java.util.*;

//515. Find Largest Value in Each Tree Row
//You need to find the largest value in each row of a binary tree.
//
//Example:
//Input:
//
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//Output: [1, 3, 9]
public class FindLargestValueInEachTreeRow {
    //1.层次遍历
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            while(count > 0){
                TreeNode node = queue.poll();
                if(node.val > max)
                    max = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            list.add(max);
        }
        return list;
    }

    //2.深度遍历(用了一个hashmap)
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues1(TreeNode root) {
        dfs(root, 0);
        for (Integer key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(!map.containsKey(depth))
            map.put(depth, root.val);
        else
            map.replace(depth,  Math.max(map.get(depth), root.val));
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
