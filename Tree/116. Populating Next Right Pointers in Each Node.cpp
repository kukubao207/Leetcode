116. Populating Next Right Pointers in Each Node

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
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

我的思路
层次遍历，维护两个队列，队列2的作用是延迟子节点入队
对于每一层的所有元素，每当一个节点出队1的时，子节点入队2
如果当前队列为空，说明这个节点已经是这一层的最后一个节点了，设置next=NULL
如果当前队列不为空，他next指针指向当前队头元素（下一个出队的元素就是他右侧的元素）。
这一层完成之后令队1=队2。
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
            int sz = q.size();
            for(int i=0;i<sz;i++)
            {
                root=q.front();
                q.pop();
                p.pop();
                if(!q.empty())
                    root->next=q.front();
                else
                    root->next=NULL;

                if(root->left!=NULL)
                    p.push(root->left);
                if(root->right!=NULL)
                    p.push(root->right);
            }
            q=p;
        }
    }

};

别人的思路
用了两个指针，
指针pre用来指向当前这一层的第一个元素，
指针cur用来遍历当前这一层。
cur遍历的时候会把下一层的next指针全部建立起来。
void connect(TreeLinkNode *root) {
    if (root == NULL) return;
    TreeLinkNode *pre = root;
    TreeLinkNode *cur = NULL;
    //从pre->left开始，因为root->next=NULL,是不需要处理的
    while(pre->left)
    {
        cur = pre;
        while(cur) {
            //处理当前节点的左孩子的next
            cur->left->next = cur->right;
            //处理当前节点的右孩子的next
            if(cur->next)
                cur->right->next = cur->next->left;
            //移动到下一个结点继续处理
            cur = cur->next;
        }
        //移动到下一层
        pre = pre->left;
    }
}
