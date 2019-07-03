package Tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//508. Most Frequent Subtree Sum
//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
//
//Examples 1
//Input:
//
//  5
// /  \
//2   -3
//return [2, -3, 4], since all the values happen only once, return all of them in any order.
//Examples 2
//Input:
//
//  5
// /  \
//2   -5
//return [2], since 2 happens twice, however -5 only occur once.
//Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
public class MostFrequentSubtreeSum {
    //求出二叉树所有子树（包括包含根节点的树）的元素和，然后求出出现元素和次数最多的那些
    //引入hashmap(<子树和，个数>)
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        helper(root, map);
        //然后求出map中value最大值对应的Key
        List<Integer> list = new ArrayList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max)
                list.add(i);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    //求出现次数最多是多少（max）
    int max = Integer.MIN_VALUE;
    //求出以当前节点为子树的元素和
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int val = left + right + root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);//Map.getOrDefault(Object key, V defaultValue)方法的作用是：
        // 当Map集合中有这个key时，就使用这个key值取value；如果没有就使用默认值defaultValue。
        max = Math.max(max, map.get(val));
        return val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
