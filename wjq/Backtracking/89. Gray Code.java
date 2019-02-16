89. Gray Code
        The gray code is a binary numeral system where two successive values differ in only one bit.

        Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

        Example 1:

        Input: 2
        Output: [0,1,3,2]
        Explanation:
        00 - 0
        01 - 1
        11 - 3
        10 - 2

        For a given n, a gray code sequence may not be uniquely defined.
        For example, [0,2,3,1] is also a valid gray code sequence.

        00 - 0
        10 - 2
        11 - 3
        01 - 1
        Example 2:

        Input: 0
        Output: [0]
        Explanation: We define the gray code sequence to begin with 0.
        A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
        Therefore, for n = 0 the gray code sequence is [0].

我的思路
回溯法
class Solution {
    public List<Integer> grayCode(int n) {

        int[] num = new int[n];
        boolean[] vis = new boolean[1<<n];
        vis[0]=true;
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        if(n==0)
            return temp;
        res = dfs(num,res,temp,vis);
        return res;
    }
    public static List<Integer> dfs(int[] num, List<Integer>res, List<Integer> temp,boolean[] vis){
        if(temp.size()==1<<num.length){
            res = new ArrayList<>(temp);
            return res;
        }

        for(int i=0;i<num.length;i++){
            num[i]= num[i]==0?1:0;
            int t = b2D(num);
            if(vis[t]) {
                num[i]= num[i]==0?1:0;
                continue;
            }
            vis[t]=true;
            temp.add(t);
            res = dfs(num,res,temp,vis);
            if(res.size()==1<<num.length)
                return res;
            temp.remove(temp.size()-1);
            vis[t]=false;
            num[i]= num[i]==0?1:0;
        }
        return res;
    }
    public static int b2D(int[] num){
        int result=0;
        for(int i=num.length-1,mul=1;i>=0;i--){
            result+=num[i]*mul;
            mul*=2;
        }
        return result;
    }
}


正解

00 01 11 10 =>  (000 001 011 010) (110 111 101 100)

n的格雷码是由n-1的格雷码生成的
n=2的格雷码是 00 01 11 10   (也就相当于 000 001 011 010,在左方补0不影响十进制的值)
那么n=3的格雷码就是在n=2的基础上， 逆序遍历n=2的格雷码，并对每一个格雷码最左侧补1，然后插入数组即可
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i=0;i<n;i++){
            int size = res.size();
            for(int j=size-1;j>=0;j--){
                int left = res.get(j);
                int right = 1<<i;
                int addNum = left | right;
                res.add(addNum);
            }
        }
        return res;
    }
}