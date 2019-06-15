package Tree.hard;
//99. 恢复二叉搜索树
//二叉搜索树中的两个节点被错误地交换。
//
//请在不改变其结构的情况下，恢复这棵树。
//
//示例 1:
//
//输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
//示例 2:
//
//输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
//进阶:
//
//使用 O(n) 空间复杂度的解法很容易实现。
//你能想出一个只使用常数空间的解决方案吗？
//
public class RecoverBinarySearchTree {
    //我们对错误的二叉树进行 中序遍历 那我们按顺序访问到的数应该是按顺序排列的
    //那如果对两个节点交换了顺序  那一定有两个地方是  不满足  前一个元素 < 当前元素 < 后一个元素
    //如示例2      3  1  4   2：
            //3  这个节点不满足      2 这个节点不满足
    //所以我们使用两个全局变量在遍历过程中记录这两个节点 最后对他们进行交换
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(pre != null && pre.val > root.val){//pre和root需要交换
            if(pre == null)
                t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
