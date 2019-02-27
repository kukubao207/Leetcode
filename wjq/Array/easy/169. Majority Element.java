169. Majority Element

        Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

        You may assume that the array is non-empty and the majority element always exist in the array.

        Example 1:

        Input: [3,2,3]
        Output: 3
        Example 2:

        Input: [2,2,1,1,1,2,2]
        Output: 2

题意
找出数组中出现次数大于一半的数

我的思路 O(nlogn)
排序
返回nums[nums.length/2]

摩尔投票思路 O(n)时间 O(1)空间
该算法基于这样一个事实
把数组中不相同的两个数不断抵消（删除），最后数组中剩下的元素就是大于数组长度一半的元素
一个较好的实现是基于  两个变量
一个变量跟踪当前 major元素，一个变量跟踪major元素的计数
若计数为0，代表当前刚好抵消，可以把major置为nums[i],count计数置为1
每当遇到一个相同的，major元素计数+1，遇到不同的，major元素计数-1

class Solution {
    public int majorityElement(int[] nums) {
        int major=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                major=nums[i];
                count=1;
            }
            else if(nums[i]==major){
                count++;
            }else if(nums[i]!=major){
                count--;
            }
        }
        return major;
    }
}