package Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树

 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class SerializeBT {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    String Serialize(TreeNode root) {
        return rSerialize(root, "");
    }
    String rSerialize(TreeNode root, String str){
        if(root == null)
            return str + "#" + ",";
        str += root.val + ",";
        str = rSerialize(root.left, str);
        str = rSerialize(root.right, str);
        return str;
    }
    TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strs));
        return rDeserialize(list);
    }
    TreeNode rDeserialize(ArrayList<String> list){
        if(list.get(0).equals("#")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rDeserialize(list);
        root.right = rDeserialize(list);
        return root;
    }
}
