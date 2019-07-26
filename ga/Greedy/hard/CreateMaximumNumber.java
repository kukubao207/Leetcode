package Greedy.hard;
// 321. Create Maximum Number
//Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
//
//Note: You should try to optimize your time and space complexity.
//
//Example 1:
//
//Input:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//Output:
//[9, 8, 6, 5, 3]
//Example 2:
//
//Input:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//Output:
//[6, 7, 6, 0, 4]
//Example 3:
//
//Input:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//Output:
//[9, 8, 9]
public class CreateMaximumNumber {
    //采用分治法的思路，我们知道这K个数字中，必然有i个数组来自nums1，而剩下的k-i个数字必然来自nums2。
    // 那么问题变成从nums1中获取i个数，这i个数构成的数字最大，且这i个数字的相对位置不变。再从nums2中获取k-i个数，这k-i个数构成的数字最大，且这k-i个数字的相对位置不变。
    //如何将这两个结果合并起来获得最终的结果呢？这里很像归并算法的merge过程，我们从两个数组的开头获取最大的值加进来呗。那如果出现相同的值怎么办？那么继续比较，直到遇到第一个不相同的数字，然后选择数字较大的那个数组。

    /*
    假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
    组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
    Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
    */
    //时间复杂度O（n*n*n）
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int m = nums1.length; int n = nums2.length;
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxNum(nums1, i), maxNum(nums2, k - i), k);
            if(greater(arr, 0, res, 0))
                res = arr;
        }
        return res;
    }
    //数组nums中选择k个元素 组成最大的组合
    /*
    假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3];
    n - i : 当前数组中,当前下标到结尾还有多少个元素;
    j : 当前数组中i之前有多少个数加入到最大组合中;
    n - i + j > k <=> n - i - 1 + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--,
    n - i(数组剩余元素) - 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k;
    if j < k : 先将最大组合填满再进行比较替换操作
    */
    public int[] maxNum(int[] nums, int k) {
        int[] res = new int[k];
        int n = nums.length;
        for(int i = 0, j = 0; i < n; i++) {
            //当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--
            while (n - i + j > k && j > 0 && nums[i] > res[j - 1]) j--;
            if(j < k) res[j++] = nums[i];
        }
        return res;
    }

    // 假设数组一最大组合为[6,5],数组二最大组合为[9,8,3],进行双指针排序,排序后为[9,8,6,5,3]
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, t = 0; t < k; t++){
            res[t] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    //比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
    //如果前面的数字相等 比较后面的数字
    //true表示nums1大
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
