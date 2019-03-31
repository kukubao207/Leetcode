package tx;

import java.util.*;

public class tx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(input.equals("None"))
            System.out.println("True");
        String[] inp = input.split(",");
        int[] a = new int[inp.length+1];
        for(int i=1;i<a.length;i++) {
            if(inp[i-1].equals("None"))
                a[i] = Integer.MIN_VALUE;
            else
                a[i] = Integer.valueOf(inp[i - 1]);
        }
        if(isBST(a))
            System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean isBST(int[] a) {
        for(int i=1;i<a.length;i++){
            if(a[i]==Integer.MIN_VALUE)
                continue;
            if(2*i<a.length){
                if(a[2*i]==Integer.MIN_VALUE)
                    continue;
                if(a[2*i]>=a[i])
                    return false;
            }
            if(2*i+1<a.length){
                if(a[2*i+1]==Integer.MIN_VALUE)
                    continue;
                if(a[2*i+1]<=a[i])
                    return false;
            }
        }
        return true;
    }
}
