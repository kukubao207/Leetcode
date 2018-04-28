101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

我的思路
递归解法 recursively
先把左子树做一个镜像翻转，然后与右子树对比是否完全相同。

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if(root==NULL)
            return true;
        root->left=InvertTree(root->left);
        return SameTree(root->left,root->right);
    }
    TreeNode* InvertTree(TreeNode *root){
        if(root==NULL)
            return NULL;
        TreeNode *temp=root->left;
        root->left=InvertTree(root->right);
        root->right=InvertTree(temp);
        return root;
    }
    bool SameTree(TreeNode *t1,TreeNode *t2){
        if(t1==NULL)
            return t2==NULL;
        if(t2==NULL)
            return t1==NULL;
        //now t1!=NULL&&t2!=NULL
        return t1->val==t2->val&&SameTree(t1->left,t2->left)&&SameTree(t1->right,t2->right);
    }
};


迭代解法 iteratively

别人的解法
递归
bool isSymmetric(TreeNode *root) {
    if (!root) return true;
    return helper(root->left, root->right);
}

bool helper(TreeNode* p, TreeNode* q) {
    if (!p && !q) {
        return true;
    } else if (!p || !q) {
        return false;
    }

    if (p->val != q->val) {
        return false;
    }

    return helper(p->left,q->right) && helper(p->right, q->left);
}
迭代
public boolean isSymmetric(TreeNode root) {
    if(root==null)  return true;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode left, right;
    if(root.left!=null){
        if(root.right==null) return false;
        stack.push(root.left);
        stack.push(root.right);
    }
    else if(root.right!=null){
        return false;
    }

    while(!stack.empty()){
        if(stack.size()%2!=0)
            return false;
        right = stack.pop();
        left = stack.pop();
        if(right.val!=left.val)
            return false;

        if(left.left!=null){
            if(right.right==null)
                return false;
            stack.push(left.left);
            stack.push(right.right);
        }
        else if(right.right!=null){
            return false;
        }

        if(left.right!=null){
            if(right.left==null)
                return false;
            stack.push(left.right);
            stack.push(right.left);
        }
        else if(right.left!=null){
            return false;
        }
    }
    return true;
}
