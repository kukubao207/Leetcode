77. Combinations

        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        Example:

        Input: n = 4, k = 2
        Output:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]

我的思路
回溯法
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res,cur,n,k);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> cur,int n,int k){
        if(cur.size()==k){
            List<Integer> cur_copy = new ArrayList<Integer>(cur);
            res.add(cur_copy);
            return;
        }
        for(int i=1;i<=n;i++){
            if(cur.size()>=1&&i<=cur.get(cur.size()-1))
                continue;
            cur.add(i);
            dfs(res,cur,n,k);
            cur.remove(cur.size()-1);
        }
    }
}