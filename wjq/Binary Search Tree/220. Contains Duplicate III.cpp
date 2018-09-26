220. Contains Duplicate III
Given an array of integers, find out whether there are two distinct indices i and j in the array
such that the absolute difference between nums[i] and nums[j] is at most t and the absolute
difference between i and j is at most k.

题意
在给定的数组中，找出满足 nums[i]-nums[j]<=t 同时 i-j<=k 的一对元素，能找到返回true，否则返回false

思路
维护一个大小为k的window，类型为set（因为set默认升序排序且没有重复元素）。
移动这个window，直到window到数组末尾，
    在元素nums[i]加入这个window之前判断
    是否能在window中找到一个数字x满足 |x-nums[i]|<=t
    即x-nums[i]<=-t && x-nums[i]<=t
    即nums[i]-t<=x  && x-nums[i]<=t
    首先对于nums[i]-t ，我们只要在window中找到第一个比nums[i]-t大的元素即可（由于默认升序）。

代码
class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        set<long long> window;
        for(int i=0;i<nums.size();i++)
        {
            if(i>k&&i-k-1<nums.size())
                window.erase(nums[i-k-1]);
            //|x-nums[i]|<=t   ==>     x-nums[i] >= -t  &&  x-nums[i] <= t

            //x-nums[i] >= -t  ==>  nums[i]-t <= x 在window找到第一个比nums[i]-t大的数即可
            auto it = window.lower_bound((long long)nums[i]-t);

            //保证找到的数满足公式 x-num[i] <=t
            if(it != window.end() && (*it-nums[i]) <= t)
                return true;

            window.insert(nums[i]);
        }
        return false;


    }
};
