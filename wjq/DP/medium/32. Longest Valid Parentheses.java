32. Longest Valid Parentheses
        Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

        Example 1:

        Input: "(()"
        Output: 2
        Explanation: The longest valid parentheses substring is "()"
        Example 2:

        Input: ")()())"
        Output: 4
        Explanation: The longest valid parentheses substring is "()()"

思路
把不能够匹配的括号的下标记录在栈中
遍历该栈，找出相邻两个下标差的最大值。
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> idx = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                idx.push(i);
            }else{
                if(!idx.empty()){
                    if(s.charAt(idx.peek())=='('){
                        idx.pop();
                    }else{
                        idx.push(i);
                    }
                }else{
                    idx.push(i);
                }
            }
        }
        //  （（））这种测试用例
        if(idx.empty())
            return s.length();

        int max_res=0,a=s.length(),b=0;
        while(!idx.empty()){
            b=idx.peek();
            idx.pop();
            max_res = max_res>a-b-1?max_res:a-b-1;
            a=b;
        }
        // （））这种测试用例
        max_res=max_res>b?max_res:b;
        return max_res;
    }
}