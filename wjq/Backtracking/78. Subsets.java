Given a set of distinct integers,nums,return all possible subsets(the power set).

        Note:The solution set must not contain duplicate subsets.

        Example:

        Input:nums=[1,2,3]
        Output:
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]

        我的思路
        一道简单的模拟题
        对于【1，2，3】，想一想多一个元素和少一个元素的递推关系。
        在这道题里，很显然，多一个元素，就是把新增元素放在原先所有List的结尾，再把这些新增List加入结果集就可以了。

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempList = new ArrayList(result);
            for (List<Integer> list : tempList) {
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
}


别人的思路
//回溯法，对数组中的每一个元素，只有取或者不取，两种操作，每次取完一个数，加入templist后，要先把这个templist加入结果集。
public List<List<Integer>>subsets(int[]nums){
    List<List<Integer>>list=new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list,new ArrayList<>(),nums,0);
    return list;
}

private void backtrack(List<List<Integer>>list,List<Integer> tempList,int[]nums,int start){
    list.add(new ArrayList<>(tempList));
    for(int i=start;i<nums.length;i++) {
        tempList.add(nums[i]);
        backtrack(list,tempList,nums,i+1);
        tempList.remove(tempList.size()-1);
    }
}

如果原数组中有重复数据
public List<List<Integer>>subsetsWithDup(int[]nums) {
    List<List<Integer>>list=new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list,new ArrayList<>(),nums,0);
    return list;
}

private void backtrack(List<List<Integer>>list,List<Integer> tempList,int[]nums,int start){
    list.add(new ArrayList<>(tempList));
    for(int i=start;i<nums.length;i++){
        if(i>start&&nums[i]==nums[i-1])
            continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list,tempList,nums,i+1);
        tempList.remove(tempList.size()-1);
    }
}