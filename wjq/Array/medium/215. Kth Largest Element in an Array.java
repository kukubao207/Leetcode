215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

我的思路

//找数组中第k小的元素，要结合快速排序中partition的思想，以pivot为界，把比他小的放在左边，比他大的放在右边。
//如果说左边数量刚好等于k-1，说明这个数是第k大的数咯。
//如果说左边数量小于k-1，说明第k大的数在右边咯，就从左边找
//如果说左边数量大于k-1，说明第k大的数在左边咯，
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLag(nums,0,nums.length-1,k);
    }
    //start 代表数组起始下标，end代表数组结束下标,k表示第k大的数
    public int findKthLag(int[] nums,int start,int end,int k){
        if (start > end)
            return Integer.MAX_VALUE;
        int pivot = nums[end];
        //把比pivot大的数，都交换到左边。
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, end);
        if (index - start == k - 1) {
            return nums[index];
        } else if (index - start > k - 1) {     //如果说左边多于k个元素，说明第k大的在index左边
            return findKthLag(nums, start, index - 1, k);
        } else {      //如果说左边少于k个元素，说明第k大的在index右边
            return findKthLag(nums, index + 1, end, k - (index - start) - 1);
        }
    }
    public void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

改进写法，不用递归，并分离出partition算法
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //快速排序
        return findKthSmallest(nums,nums.length-k);
    }
    public static int findKthSmallest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int onePartition = partition(nums, lo, hi);
            if (onePartition == k) {
                return nums[onePartition];
            } else if (onePartition > k) {
                hi = onePartition - 1;
            } else if (onePartition < k) {
                lo = onePartition + 1;
            }
        }
        return nums[lo];
    }
    public static int partition(int[] nums,int start, int end){
        int index = start,pivot = nums[end];
        for(int i=start;i<end;i++){
            if(nums[i]<pivot){
                int temp = nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                index++;
            }
        }
        int temp = nums[index];
        nums[index]=pivot;
        nums[end]=temp;
        return index;
    }
}