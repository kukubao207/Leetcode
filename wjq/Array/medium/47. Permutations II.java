47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
[1,1,2],
[1,2,1],
[2,1,1]
]

[[]] => [[1]] => [[1,1]] => []
如果插入后，如果得到的数组已经出现过，就不要再插入到res中了
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n:nums){
            List<List<Integer>> temp = new ArrayList(); //temp暂存本次插入的所有结果
            Set<String> set = new HashSet<>();
            for(List<Integer> list:res){
                for(int i=0;i<=list.size();i++) {
                    List<Integer> t = new ArrayList<>(list);
                    t.add(i,n);
                    if(!set.contains(t.toString()))
                        temp.add(t);
                    set.add(t.toString());
                }
            }
            res = temp;
        }
        return res;
    }
}
