package Stack.medium;

import java.util.List;
import java.util.Stack;

//385. Mini Parser
//Given a nested list of integers represented as a string, implement a parser to deserialize it.
//
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
//Note: You may assume that the string is well-formed:
//
//String is non-empty.
//String does not contain white spaces.
//String contains only digits 0-9, [, - ,, ].
//Example 1:
//
//Given s = "324",
//
//You should return a NestedInteger object which contains a single integer 324.
//Example 2:
//
//Given s = "[123,[456,[789]]]",
//
//Return a NestedInteger object containing a nested list with 2 elements:
//
//1. An integer containing value 123.
//2. A nested list containing two elements:
//    i.  An integer containing value 456.
//    ii. A nested list with one element:
//         a. An integer containing value 789.
public class MiniParser {
    //1.用栈
    //这个题目每个list里面只会有一个整数
//    public NestedInteger deserialize(String s) {
//        if(s.isEmpty()) return new NestedInteger();
//        if(s.charAt(0) != '[')  return new NestedInteger(Integer.parseInt(s));
//        if(s.length() <= 2) return new NestedInteger();
//        NestedInteger res = new NestedInteger();
//        int start = 1,cnt = 0;
//        for(int i = 1; i < s.length(); i++){
//            if(cnt == 0 && (s.charAt(i) == ',' || i == s.length() - 1)){
//                res.add(deserialize(s.substring(start, i)));
//                start = i + 1;
//            }
//            else if(s.charAt(i) == '[') cnt++;
//            else if(s.charAt(i) == ']') cnt--;
//        }
//        return res;
//    }
//    public interface NestedInteger {
//        // Constructor initializes an empty nested list.
//        public NestedInteger();
//        // Constructor initializes a single integer.
//        public NestedInteger(int value);
//        // @return true if this NestedInteger holds a single integer, rather than a nested list.
//        public boolean isInteger();
//        // @return the single integer that this NestedInteger holds, if it holds a single integer
//        // Return null if this NestedInteger holds a nested list
//        public Integer getInteger();
//        // Set this NestedInteger to hold a single integer.
//        public void setInteger(int value);
//        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//        public void add(NestedInteger ni);
//        // @return the nested list that this NestedInteger holds, if it holds a nested list
//        // Return null if this NestedInteger holds a single integer
//        public List<NestedInteger> getList();
//    }
}
