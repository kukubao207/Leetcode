package Tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//652. Find Duplicate Subtrees
//Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//Two trees are duplicate if they have the same structure with same node values.
//
//Example 1:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//The following are two duplicate subtrees:
//
//      2
//     /
//    4
//and
//
//    4
//Therefore, you need to return above trees' root in the form of a list.
public class FindDuplicateSubtrees {
    //一般比较是否重复出现往往用到HashMap<val,出现的次数>
    //时间复杂度O(n)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<String, Integer> map = new HashMap<>();
        inOrder(root, map, res);
        return res;
    }
    public String inOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> res){
        if(root == null)//null节点特殊标识出来
            return "#";
        //Map的key，由根节点、左子树和右子树组成，放进map里面计数，超过1则加入list中
        String str = root.val + "," + inOrder(root.left, map, res) + "," + inOrder(root.right, map, res);//前序遍历
        if(map.getOrDefault(str, 0) == 1){//第一次重复的时候加入list
            res.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return  str;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
