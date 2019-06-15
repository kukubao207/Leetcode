package Tree.medium;

import java.util.ArrayList;
import java.util.List;

// 95. 不同的二叉搜索树 II
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
//示例:
//
//输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
public class UniqueBinarySearchTrees_II {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    //递归
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start == end){
            //只有一个节点
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        //mid为根节点 左右子树分别为start到mid-1 和 mid+1到end
        for(int mid = start; mid <= end; mid++){
            List<TreeNode> left = new ArrayList<TreeNode>();
            List<TreeNode> right = new ArrayList<TreeNode>();
            if(mid != start){
                //说明有左子树
                left = generateTrees(start, mid - 1);
            }
            if(mid != end){
                //说明有右子树
                right = generateTrees(mid + 1, end);
            }
            if(!left.isEmpty() && !right.isEmpty()){
                for(TreeNode l :left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(mid);//构建树
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }else if(!left.isEmpty()){
                for(TreeNode l :left){
                    TreeNode root = new TreeNode(mid);
                    root.left = l;
                    res.add(root);
                }
            }else if(!right.isEmpty()){
                for(TreeNode r :right){
                    TreeNode root = new TreeNode(mid);
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
