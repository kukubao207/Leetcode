
public class StringMatch {
    public static void main(String args[]) {
        int[] A = {3, 2, 1, 5, 6, 3};
        int k = 2;
        String a=".....";
        quickSort(A,0,A.length-1);
        System.out.println(k);
        System.out.println(a);
        //int ans = findKthLargest(A, k);
        //int ans2 = partition2(A,0,5);
    }

    public static int findKthLargest(int[] nums, int k) {
        //快速排序
//        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
        return findKthSmallest(nums, nums.length - k);
    }

    //递归
    public static int findKthSmallest(int[] nums, int start, int end, int k) {
        int onePartition = partition(nums, start, end);
        if (onePartition == k) {
            return nums[onePartition];
        } else if (onePartition > k) {
            return findKthSmallest(nums, start, onePartition - 1, k);
        } else {
            return findKthSmallest(nums, onePartition + 1, end, k);
        }
    }

    //迭代
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

    public static int partition(int[] nums, int start, int end) {
        int index = start, pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        int temp = nums[index];
        nums[index] = pivot;
        nums[end] = temp;
        return index;
    }

    //递归写法
    public static void quickSort(int[] nums, int start, int end) {
        if (start > end)
            return;
        int index = partition(nums, start, end);
        quickSort(nums,start,index-1);
        quickSort(nums,index+1,end);
    }

    //迭代写法
    public static void quickSort2(int[] nums, int start, int end){
        int lo=start,hi=end;
        while(lo<hi){
            partition(nums,lo,hi);
        }
    }
}