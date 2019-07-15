package Tree.medium;
//889. Construct Binary Tree from Preorder and Postorder Traversal
//Return any binary tree that matches the given preorder and postorder traversals.
//
//Values in the traversals pre and post are distinct positive integers.
//
//
//
//Example 1:
//
//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
//
//
//Note:
//
//1 <= pre.length == post.length <= 30
//pre[] and post[] are both permutations of 1, 2, ..., pre.length.
//It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    //1.前序的第一个节点必然等于后序的最后一个节点，这个节点为根节点，然后再找一把刀，把中间的砍成左子树和右子树
    //2.前序的第二个节点，就是左子树的根节点，同时要找到这个节点在后序中的位置，那么从后序开头到这个位置之间，就是左子树了，这个位置到后序的末尾就是右子树了 。
//    1 (2 4 5) (3 6 7)
//      (4 5 2) (6 7 3) 1
    //前序：中 左 右
    //后序：左 右 中

    //固定套路
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = post.length - 1;
        return helper(pre, post, 0, length , 0, length);
    }
    public TreeNode helper(int[] pre, int[] post, int prestart, int preend, int poststart, int postend){
        if(prestart > preend || poststart > postend)
            return null;
        if(prestart == preend)
            return new TreeNode(pre[prestart]);
        int val = pre[prestart + 1];
        for(int i = poststart; i <= postend; i++){
            if(post[i] == val){
                TreeNode root = new TreeNode(pre[prestart]);
                int length = i - poststart;
                root.left = helper(pre, post, prestart + 1, prestart + 1 + length, poststart, i);
                root.right = helper(pre, post, prestart + 2 + length, preend, i + 1, postend - 1);
                return root;
            }
        }
        return null;

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
