public class Median {
    public static void main(String[] args){
        int[] nums1 = {4,5};
        int[] nums2 = {1,2,3,6};
        double ans = Solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }
    public static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        public static double findKth(int[] nums1,int s1,int nums2[],int s2,int k){
            //nums1 剩余元素个数  > nums2剩余元素个数
            if(nums1.length-s1>nums2.length-s2)
                return (double)findKth(nums2,s2,nums1,s1,k);
            //nums1 起始下标大于等于长度
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
}

