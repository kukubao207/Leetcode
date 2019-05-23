package BackTracking;

import java.util.ArrayList;
import java.util.List;

//216. 组合总和 III
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//说明：
//
//所有数字都是正整数。
//解集不能包含重复的组合。
//示例 1:
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//示例 2:
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(k, n, res, tmp, 1);
        return res;
    }
    public void dfs(int k, int n, List<List<Integer>> res, List<Integer> tmp, int start) {
        if(tmp.size() == k && Sum(tmp) == n)
            res.add(new ArrayList<>(tmp));
        if(tmp.size() > k)
            return;
        for(int i = start; i <= 9; i++){
            tmp.add(i);
            dfs(k, n, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    public int Sum(List<Integer> tmp){
        int sum = 0;
        for(int t: tmp)
            sum = sum + t;
        return sum;
    }
}
