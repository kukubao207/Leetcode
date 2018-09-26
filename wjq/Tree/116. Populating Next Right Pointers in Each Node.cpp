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

�ҵ�˼·
��α�����ά���������У�����2���������ӳ��ӽڵ����
����ÿһ�������Ԫ�أ�ÿ��һ���ڵ����1��ʱ���ӽڵ����2
�����ǰ����Ϊ�գ�˵������ڵ��Ѿ�����һ������һ���ڵ��ˣ�����next=NULL
�����ǰ���в�Ϊ�գ���nextָ��ָ��ǰ��ͷԪ�أ���һ�����ӵ�Ԫ�ؾ������Ҳ��Ԫ�أ���
��һ�����֮�����1=��2��
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

���˵�˼·
��������ָ�룬
ָ��pre����ָ��ǰ��һ��ĵ�һ��Ԫ�أ�
ָ��cur����������ǰ��һ�㡣
cur������ʱ������һ���nextָ��ȫ������������
void connect(TreeLinkNode *root) {
    if (root == NULL) return;
    TreeLinkNode *pre = root;
    TreeLinkNode *cur = NULL;
    //��pre->left��ʼ����Ϊroot->next=NULL,�ǲ���Ҫ�����
    while(pre->left)
    {
        cur = pre;
        while(cur) {
            //����ǰ�ڵ�����ӵ�next
            cur->left->next = cur->right;
            //����ǰ�ڵ���Һ��ӵ�next
            if(cur->next)
                cur->right->next = cur->next->left;
            //�ƶ�����һ������������
            cur = cur->next;
        }
        //�ƶ�����һ��
        pre = pre->left;
    }
}
