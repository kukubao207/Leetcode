package Tree.medium;
//449. Serialize and Deserialize BST
//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//The encoded string should be as compact as possible.
//
//Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    //序列化的时候按前序遍历序列化，用","分隔
    //如果是一个普通二叉树，需要前序和中序，或者后序和中序两个序列，才能唯一确定二叉树结构，
    // 而二叉搜索树，由于各元素之间有左子节点小于父节点再小于右子节点的性质，因此用一个前序排列就可以确定出唯一结构
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        String s = root.val + ",";
        s = s + serialize(root.left);
        s = s + serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        String[] s = data.split(",");
        return rdeserialize(s, 0, s.length - 1);
    }

    public TreeNode rdeserialize(String[] s, int start, int end){
        if(start > end)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(s[start]));
        int i;
        for(i = start + 1; i <= end; i++){
            if(Integer.valueOf(s[i]) > root.val)
                break;;
        }
        root.left = rdeserialize(s, start + 1, i - 1);
        root.right = rdeserialize(s, i, end);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
