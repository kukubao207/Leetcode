456. 132 Pattern

Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].


题意
给定一个序列，要求找出序列中是否存在 i < j < k and ai < ak < aj 这样的子序列。

解题思路
从序列的右边开始搜索，维持一个递减栈和一个递增栈。
每当遇到一个元素，比较他和当前递减栈中的值，把比该元素小的所有元素都pop出来，这些被pop出来的元素，
都与递增栈的栈顶元素进行比较，如果比递增栈中的元素大，那么把这个元素压入递增栈。
每当遇到一个元素，都把他与递增栈的栈顶元素（即当前最大值）比较，如果比这个最大值小，那么说明这个元素可以成为s1。

可以理解为，已经进入递减栈中的元素为s2，而被s2进递减栈时pop出去的这些元素是s3，可以保证他们一定是比s2小的，
那么我们取这些s3中最大的一个，用来和即将进入递减栈的s1进行比较，一旦s1比s3小，那肯定就存在s1<s3<s2的序列了。

class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        //维护一个单调递减栈和单调递增栈
        stack<int> s2,maxStack;
        for(int i=nums.size()-1;i>=0;i--)
        {
            if(!maxStack.empty()&&nums[i]<maxStack.top())
                return true;
            while(!s2.empty()&&s2.top()<nums[i])
            {
                if(maxStack.empty()||s2.top()>maxStack.top())
                    maxStack.push(s2.top());
                s2.pop();
            }
            s2.push(nums[i]);
        }
        return false;
    }
};

大佬的题解
bool find132pattern(vector<int>& nums) {
    int s3 = INT_MIN;
    stack<int> st;
    for( int i = nums.size()-1; i >= 0; i -- ){
        if( nums[i] < s3 ) return true;
        else while( !st.empty() && nums[i] > st.top() ){
          s3 = st.top(); st.pop();
        }
        st.push(nums[i]);
    }
    return false;
}
他没有用递增栈，因为在递减栈的栈顶和即将进入的元素比较时，最后一个被pop出递减栈的元素一定是最大的。。。
这时候直接赋值给s3即可。。。
