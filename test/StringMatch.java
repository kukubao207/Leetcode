import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringMatch {
    public static void main(String args[]) {
        //String []origin = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        //String []origin = {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
        int[] A = {7,-15,-15,23,-3,80,-35,40,68,22,44,98,20,0,-34,8,40,41,16,46,16,49,-6,-11,35,-15,-74,72,-8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,82,-30,50,22,25,16,70,-1,-96,11,45,54,40,92,-35,29,80,46,-30,27,7,-70,-37,41,-46,-98,1,-33,-24,-86,-70,80,-43,98,-49,30,0,27,2,82,36,0,-48,3,-100,58,32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30};
        //int[] B = {1, 10, 4, 11};
        canReorderDoubled(A);
        //System.out.println(C);
    }

    public static boolean canReorderDoubled(int[] A) {
        if(A.length==0)
            return true;
        boolean vis[] = new boolean[A.length];
        for(int i=0;i<vis.length;i++)
            vis[i]=false;
        for(int i=0;i<A.length;i++){
            if(vis[i])
                continue;
            for(int j=0;j<A.length;j++){
                if(vis[j])
                    continue;
                if(i!= j &&A[i]*2 == A[j] || A[j]*2==A[i]){
                    System.out.println("A["+i+"]="+A[i]+",A["+j+"]="+A[j]);
                    vis[i]=vis[j]=true;
                    break;
                }
            }
        }
        for(int i=0;i<vis.length;i++)
            if(vis[i]==false)
                return false;
        return true;
    }
}