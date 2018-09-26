496. Next Greater Element I

You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

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

这道题是要求解数组一中的数字对应在数组二里，是否存在右边>它的数，有的话返回第一个比他大的数。
其实就是求解，对于数组二中的每一个元素，求出这个元素后面第一个比他大的数，若没有则返回-1。
我一直没想到O(n)的做法，所以一直没开始编码，看了别人的思路之后写了一个。
主要是要明白，什么时候该pop元素。
考虑这样的数列 6 5 4 3 2 1 7.
当我们遇到数字7，它比1大，那么1 pop，继续往前查找，发现前面的所有元素都比7小，这时候前面的数字全部pop即可。

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


