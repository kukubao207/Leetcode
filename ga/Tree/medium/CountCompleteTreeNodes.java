package Tree.medium;
//222.Given a complete binary tree, count the number of nodes.
//Note:
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

//Example:
//Input:
//    1
//   / \
//  2   3
// / \  /
//4  5 6

//Output: 6
public class CountCompleteTreeNodes {
    //1.递归 直接计数
    int count = 0;
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
    //2.利用完全二叉树的性质，只看层数和最后一层有多少节点
    /**
     完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     判断左右子树的高度:
     如果相等说明左子树是满二叉树(可以利用公式2^n-1计算), 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
     如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
     **/
    public int countNodes1(TreeNode root) {
        if(root == null)
            return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld == rd)
            //对于正数和负数，左移一位(<<)都相当于乘以2的1次方，左移n位就相当于乘以2的n次方。
            return 1 + (1 << ld) - 1 + countNodes1(root.right);// 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        else
            return 1 + (1 << rd) - 1 + countNodes1(root.left);// 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
    }

    public int getDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            depth++;
            root = root.left;
        }
        return depth;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
