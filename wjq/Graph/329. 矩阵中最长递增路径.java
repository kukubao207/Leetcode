329. Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
[9,9,4],
[6,6,8],
[2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
[3,4,5],
[3,2,6],
[2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.


我的思路 该思路 AC 134/137 ,有4个case TLE.
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)
            return 0;
        if(matrix[0].length==0)
            return 0;
        graph=matrix;
        vis = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                for(int k=0;k<graph.length;k++)
                    Arrays.fill(vis[k],false);
                int len=dfs(i,j,Integer.MIN_VALUE);
                if(len>maxlen)
                    maxlen=len;
            }
        }
        return maxlen;
    }
    int maxlen=Integer.MIN_VALUE;
    int[][] graph;
    boolean[][] vis;
    int dfs(int x,int y,int pre){
        if(x<0 || x >= graph.length || y<0 || y >= graph[0].length)
            return 0;
        if(vis[x][y]==true)
            return 0;
        if(graph[x][y] <= pre)
            return 0;
        vis[x][y]=true;
        int length[] = new int[4];
        length[0] = 1+dfs(x+1,y,graph[x][y]);
        length[1] = 1+dfs(x,y+1,graph[x][y]);
        length[2] = 1+dfs(x-1,y,graph[x][y]);
        length[3] = 1+dfs(x,y-1,graph[x][y]);
        vis[x][y]=false;
        Arrays.sort(length);
        return length[3];
    }
}

看了别人的思路之后,进行思考.
他们是怎样想到要把这一次DFS搜索过的所有节点的(答案)给保存下来的呢?
答案就是针对某个特定的位置,该问题的答案,比如针对x=1,y=1,请你求出最长递增路径的长度.
这个小问题是非常简单的,只需要深搜就够了.

把自己想象成某个节点,要求"我"的最长递增路径长度,就会希望我周围四个节点之中的值比我大的节点告诉我,他们的最长递增路径是多少,
只要我身边的四个节点告诉我,他们的最长递增路径,那我就立马能够从他们之中挑选一个最大的,然后加上1,就是我这个位置最长递增
路径的长度了.
在这个问题里,存在子问题重叠的性质


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        graph=matrix;
        cache = new int[matrix.length][matrix[0].length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                int len=dfs(i,j,Integer.MIN_VALUE);
                if(len>maxlen)
                    maxlen=len;
            }
        }
        return maxlen;
    }
    int cache[][];
    int maxlen=Integer.MIN_VALUE;
    int[][] graph;
    int dfs(int x,int y,int pre){
        if(x<0 || x >= graph.length || y<0 || y >= graph[0].length || graph[x][y] <= pre)
            return 0;
        if(cache[x][y]!=0)
            return cache[x][y];
        int length[] = new int[4];
        length[0] = 1+dfs(x+1,y,graph[x][y]);
        length[1] = 1+dfs(x,y+1,graph[x][y]);
        length[2] = 1+dfs(x-1,y,graph[x][y]);
        length[3] = 1+dfs(x,y-1,graph[x][y]);
        Arrays.sort(length);
        cache[x][y]=length[3];
        return length[3];
    }
}
