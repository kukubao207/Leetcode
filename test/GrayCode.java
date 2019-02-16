import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args){
        int n=3;
        grayCode(n);
        grayCode2(n);
    }
    public static List<Integer> grayCode(int n) {
        if(n==0)
            return new ArrayList<Integer>(0);
        int[] num = new int[n];
        boolean[] vis = new boolean[1<<n];
        vis[0]=true;
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
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

    public static List<Integer> grayCode2(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--) {
                int left = rs.get(k);
                int right = 1 << i;
                int mid = left | right;
                rs.add(mid);
            }
        }
        return rs;
    }
}
