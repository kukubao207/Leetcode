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


����
����һ�����У�Ҫ���ҳ��������Ƿ���� i < j < k and ai < ak < aj �����������С�

����˼·
�����е��ұ߿�ʼ������ά��һ���ݼ�ջ��һ������ջ��
ÿ������һ��Ԫ�أ��Ƚ����͵�ǰ�ݼ�ջ�е�ֵ���ѱȸ�Ԫ��С������Ԫ�ض�pop��������Щ��pop������Ԫ�أ�
�������ջ��ջ��Ԫ�ؽ��бȽϣ�����ȵ���ջ�е�Ԫ�ش���ô�����Ԫ��ѹ�����ջ��
ÿ������һ��Ԫ�أ������������ջ��ջ��Ԫ�أ�����ǰ���ֵ���Ƚϣ������������ֵС����ô˵�����Ԫ�ؿ��Գ�Ϊs1��

�������Ϊ���Ѿ�����ݼ�ջ�е�Ԫ��Ϊs2������s2���ݼ�ջʱpop��ȥ����ЩԪ����s3�����Ա�֤����һ���Ǳ�s2С�ģ�
��ô����ȡ��Щs3������һ���������ͼ�������ݼ�ջ��s1���бȽϣ�һ��s1��s3С���ǿ϶��ʹ���s1<s3<s2�������ˡ�

class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        //ά��һ�������ݼ�ջ�͵�������ջ
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

���е����
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
��û���õ���ջ����Ϊ�ڵݼ�ջ��ջ���ͼ��������Ԫ�رȽ�ʱ�����һ����pop���ݼ�ջ��Ԫ��һ�������ġ�����
��ʱ��ֱ�Ӹ�ֵ��s3���ɡ�����
