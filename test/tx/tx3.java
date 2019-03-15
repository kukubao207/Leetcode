package tx;

import java.util.*;

public class tx3 {
    public static class A{
        int dist,value;
        A(int dist,int value){
            this.dist=dist;
            this.value = value;
        }
    }
    public static class mycmp implements Comparator<A> {
        @Override
        public int compare(A a1,A a2){
            if(a1.dist>a2.dist){
                return 1;
            }else if(a1.dist<a2.dist){
                return -1;
            }else
                return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] dist = new int[n];
        int[] value = new int[n];
        A[] alist = new A[n];
        for (int i = 0; i < n; i++) {
            dist[i] = sc.nextInt();
            value[i] = sc.nextInt();
            alist[i] = new A(dist[i],value[i]);
        }
        Arrays.sort(alist,new mycmp());
        for(int i=0;i<n;i++){
            dist[i]=alist[i].dist;
            value[i]=alist[i].value;
        }
        int[] dp = new int[n];

        int res = rob(value, dist, d);
        System.out.println(res);
    }

    public static int rob(int[] num, int[] dist, int d) {
        int[][] dp = new int[num.length + 1][2];
        Map<Integer,Integer> m = new HashMap<>();
        for(int i= 0;i<num.length;i++){

        }
        for (int i = 1; i <= num.length; i++) {
            //System.out.println(dist[i-1]+ " " +num[i-1]);
            int j = i - 1;
            for (; j >= 0; j--) {
                if (dist[i - 1] - dist[j] > d)
                    break;
            }
            //System.out.println("找到前一个可以偷的下标为"+j);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (j != -1) {
                dp[i][1] = num[i - 1] + Math.max(dp[j+1][0], dp[j+1][1]);
            } else {
                dp[i][1] = num[i - 1];
            }
        }
//        for(int i=1;i<=num.length;i++){
//            System.out.println("dist="+dist[i-1]+" value="+num[i-1]+" 不偷="+dp[i][0]+" 偷="+dp[i][1]);
//        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }

//    5 1
//            1 2
//            2 7
//            3 9
//            4 3
//            5 1
}
