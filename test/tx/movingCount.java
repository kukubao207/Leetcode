package tx;

import java.util.Scanner;

public class movingCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int threshold = sc.nextInt();
        System.out.println(getAns(threshold,rows,cols));
    }
    private static int ansCount = 0;
    private static int getAns(int threshold, int rows, int cols)
    {
        boolean[][] vis = new boolean[rows][cols];
        dfs(0,0,rows,cols,vis,threshold);
        return ansCount;
    }
    private static void dfs(int i,int j,int rows,int columns,boolean[][] vis,int k){
        if(i<0||i>=rows||j<0||j>=columns||vis[i][j])
            return ;
        if(addAllDigits(i)+addAllDigits(j)>k)
            return ;
        ansCount++;
        vis[i][j]=true;
        dfs(i+1,j,rows,columns,vis,k);
        dfs(i,j+1,rows,columns,vis,k);
        dfs(i-1,j,rows,columns,vis,k);
        dfs(i,j-1,rows,columns,vis,k);
    }
    private static int addAllDigits(int num){
        int ans = 0;
        while(num!=0){
            ans += num%10;
            num/=10;
        }
        return ans;
    }
}
