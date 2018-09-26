385. Mini Parser

Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.


思路和代码
Solution in a Glance:
This solution uses a stack to record the NestedInteger’s.
At the very beginning, an empty NestedInteger is placed in the stack. This NestedInteger will be regarded as a list that holds one but only one NestedInteger, which will be returned in the end.
Logic:
    When encountering number, push the number into the NestedInteger who is in the top of stack.
    When encountering ‘[’, the stack has one more element.
    When encountering ‘]’, the stack has one less element.

Complexities:

Time: O(n)
Space: worse-case O(n) (worse case: [1,[2,[3,[…[n-1,[n]]]…])
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
public:
    NestedInteger deserialize(string s) {
        stack<NestedInteger> st;
        st.push(NestedInteger());
        for(int i=0;i<s.length();i++)
        {
            if(isdigit(s[i])||s[i]=='-')
            {
                int sign=1;
                if(s[i]=='-')
                {
                    sign=-1;
                    i++;
                }
                int num=0;
                while(isdigit(s[i])&&i<s.length())
                {
                    num=num*10+s[i]-'0';
                    i++;
                }
                i--;
                num=sign*num;
                st.top().add(NestedInteger(num));
            }
            else
            {
                if(s[i]=='[')
                    st.push(NestedInteger());
                else if(s[i]==']')
                {
                    NestedInteger ni = st.top();
                    st.pop();
                    st.top().add(ni);
                }
            }

        }
        return st.top().getList().front();
    }
};
