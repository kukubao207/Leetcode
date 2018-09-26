128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

解法一:
这种思路最核心的想法在于,让连续数字串的边界保存当前串的长度消息,插入新的数字时更新边界的长度信息即可.

用HashMap存储当前连续串的长度,只存储在两个边界元素上.
比如说 对于[1,2,3,4],只要保证map.get(1)=4,map.get(4)=4就可以了,内部那些元素是多少,我管不着.
因为当我插入一个元素的时候,一定是插入到边界上的,不可能说,已经有了[1,2,3,4],我还能插入一个2,这是不科学的,是不符合题意的.
那么如何保证边界的元素能够随着插入实时更新呢?

对于插入元素i而言,判断一下i-1是否在map中存在,存在的话,说明i-1映射某个连续串的长度.
同理,判断1+1是否在map中存在,存在的话,说明i+1映射着某个连续串的长度.
这样就能够知道,插入i之后,应该更新的长度有哪几个位置了.
令left=map.get(i-1)或0,right=map.get(i+1)或0
即left表示元素i左边连续数值串的长度,right表示元素i右边连续数字串的长度.
1.更新当前插入元素的   map.put(i,left+right+1).
2.更新左边界 map.put(i-left,left+right+1).
3.更新右边界 map.put(i+right,left+right+1).

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                continue;
            //find left and right Consecutive Sequence length.
            int left=map.getOrDefault(nums[i]-1,0);
            int right=map.getOrDefault(nums[i]+1,0);
            //update the boundary
            map.put(nums[i],left+right+1);
            map.put(nums[i]-left,left+right+1);
            map.put(nums[i]+right,left+right+1);
            maxLength=Math.max(maxLength,left+right+1);
        }
        return maxLength;
    }
}
