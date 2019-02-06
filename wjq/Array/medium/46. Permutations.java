46. Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

思路
[[]] => [[1]] => [[1,2],[2,1]] => [[3,1,2],[1,3,2],[1,2,3],[3,2,1],[2,3,1],[2,1,3]]
代码
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n:nums){
            List<List<Integer>> temp = new ArrayList(); //temp暂存本次插入的所有结果
            for(List<Integer> list:res){
                for(int i=0;i<=list.size();i++) {
                    List<Integer> t = new ArrayList<>(list);
                    t.add(i,n);
                    temp.add(t);
                }
            }
            res = temp;
        }
        return res;
    }
}