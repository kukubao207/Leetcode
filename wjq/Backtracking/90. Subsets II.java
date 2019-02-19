90. Subsets II

        Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:

        Input: [1,2,2]
        Output:
        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subsets(res,temp,nums,vis,0);
        return res;
    }
    public void subsets(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] vis,int start){
        res.add(new ArrayList<Integer>(temp));
        for(int i=start;i<nums.length;i++){
            if(vis[i]==true||(i-1>=0&&vis[i-1]==false&&nums[i]==nums[i-1])||(temp.size()>0&&nums[i]<temp.get(temp.size()-1)))
                continue;
            temp.add(nums[i]);
            vis[i]=true;
            subsets(res,temp,nums,vis,start+1);
            vis[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}

别人的思路
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subsets(res,temp,nums,0);
        return res;
    }
    public void subsets(List<List<Integer>> res,List<Integer> temp,int[] nums,int start){
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1])
                continue;
            temp.add(nums[i]);
            subsets(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}