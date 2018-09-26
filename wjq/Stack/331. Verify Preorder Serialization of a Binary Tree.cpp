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



没想出来怎么做，看了别人的代码之后写了一个。

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


以下是我的理解

当你前序遍历字符串时，对于每个字符：

情况1：你看到一个数字c，表示你开始展开一棵以c为根的新树，你将它push到堆栈顶部

情况2.1：你看到一个＃，而栈顶是一个数字，你知道这个栈顶数字的结点是一个左空子节点，把#推入栈中，以知道下一个结点是正确的子节点。

情况2.2：你看到一个＃，而堆栈顶部是＃，你知道碰到了一个左右都为空的结点，你要把#和数字都pop出去。 但等等，pop之后，你继续检查堆栈顶部是否是＃或者一个数字：

----如果是一个数字，比如说，你知道你刚刚pop了这个元素，需要把#push到栈中，以告诉更上一层的元素，这个数字结点是正确的，被#代替了。

----如果是一个#，你知道你刚刚pop了一棵树的根。
