package Tree.hard;
//1028. Recover a Tree From Preorder Traversal
//We run a preorder depth first search on the root of a binary tree.
//
//At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
//
//If a node has only one child, that child is guaranteed to be the left child.
//
//Given the output S of this traversal, recover the tree and return its root.
//
//
//
//Example 1:
//
//
//
//Input: "1-2--3--4-5--6--7"
//Output: [1,2,5,3,4,6,7]
//Example 2:
//
//
//
//Input: "1-2--3---4-5--6---7"
//Output: [1,2,5,3,null,6,null,4,null,7]
//
//
//Example 3:
//
//
//
//Input: "1-401--349---90--88"
//Output: [1,401,null,349,88,90]
//
//
//Note:
//
//The number of nodes in the original tree is between 1 and 1000.
//Each node will have a value between 1 and 10^9.
public class RecoverATreeFromPreorderTraversal {
    //先序 + 深度信息（depth）  还原二叉树
    //先序遍历：中 左 后
    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0)
            return null;
        return helper(S.toCharArray(), 0, S.length() - 1, 1);
    }
    public TreeNode helper(char[] arr, int start, int end, int depth){
        if(start > end)
            return null;
        //找根节点
        StringBuffer sb = new StringBuffer();
        sb.append(arr[start]);
        while(start < end && arr[start + 1] >= '0' && arr[start + 1] <= '9'){//一个节点的值可能不止一位数
            start++;
            sb.append(arr[start]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));
        //求出右子树节点的起始位置，即找到前面有depth个'-'的数字
        int index = start + 1 + depth;
        while(index <= end){
            int count = 0;
            while(index < end && arr[index] == '-'){
                count++;
                index++;
            }
            if(count == depth)
                break;
            index++;
        }
        // 注意一种特殊情况，即右子树不存在时，
        // 左子树元素的末尾索引为当前递归数组的最末索引；如果右子树存在，则左子树元素的末尾索引为start-1-depth。
        int rightStart = index;
        if(rightStart <= end)//当右子树存在时
            index = index - 1 - depth;
        else//当右子树不存在时
            index = end;
        //构建左右子树
        root.left = helper(arr, start + 1 + depth, index, depth+1);
        root.right = helper(arr, rightStart, end, depth+1);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
