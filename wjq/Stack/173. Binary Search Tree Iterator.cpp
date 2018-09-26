173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

�ҵ�����
���������õ�����ʵ�ֶ��������и������������д�������Ա����Ĵ���ܿ��д�����ˣ�
�������ڶԱ߽�ֵ���������ķ���һ��ʱ�䡣

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

 ���˵�����

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

�����������Ȱ����������һ�ŵ�left�ڵ�ѹ��ջ�
Ȼ������ȡ����һ���е�left�ڵ㣬����Щleft�ڵ���ұ߽��Ĳ���Ҳȫ��ѹ��ջ�
��ΪԽ����root�Ĳ��Ӧ��right����ֵԽ��������Щ���ֵ���ȱ�ѹ�룬Խ��
������
