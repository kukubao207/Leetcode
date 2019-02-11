public class UniquePath {
    public static void main(String[] args){
        int[][] ob ={{0}};
        Solution.uniquePathsWithObstacles(ob);
    }
    public static class Solution {
        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int result = dfs(0,0,obstacleGrid);
            return result;
        }
        public static int dfs(int i,int j,int[][] ob){
            if(i>=ob.length||j>=ob[0].length||ob[i][j]==1)
                return 0;
            if(i==ob.length-1&&j==ob[0].length-1){
                return 1;
            }
            return dfs(i+1,j,ob) + dfs(i,j+1,ob);
        }
    }
}
