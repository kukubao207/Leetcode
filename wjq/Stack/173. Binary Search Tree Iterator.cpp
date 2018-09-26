173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

我的做法
这道题就是用迭代器实现二叉树的中根遍历，昨天刚写过，所以遍历的代码很快就写出来了，
但是由于对边界值处理不当，耗费了一点时间。

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    stack<TreeNode *> s;
    BSTIterator(TreeNode *root) {
        s.push(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !s.empty()&&s.top()!=NULL;
    }

    /** @return the next smallest number */
    int next() {
        int smallest=0;
        while(!s.empty())
        {
            TreeNode *cur=s.top();
            if(cur->left!=NULL)
            {
                s.push(cur->left);
                cur->left=NULL;
            }
            else
            {
                smallest=s.top()->val;
                s.pop();
                if(cur->right!=NULL)
                    s.push(cur->right);
                break;
            }
        }
        return smallest;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */

 别人的做法

class BSTIterator {
    stack<TreeNode *> myStack;
public:
    BSTIterator(TreeNode *root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !myStack.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode *tmpNode = myStack.top();
        myStack.pop();
        pushAll(tmpNode->right);
        return tmpNode->val;
    }

private:
    void pushAll(TreeNode *node) {
        for (; node != NULL; myStack.push(node), node = node->left);
    }
};

他的做法是先把所有最左边一排的left节点压到栈里。
然后依次取出这一排中的left节点，把这些left节点的右边结点的部分也全部压到栈里。
因为越靠近root的层对应的right结点的值越大，所以这些大的值最先被压入，越后被
弹出。
