769. Max Chunks To Make Sorted

Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].

我的思路
核心的想法是，每一个chunk的右边界下标是这个chunk里最大的数字。
遍历数组，每当遇到一个大于当前chunk最大值的数字，更新当前最大数字。
每当数字下标已经遍历到当前最大数字时，说明这个chunk已经结束，把当前最大数字置为0，chunk数量+1

我的代码
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int curMax = 0,count=0;;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>curMax)
                curMax=arr[i];
            if(i==curMax){
                curMax=0;
                count++;
            }   
        }
        return count;
    }
}

别人的代码
public int maxChunksToSorted(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    
    int count = 0, max = 0;
    for (int i = 0; i < arr.length; i++) {
        max = Math.max(max, arr[i]);
        if (max == i) {
            count++;
        }
    }
    
    return count;
}