package Tree.medium;

//如何实现二叉树的前中后序遍历，有两个要求：

import java.util.ArrayList;
import java.util.List;

//1. O(1)空间复杂度，即只能使用常数空间；
//2. 二叉树的形状不能被破坏（中间过程允许改变其形状）。
//利用所有叶子结点的right 指针，指向其前趋结点，组成一个环，在第二次遍历到这个结点时，由于其左子树已经遍历完了，则访问该结点
public class MorrisTraversal {
    //https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre;//定义两个辅助变量
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                pre = cur.left;//当前节点的左子树不为空，这个时候只要找到当前节点左子树中最右的叶子节点，即是当前节点的直接前驱
                while(pre.right != null && pre.right != cur){//第一次遍历等于null,第二次遍历等于cur
                    pre = pre.right;
                }
                if(pre.right == null){//第一次遇到
                    pre.right = cur;
                    cur = cur.left;
                }else{//第二次遇到
                    pre.right = null;//恢复原状
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    //先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;
                if(pre.right == null){//第一次遇到就输出，不要等到第二次
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    //后序遍历
    //后续遍历稍显复杂，需要建立一个临时节点dump，令其左孩子是root。
    // 并且还需要一个子过程，就是倒序输出某两个节点之间路径上的各个节点。
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode cur = dump;
        TreeNode pre;
        while(cur != null){
            if(cur.left == null){
                cur = cur.right;
            }else{
                pre = cur.left;
                while(cur.right != null && cur.right != cur)
                    pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    printReverse(cur.left, pre); //倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

//      逆序输出（和链表一样）
//    TreeNode* reverseList(TreeNode* head) {
//        TreeNode *pre = NULL, *cur=head;
//        while(cur!=NULL)
//        {
//            ListNode *next = cur->right;
//            cur->right = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public void printReverse(TreeNode from , TreeNode to){
        reserve(from, to);
        TreeNode p = to;
        while(true){
            res.add(p.val);
            if(p == from)
                break;;
            p = p.right;
        }
        reserve(to, from);//恢复原状
    }
    public void reserve(TreeNode from ,TreeNode to){
        if(from == to)
            return;
        TreeNode x = from;
        TreeNode y = from.right;
        TreeNode z;
        while(true){
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if(x == to)
                break;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
