package Greedy.hard;

//330. Patching Array
//Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
//
//Example 1:
//
//Input: nums = [1,3], n = 6
//Output: 1
//Explanation:
//Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
//Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
//Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
//So we only need 1 patch.
//Example 2:
//
//Input: nums = [1,5,10], n = 20
//Output: 2
//Explanation: The two patches can be [2, 4].
//Example 3:
//
//Input: nums = [1,2,2], n = 5
//Output: 0
//Accepted
//32,060
//Submissions
//95,622
public class PatchingArray {
    public static void main(String[] args) {
        test();
    }
    //贪心算法：
    //初始化区间 [1, miss) = [1, 1) = 空——表示已经覆盖的空间为[1, miss),miss为未覆盖的数字中的最小的数字
    //（为了覆盖miss，我们新增的数x一定要小于等于miss，为了使覆盖的范围更广，新增的数越大越好，即等于miss）
    //每当 n 没有被覆盖
        //若当前元素 nums[i] 小于等于 miss
            //将范围扩展到 [1, miss + nums[i])
            //将 i 增加 1
        //否则
            //将 miss 添加到数组，将范围扩展到 [1, miss + miss)
            //增加数字的计数
    //返回增加数字的数目
    public static int minPatches(int[] nums, int n) {
        int i= 0;//遍历nums数组
        int patches = 0;//增加数字的数目
        long miss = 1;
        while(miss <= n){//当还没覆盖完全
            if(i < nums.length && nums[i] <= miss)//miss被nums数组覆盖
                miss = miss + nums[i++];//nums数组不能重复使用
            else{//需要新增数字
                miss = miss + miss;
                patches++;
            }
        }
        return patches;
    }
    public static void test(){
        int[] nums1 = new int[]{1, 3};
        int n1 = 6;
        int[] nums2 = new int[]{1, 5, 10};
        int n2 = 20;
        int[] nums3 = new int[]{1, 2, 2};
        int n3 = 5;
        System.out.println(minPatches(nums1, n1));
        System.out.println(minPatches(nums2, n2));
        System.out.println(minPatches(nums3, n3));

    }
}
