package Stack.medium;

import java.util.Stack;

//331. Verify Preorder Serialization of a Binary Tree
//One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
//
//     _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
//For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
//
//Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
//
//Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
//
//You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
//
//Example 1:
//
//Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//Output: true
//Example 2:
//
//Input: "1,#"
//Output: false
//Example 3:
//
//Input: "9,#,#,1"
//Output: false
public class VerifyPreorderSerializationofaBinaryTree {
    //1.使用栈，如果两个 # 连续出现，根据前序遍历的定义，前面一个一定是叶子节点，我们将这两个 # 弹出，然后将叶子节点重置为 None (即#)，如此循环下去。
    //如果满足前序遍历，那么最后栈中有且仅有一个元素，且是 # 。
    Stack<Character> stack;
    public static boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");
        for(int i = 0; i < arr.length; i++){
            stack.push(arr[i]);;
            while(stack.size() > 1 && stack.get(stack.size() - 1).equals("#")  && stack.get(stack.size() - 2).equals("#")){
                stack.pop();
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
                stack.push("#");
            }
//            System.out.println(stack);
        }
        if(stack.size() == 1 && stack.peek().equals("#"))
            return true;
        return false;
    }

    //2.遍历一边str[]
    //叶子节点数总是比非叶子节点数多一
    //如果不是"#"就会多出一个叶子结点，如果是"#"就会减少一个叶子结点
    public static boolean isValidSerialization1(String preorder) {
        int count = 1;
        String[] arr = preorder.split(",");
        for(int i = 0; i < arr.length; i++){
            if(count == 0)
                return false;
            else if(arr[i].equals("#"))
                count--;
            else if(i != arr.length - 1)
                count++;
        }
        return count == 0;
    }
    public static void main(String[] args){
       test();
    }
    public static void test(){
        String s1= "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s2= "1,#";
        String s3 = "9,#,#,1";
        System.out.println(isValidSerialization(s1));
        System.out.println(isValidSerialization(s2));
        System.out.println(isValidSerialization(s3));
    }
}
