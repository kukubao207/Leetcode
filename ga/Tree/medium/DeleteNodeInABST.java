package Tree.medium;
//450. Delete Node in a BST
//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.
//Note: Time complexity should be O(height of tree).
//
//Example:
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Given key to delete is 3. So we find the node with value 3 and delete it.
//
//One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//Another valid answer is [5,2,6,null,4,null,7].
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
public class DeleteNodeInABST {
    //采用递归删除 先找到节点，判断节点的左右根节点的情况：

    //1.如果待删节点的左孩子为空，就将右孩子返回给待删节点的父节点。
    //2.如果待删节点的右孩子为空，就将左孩子返回给待删节点的父节点。
    //3.如果都不为空，在待删节点的右子树中找到最小值节点，将此节点删下来，代替待删节点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(key < root.val){//待删节点在左子树
            root.left = deleteNode(root.left, key);
            return root;
        }else if(key > root.val){//待删节点在右子树
            root.right = deleteNode(root.right, key);
            return root;
        }else{//key == root.val
            if(root.left == null){
                // 返回右子树作为新的根
                return root.right;
            }else if(root.right == null){
                // 返回左子树作为新的根
                return root.left;
            }else{
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode nRoot = min(root.right);
                nRoot.right = deleteMin(root.right);
                nRoot.left = root.left;
                return nRoot;
            }
        }
    }

    //找最左节点
    private TreeNode min(TreeNode node) {
        if(node.left == null)
            return node;
        return min(node.left);
    }

    //删除最左节点的树
    private TreeNode deleteMin(TreeNode node) {
        if(node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
