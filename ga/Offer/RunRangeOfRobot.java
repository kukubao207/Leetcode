package Offer;

/**机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RunRangeOfRobot {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0)
            return 0;
        int[][] vis = new int[rows][cols];
        dfs(threshold, 0, 0, rows, cols, vis);
        return count;
    }
    int count = 0;
    public void dfs(int k, int i, int j, int rows, int cols, int[][] vis){
        if(vis[i][j] == 1 || Compute(i, j) > k)
            return;
        if(vis[i][j] == 0 && Compute(i, j) <= k){
            vis[i][j] = 1;
            count++;
        }
        if(i - 1 >= 0)
            dfs(k, i - 1, j, rows, cols, vis);
        if(i + 1 < rows)
            dfs(k, i + 1, j, rows, cols, vis);
        if(j - 1 >= 0)
            dfs(k, i, j - 1, rows, cols, vis);
        if(j + 1 < cols)
            dfs(k, i, j + 1, rows, cols, vis);
    }
    public int Compute(int i, int j){
        int sum = 0;
        while(i != 0){
            int n = i % 10;
            sum += n;
            i /= 10;
        }
        while(j != 0){
            int n = j % 10;
            sum += n;
            j /= 10;
        }
        return sum;
    }
}
