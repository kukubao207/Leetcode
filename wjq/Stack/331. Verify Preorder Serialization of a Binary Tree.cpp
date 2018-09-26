331. Verify Preorder Serialization of a Binary Tree

One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false



û�������ô�������˱��˵Ĵ���֮��д��һ����

class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null)
            return false;
        String []str=preorder.split(",");
        Stack<String> s=new Stack();
        for(int i=0;i<str.length;i++)
        {
            String cur=str[i];
            while(str[i].equals("#")&&!s.empty()&&s.peek().equals("#"))
            {
                s.pop();        //pop #
                if(s.empty())
                    return false;
                s.pop();        //pop num
            }
            s.push(cur);
        }
        return s.size()==1&&s.peek().equals("#");
    }
}

below is my understanding

when you iterate through the preorder traversal string, for each char:

case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack

case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.

case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack is whether # or a number:

---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.

---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree of u, and the process goes on and on.


�������ҵ����

����ǰ������ַ���ʱ������ÿ���ַ���

���1���㿴��һ������c����ʾ�㿪ʼչ��һ����cΪ�����������㽫��push����ջ����

���2.1���㿴��һ��������ջ����һ�����֣���֪�����ջ�����ֵĽ����һ������ӽڵ㣬��#����ջ�У���֪����һ���������ȷ���ӽڵ㡣

���2.2���㿴��һ����������ջ�����ǣ�����֪��������һ�����Ҷ�Ϊ�յĽ�㣬��Ҫ��#�����ֶ�pop��ȥ�� ���ȵȣ�pop֮�����������ջ�����Ƿ��ǣ�����һ�����֣�

----�����һ�����֣�����˵����֪����ո�pop�����Ԫ�أ���Ҫ��#push��ջ�У��Ը��߸���һ���Ԫ�أ�������ֽ������ȷ�ģ���#�����ˡ�

----�����һ��#����֪����ո�pop��һ�����ĸ���
