974. Subarray Sums Divisible by K

Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


Note:

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000

题意
求解有多少个连续子数组，满足其和能被K整除。

解题思路
一般与连续子数组的和相关的题目，都涉及到一个数组前缀和的概念。
在本题中，也会用到前缀和。
假设sum[0,i]%K==sum[0,j]%K，且j>i，那么sum[i+1,j]一定可以被K整除。
所以我们只要针对每一个j，找出前面有多少个i满足sum[0,i]%K==sum[0,j]%K即可。
因此我们在求前缀和后，要把模值记录到hashmap中
由于存在负数情况，-1 % 5 == -1 ,因此每次求模之前对prefix+K,并对当前数模K，保证前缀模的结果一直为正整数。
针对[4 5 0 -2 -3 1]
prefix_mod_sum=4 count=0  [4,1]
prefix_mod_sum=4 count=1  [4,2]
prefix_mod_sum=4 count=3  [4,3]
prefix_mod_sum=2 count=3  [2,1]
prefix_mod_sum=4 count=6  [4,4]
prefix_mod_sum=0 count=7  [0,2]

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //mod-frequent map
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int prefix_mod_sum = 0,res = 0;
        m.put(0,1);
        for(int a:A){
            prefix_mod_sum = (prefix_mod_sum + a%K + K) % K;
            res += m.getOrDefault(prefix_mod_sum,0);
            m.put(prefix_mod_sum,m.getOrDefault(prefix_mod_sum,0)+1);
        }
        return res;
    }
}

改进思路
由于前缀和模K一定在[0,K-1]之间，我们可以把hashmap转换成一个int array
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //mod-frequent map
        int[] m = new int[K];
        m[0]=1;
        int prefix_mod_sum = 0,res = 0;
        for(int a:A){
            prefix_mod_sum = (prefix_mod_sum + a%K + K) % K;
            res += m[prefix_mod_sum];
            m[prefix_mod_sum]++;
        }
        return res;
    }
}