4. Median of Two Sorted Arrays

        There are two sorted arrays nums1 and nums2 of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

        You may assume nums1 and nums2 cannot be both empty.

        Example 1:

        nums1 = [1, 3]
        nums2 = [2]

        The median is 2.0
        Example 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        The median is (2 + 3)/2 = 2.5


对于  偶数个
        1，2
        3，4
那么要找到 第2大 和 第3大的元素 /2
两个数组中第2大的元素怎么找？

令k=2

从数组A [0,k/2-1] 和 B 的[0,k/2-1]一共有  k个元素
        A[k/2-1]是  0 ~ k/2-1中最大的那个元素
        B[k/2-1]是  0 ~ k/2-1中最大的那个元素
若 A[k/2-1] > B[k/2-1]
这说明  B[k/2-1]一定不是第k大的，最多是第k-1大的元素。

因此，我们可以把 B数组中 [0,k/2-1]的元素全部删除掉。继续递归搜索

递归的结束条件：
1.数组1为空
2.k==1，只要返回 num1[s1]和num2[s2]中较小的那个就可以了

时间复杂度分析：
由于 k总是以 k/2 的速率收缩，最坏条件下
k       -> k/2     -> k/4   -> k/8   -> 1
k / 2^0 -> k / 2^1 -> K/2^2 -> K/2^3 -> k / 2 ^ log2 k
显然需要 log2 k次，算法时间复杂度为 O(logk)

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if((m+n)%2==1){
            return findKth(nums1,0,nums2,0,(m+n)/2+1);
        }else{
            double ans1 = findKth(nums1,0,nums2,0,(m+n)/2);
            double ans2 = findKth(nums1,0,nums2,0,(m+n)/2+1);
            return (ans1+ans2) / 2;
        }
    }

    //s1为nums1起始下标,s2为nums2起始下标
    public double findKth(int[] nums1,int s1,int nums2[],int s2,int k){
        //nums1 剩余元素个数  > nums2剩余元素个数
        if(nums1.length-s1>nums2.length-s2)
            return (double)findKth(nums2,s2,nums1,s1,k);
        //nums1数组为空
        if(nums1.length==s1)
            return (double)nums2[s2+k-1];
        if(k==1)
            return (double)Math.min(nums1[s1],nums2[s2]);

        int pa = Math.min(s1+k/2-1,nums1.length-1);
        int pb = Math.min(s2+k/2-1,nums2.length-1);
        if(nums1[pa]<nums2[pb]){
            return (double)findKth(nums1,pa+1,nums2,s2,k-(pa-s1+1));
        }else {
            return (double)findKth(nums2,pb+1,nums1,s1,k-(pb-s2+1));
        }
    }
}