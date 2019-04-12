package tx;
import java.util.*;

public class tx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] cap = new int[2*n];
        for(int i=0;i<2*n;i++)
            cap[i]=sc.nextInt();
        Arrays.sort(cap);
        int girl_minest = cap[0];
        int boy_minest = cap[n];

        double every_weight = 0;
        if(boy_minest>=2*girl_minest){
            every_weight = (double)girl_minest;
        }else{
            every_weight = (double)boy_minest / 2;
        }
        double res = Math.min(every_weight*n + 2*every_weight*n,w);
        System.out.println(String.format("%.6f", res));
    }

}
