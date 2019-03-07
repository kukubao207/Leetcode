15. 3Sum

        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]


1.先排序
2.拿出一个元素作为target
3.对剩下元素用头尾双指针法逼近target，找到一个解后，要跳过重复元素，指针从下一个不重复的开始继续找
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            int target = 0 - nums[i];
            int l = i+1, h = nums.length-1;
            while(l<h){
                if(nums[l]+nums[h]==target){
                    res.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    while(l<h&&nums[l+1]==nums[l])
                        l++;
                    while(l<h&&nums[h-1]==nums[h])
                        h--;
                    l++;
                    h--;
                }else if(nums[l]+nums[h]<target){
                    l++;
                }else{
                    h--;
                }
            }
        }
        return res;
    }
}