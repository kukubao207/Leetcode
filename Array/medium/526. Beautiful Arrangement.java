526. Beautiful Arrangement

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

题意
给出一个整数N，把1-N安排成一个序列，使得这个序列变得漂亮。
漂亮序列的定义，对于序列中的每一个元素，要么元素能整除下标，要么下标能整除元素。

思路
通过DFS算法，求解每一个位置能放的元素，在一个位置放下元素，就标记放下元素已被访问过，回溯时，标记该元素未访问过。

class Solution {
    public int countArrangement(int N) {
        boolean vis[] = new boolean[N+1];
        dfs(1,N,vis);
        return ans;
    }
    int ans=0;
    void dfs(int pos,int N,boolean[] vis){
        if(pos>N){
            ans++;
            return;
        }
        for(int i=1;i<=N;i++){
            if(vis[i]==true)
                continue;
            if(i%pos==0||pos%i==0)
            {
                vis[i]=true;
                dfs(pos+1,N,vis);
                vis[i]=false;
            }
        }
    }
}