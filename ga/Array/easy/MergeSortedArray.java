package Array.easy;

import java.util.Arrays;

//88. Merge Sorted Array
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
//        说明:
//
//        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
//        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//        示例:
//
//        输入:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        输出: [1,2,2,3,5,6]
public class MergeSortedArray {
    public static void main(String args[]){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        System.out.println(Arrays.toString(merge_two(nums1, m, nums2, n)));

    }
    //类似于插入排序，对于nums2数据，在已排序序列nums1中从后向前扫描，找到相应的位置并插入
    //时间复杂度O(n),空间复杂度O(1)
    public static int[] merge_one(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int temp = 0;
        for(int i = 0; i < n; i++){
            nums1[m + i] = nums2[i];
        }
        for(int i = m; i < length; i++){
            temp = nums1[i];
            while(i >=1 && temp < nums1[i - 1]){
                nums1[i] = nums1[i - 1];
                i--;
            }
            nums1[i] = temp;
        }
        return nums1;
    }
    //类似归并排序
    //时间复杂度O(n),空间复杂度O(n)
    public static int[] merge_two(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int p = 0;
        while(i < m && j < n){
            if(nums1[i]<nums2[j]){
                res[p++] = nums1[i++];
            }else{
                res[p++] = nums2[j++];
            }
        }
        while(i < m){
            res[p++] = nums1[i++];
        }
        while(j < n){
            res[p++] = nums2[j++];
        }
        for(int t = 0; t < m + n; t++){
            nums1[t] = res[t];
        }
        return nums1;
    }
}
