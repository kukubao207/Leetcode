package tx;

import java.util.ArrayList;
import java.util.LinkedList;
public class Main{
    public static void main(String[] args){
//        for(int i=1;i<100;i++)
//            FindContinuousSequence(i);
        //int[] a = {-6,-5,-3,-2,-2,-1,-1,0,0};
        //System.out.println(FindNumbersWithSum(a,-2));
        ReverseSentence("I am a student.");

    }

    public static String ReverseSentence(String str) {
        char[] s = str.toCharArray();
        reverse(s,0,s.length-1);
        int i=0;
        while(i<s.length){
            if(s[i]==' '){
                i++;
                continue;
            }
            int e = i;
            while(e<s.length&&s[e]!=' ')
                e++;
            reverse(s,i,e-1);
            i=e;
        }
        return String.valueOf(s);
    }
    public static void reverse(char[] str,int s,int e){
        while(s<e){
            char c=str[s];
            str[s]=str[e];
            str[e]=c;
            s++;
            e--;
        }
    }
}