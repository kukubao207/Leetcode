package Tree.easy;
//606. Construct String from Binary Tree
//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//
//The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
//
//Example 1:
//Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
//Output: "1(2(4))(3)"
//
//Explanation: Originallay it needs to be "1(2(4)())(3()())",
//but you need to omit all the unnecessary empty parenthesis pairs.
//And it will be "1(2(4))(3)".
//Example 2:
//Input: Binary tree: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
//Output: "1(2()(4))(3)"
//
//Explanation: Almost the same as the first example,
//except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
public class ConstructStringFromBinaryTree {
    //时间复杂度O(n)
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        preOrder(t);
        return sb.toString();
    }
    // 可以利用先序遍历解答
    public void preOrder(TreeNode t){
        if(t == null)
            return;
        sb.append(t.val);
        if(t.left == null && t.right != null)//没有左孩子的时候才要加括号，没有右孩子的时候不需要加
            sb.append("()");
        if(t.left != null){
            sb.append("(");
            preOrder(t.left);
            sb.append(")");
        }
        if(t.right != null){
            sb.append("(");
            preOrder(t.right);
            sb.append(")");
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
