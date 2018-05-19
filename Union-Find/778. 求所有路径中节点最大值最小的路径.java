778. Swim in Rising Water

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].

题意:
给定一个矩阵,求从左上角这个节点到右下角这个节点的所有路径中,
路径里的节点的最大值最小的一条路径.

我的思路:
这道题是一道hard题..我卡着时间点过了,也是非常nice,233333333.
首先写出朴素思路DFS  17 / 41 test cases passed.
class Solution {
    public int swimInWater(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(0,0,Integer.MIN_VALUE,grid,vis);
        return res;
    }
    int res=Integer.MAX_VALUE;
    void dfs(int i,int j,int curPathMax,int[][] grid,boolean[][] vis){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]==true)
            return;
        int temp=curPathMax;
        if(grid[i][j]>=curPathMax)
            curPathMax=grid[i][j];
        if(i==grid.length-1&&j==grid[0].length-1){
            if(curPathMax<res)
                res=curPathMax;
        }
        vis[i][j]=true;
        dfs(i+1,j,curPathMax,grid,vis);
        dfs(i,j+1,curPathMax,grid,vis);
        dfs(i-1,j,curPathMax,grid,vis);
        dfs(i,j-1,curPathMax,grid,vis);
        vis[i][j]=false;
    }
}

接着想到了DP 但是我的剪枝方法不太给力,beats 6.80% 253ms
class Solution {
    public int swimInWater(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        //类似这种问题的DP,通常是把要求的结果保存在res[][]里.
        res = new int[grid.length][grid[0].length];
        for(int i=0;i<res.length;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(0,0,Integer.MIN_VALUE,grid,vis);
        return res[grid.length-1][grid[0].length-1];
    }
    int res[][];
    void dfs(int i,int j,int curPathMax,int[][] grid,boolean[][] vis){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]==true||curPathMax>=res[i][j])
            return;
        if(grid[i][j]>=curPathMax)
            curPathMax=grid[i][j];
        if(curPathMax<res[i][j])
            res[i][j]=curPathMax;
        vis[i][j]=true;
        dfs(i+1,j,curPathMax,grid,vis);
        dfs(i,j+1,curPathMax,grid,vis);
        dfs(i-1,j,curPathMax,grid,vis);
        dfs(i,j-1,curPathMax,grid,vis);
        vis[i][j]=false;
    }
}

继续剪枝...
if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]==true||curPathMax>=res[i][j]||grid[i][j]>=res[i][j])
这样优化之后能到154ms

又看了看代码,
其实有curPathMax>=res[i][j]这个条件在,就没必要有vis[i][j]==true了,
回溯到上一层的时候,已经求过的话,就不需要再按照vis[i][j]来判断了
所以最后修改下代码 118 ms
class Solution {
    public int swimInWater(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        //类似这种问题的DP,通常是把要求的结果保存在res[][]里.
        res = new int[grid.length][grid[0].length];
        for(int i=0;i<res.length;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        dfs(0,0,Integer.MIN_VALUE,grid);
        return res[grid.length-1][grid[0].length-1];
    }
    int res[][];
    void dfs(int i,int j,int curPathMax,int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||curPathMax>=res[i][j]||grid[i][j]>=res[i][j])
            return;
        if(grid[i][j]>=curPathMax)
            curPathMax=grid[i][j];
        if(curPathMax<res[i][j])
            res[i][j]=curPathMax;
        dfs(i+1,j,curPathMax,grid);
        dfs(i,j+1,curPathMax,grid);
        dfs(i-1,j,curPathMax,grid);
        dfs(i,j-1,curPathMax,grid);
    }
}