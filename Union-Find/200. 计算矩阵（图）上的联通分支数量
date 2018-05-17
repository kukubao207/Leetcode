200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3


class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        graph=grid;
        vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<graph.length;i++){
            Arrays.fill(vis[i],false);
        }
        int count=0;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j]=='1'&&vis[i][j]==false){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    boolean vis[][];
    char graph[][];
    void dfs(int x,int y){
        if(x<0||y<0||x>=graph.length||y>=graph[0].length||graph[x][y]=='0'||vis[x][y]==true)
            return;
        vis[x][y]=true;
        dfs(x+1,y);
        dfs(x,y+1);
        dfs(x-1,y);
        dfs(x,y-1);
    }
}