package pdd;

import java.util.Scanner;

/**

 */

// 这个题看下我怎么写的，慢慢来ba.
public class exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean res = true;
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int pre_start = str[str.length - 1].charAt(0);
        int pre_end = str[str.length - 1].charAt(str[str.length - 1].length() - 1);
        for(int i = 0; i < str.length; i++){
            int start = str[i].charAt(0);
            int end = str[i].charAt(str[i].length() - 1);
            int next = i + 1;
            if(next >= str.length)
                next = 0;
            if(start == pre_end && end == str[next].charAt(0)){
                pre_start = start;
                pre_end = end;
                continue;
            }
            else{
                res = false;
                break;
            }
        }
        System.out.print(res);
    }
}
