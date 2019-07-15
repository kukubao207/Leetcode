package Tree.easy;

import java.util.ArrayList;
import java.util.List;

//872. Leaf-Similar Trees
//Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
//Note:
//
//Both of the given trees will have between 1 and 100 nodes.
public class LeafSimilarTrees {
    //深度搜索将叶子节点保存到list中（放在String也可以）
    //比较list1和list2是否相等
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        dfs(root1,list1);
        dfs(root2,list2);
        if(list1.size() != list2.size())
            return false;
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

//    public String dfs1(TreeNode root, String str){
//        if(root == null)
//            return null;
//        if(root.left == null && root.right == null){
//            str = str + root.val;
//            return str;
//        }
//        return dfs1(root.left, str) + dfs1(root.right, str);
//    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
