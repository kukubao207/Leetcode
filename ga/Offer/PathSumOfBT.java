package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**二叉树中和为某一值得路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class PathSumOfBT {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if(root == null)
            return res;
        preOrder(root, target, res, tmp);
        Collections.sort(res, new SortedByLength());
        return res;
    }
    public void preOrder(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(target == root.val){
                tmp.add(root.val);
                res.add(new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size() - 1);
            }
            return;
        }
        tmp.add(root.val);
        preOrder(root.left, target - root.val, res, tmp);
        preOrder(root.right, target - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
    public class SortedByLength implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2){
            if(list1.size() < list2.size())
                return 1;
            else if(list1.size() > list2.size())
                return -1;
            else
                return 0;
        }
    }
}
