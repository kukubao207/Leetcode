658. Find K Closest Elements
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

题意
给出一个数组，k，x。
要求找出该数组中长度为k的一段连续子数组，使这个连续子数组与x的距离最小。
距离是指，每一个元素与x做差后相加得到的值。
如果有多个不同的解，选择下标的解。

头尾双指针法：
看头尾元素哪个距离x大，删去距离x更大的那个元素。

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-1;
        while(right-left>=k){
            if(Math.abs(x-arr[right]) >= Math.abs(x-arr[left]))
                right--;
            else
                left++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left;i<=right;i++){
            res.add(arr[i]);
        }
        return res;
    }
}

二分查找法
