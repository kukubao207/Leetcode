package Tree.medium;

import java.util.ArrayList;
import java.util.List;

//655. Print Binary Tree
//Print a binary tree in an m*n 2D string array following these rules:
//
//The row number m should be equal to the height of the given binary tree.
//The column number n should always be an odd number.
//The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
//Each unused space should contain an empty string "".
//Print the subtrees following the same rules.
//Example 1:
//Input:
//     1
//    /
//   2
//Output:
//[["", "1", ""],
// ["2", "", ""]]
//Example 2:
//Input:
//     1
//    / \
//   2   3
//    \
//     4
//Output:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
//Example 3:
//Input:
//      1
//     / \
//    2   5
//   /
//  3
// /
//4
//Output:
//
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
//Note: The height of binary tree is in the range of [1, 10].
public class PrintBinaryTree {
    //时间复杂度O(n)
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        if(root == null)
            return res;
        int depth = getDepth(root);
        int width = (int)Math.pow(2, depth) - 1;
        List list = new ArrayList<>();
        for(int i = 0; i < width; i++){//初始化
            list.add("");
        }
        for(int i = 0; i < depth; i++){
            res.add(new ArrayList<>(list));//要new新空间 不然每次替换的是同一个空间
        }
        preOrder(root, 1, 0, width - 1);
        return res;
    }

    //根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）
    public void preOrder(TreeNode root, int depth, int l, int r){
        if(root == null)
            return;;
        int m = l + (r - l) / 2;
        res.get(depth - 1).set(m, String.valueOf(root.val));
        preOrder(root.left, depth + 1, l, m - 1);
        preOrder(root.right, depth + 1, m + 1, r);
    }

    public int getDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
