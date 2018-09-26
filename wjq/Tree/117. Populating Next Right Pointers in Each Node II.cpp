117. Populating Next Right Pointers in Each Node II

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

我的思路
和之前的一道题的思路一致，维护两个队列。
队列1只存有这一层的元素，用来为这一层的元素做链接。
队列2用来控制为当前层做链接时下一层元素的入队。
当这一层的链接完成后，令队列1=队列2。

/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(root==NULL)
            return;
        queue<TreeLinkNode *> q,p;
        q.push(root);
        p.push(root);
        while(!q.empty())
        {
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                root=q.front();
                q.pop();
                p.pop();
                if(!q.empty())
                    root->next=q.front();
                if(root->left!=NULL)
                    p.push(root->left);
                if(root->right!=NULL)
                    p.push(root->right);
            }
            q=p;
        }
    }
};

我的第二个思路
直接两个指针开搞
class Solution {
public:
    void connect(TreeLinkNode *root) {
        while(root)
        {
            TreeLinkNode *cur=root,*nowLeft=NULL;
            bool first=true;
            root=root->left;
            while(cur)
            {
                if(first)
                {
                    if(cur->left)
                    {
                        root=cur->left;
                        first=!first;
                    }
                    else if(cur->right)
                    {
                        root=cur->right;
                        first=!first;
                    }
                }

                if(nowLeft)
                    if(cur->left)
                        nowLeft->next=cur->left;
                    else if(cur->right)
                        nowLeft->next=cur->right;
                if(cur->left&&cur->right)
                {
                    cur->left->next=cur->right;
                    nowLeft=cur->right;
                }
                else if(cur->left&&cur->right==NULL)
                    nowLeft=cur->left;
                else if(cur->right&&cur->left==NULL)
                    nowLeft=cur->right;

                cur=cur->next;
            }
        }
    }
};

别人的思路

Just share my iterative solution with O(1) space and O(n) Time complexity

public class Solution {

    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }

            //move to next level
            cur = head;
            head = null;
            prev = null;
        }

    }
}
