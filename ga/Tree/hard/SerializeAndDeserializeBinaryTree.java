package Tree.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//297. Serialize and Deserialize Binary Tree
//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//Example:
//
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
//Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
//Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
public class SerializeAndDeserializeBinaryTree {
    //序列化：将树保存下来(字符串)；逆序列化：将序列化的字符串结果再还原成树，当然，和原先树的结构要一样。
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return helper(root, "");
    }
    //先序遍历
    public String helper(TreeNode root, String str) {
        if(root == null)
            str = str + "null" + ",";
        else{
            str = str + root.val + ",";
            str = helper(root.left, str);
            str = helper(root.right, str);//赋值以后回溯str会变化
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(node));
        return rdeserialize(list);
    }
    public TreeNode rdeserialize(List<String> list) {
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
