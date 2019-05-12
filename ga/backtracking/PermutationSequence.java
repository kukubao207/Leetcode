package backtracking;

import java.util.ArrayList;
import java.util.List;

//60. backtracking Sequence (第k个排列)
//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
//
//按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//给定 n 和 k，返回第 k 个排列。
//
//说明：
//
//给定 n 的范围是 [1, 9]。
//给定 k 的范围是[1,  n!]。
//示例 1:
//
//输入: n = 3, k = 3
//输出: "213"
//示例 2:
//
//输入: n = 4, k = 9
//输出: "2314"
public class PermutationSequence {
    public static void main(String args[]){
        int n = 4;
        int k = 9;
        System.out.println(getPermutation1(n, k));
    }
    //全排列，到第k个排列终止(超时)
    public static String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        String tmp = "";
        int[] nums = new int[n];
        int j = 1;
        for(int i = 0; i < n; i++){
            nums[i] = j;
            j++;
        }
        k_fullPermutation(res, tmp, nums,k);
        return res.get(k - 1);
    }

    public static void k_fullPermutation(List<String> res, String tmp, int[] nums,int k){
        if (res.size() > k)
            return;
        if(tmp.length() == nums.length){
            res.add(tmp);
        }
        else if(tmp.length() > nums.length){
            return;
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if (res.size() > k)
                    break;
                if(!tmp.contains(""+ nums[i])){//去掉重复数
                    tmp = tmp + nums[i];
                    k_fullPermutation(res, tmp, nums,k);
                    tmp = tmp.substring(0,tmp.length() - 1);
                }
            }
        }
    }

/*可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
        算出来, 对于n=4, k=15 找到k=15排列的过程:

        1 + 对2,3,4的全排列 (3!个)
        2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
        3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
        4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

        确定第一位:
            k = 14(从0开始计数)
            index = k / (n-1)! = 2, 说明第15个数的第一位是3
            更新k
            k = k - index*(n-1)! = 2
        确定第二位:
            k = 2
            index = k / (n-2)! = 1, 说明第15个数的第二位是2
            更新k
            k = k - index*(n-2)! = 0
        确定第三位:
            k = 0
            index = k / (n-3)! = 0, 说明第15个数的第三位是1
            更新k
            k = k - index*(n-3)! = 0
        确定第四位:
            k = 0
            index = k / (n-4)! = 0, 说明第15个数的第四位是4
        最终确定n=4时第15个数为3214
        **/

    public static String getPermutation1(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 分母的阶乘数
        int[] factorials = new int[n + 1];//还剩i个数字的组合数
        factorials[0] = 1;
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i <= n; i++){
            candidates.add(i);
            fact = fact * i;
            factorials[i] = fact;
        }
        k = k - 1;
        for(int i = n - 1; i >= 0; i--){
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k = k - index * factorials[i];
        }
        return sb.toString();
    }


}
