496. Next Greater Element I

You are given two arrays (without duplicates) nums1 and nums2 where nums1��s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

�������Ҫ�������һ�е����ֶ�Ӧ���������Ƿ�����ұ�>���������еĻ����ص�һ�������������
��ʵ������⣬����������е�ÿһ��Ԫ�أ�������Ԫ�غ����һ���������������û���򷵻�-1��
��һֱû�뵽O(n)������������һֱû��ʼ���룬���˱��˵�˼·֮��д��һ����
��Ҫ��Ҫ���ף�ʲôʱ���popԪ�ء�
�������������� 6 5 4 3 2 1 7.
��������������7������1����ô1 pop��������ǰ���ң�����ǰ�������Ԫ�ض���7С����ʱ��ǰ�������ȫ��pop���ɡ�

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
        unordered_map<int,int> biggerThan;
        stack<int> s;
        for(int n : nums)
        {
            while(!s.empty()&&s.top()<n)
            {
                biggerThan[s.top()]=n;
                s.pop();
            }
            s.push(n);
        }
        vector<int> result;
        for(int n : findNums)
            result.push_back(biggerThan.count(n)?biggerThan[n]:-1);
        return result;

    }
};


