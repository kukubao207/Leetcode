954. Array of Doubled Pairs

Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

Example 1:

Input: [3,1,3,6]
Output: false
Example 2:

Input: [2,1,2,6]
Output: false
Example 3:

Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: [1,2,4,16,8,4]
Output: false

Note:

0 <= A.length <= 30000
A.length is even
-100000 <= A[i] <= 100000



题意要求我们判断一个数组中的所有元素是否能组成half length个(x,2x)的对。
思路
先对数组进行排序，是需要考虑负数情况的。
那么绝对值大的数字先被我们遍历到
1) 对数组排序，并构造hashmap统计每个元素出现次数。
2) 遍历数组，（前提是当前元素计数不为0），找出当前元素的匹配元素。
    2.1如果当前元素是负数，目标元素就是 x/2，因为绝对值大的负数先被我们遍历到。（考虑-7这种特殊情况，直接返回false）
    2.2如果当前元素是正数，目标元素就是 x*2
3）从hashmap中查找目标元素的个数
    如果目标元素个数大于等于当前元素个数，说明当前的x能够被匹配完，那就更新目标元素和当前元素的计数。
    如果小于当前元素个数，说明当前x不能被匹配完，直接返回false。

class Solution {
    public boolean canReorderDoubled(int[] A) {
        if(A.length==0)
            return true;
        Arrays.sort(A);
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<A.length;i++){
            hashmap.put(A[i],hashmap.getOrDefault(A[i],0)+1);
        }
        for(int i=0;i<A.length;i++){
            if(hashmap.getOrDefault(A[i],0)==0)
                continue;
            if(A[i]<0&&A[i]%2!=0)
                return false;
            int target = A[i]>0 ? A[i]*2 : A[i]/2;
            int cur = hashmap.getOrDefault(A[i],0);
            int count = hashmap.getOrDefault(target,0);
            if(cur>count){
                return false;
            }else{
                hashmap.put(target,count-cur);
                hashmap.put(A[i],0);
            }
        }
        return true;
    }
}