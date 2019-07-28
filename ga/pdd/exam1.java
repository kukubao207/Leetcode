package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**

 */
public class exam1 {
    public static void main(String[] args) {
        List list_A = new ArrayList<Integer>();
        List list_B = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = s.split(" ");
        for(int i = 0; i < a.length; i++)
            list_A.add(Integer.parseInt(a[i]));
        String ss = sc.nextLine();
        String[] b = ss.split(" ");
        for(int i = 0; i < b.length; i++)
            list_B.add(Integer.parseInt(b[i]));
        Integer[] A = new Integer[list_A.size()];
        list_A.toArray(A);
        Integer[] B = new Integer[list_B.size()];
        list_B.toArray(B);
        Integer res[] = sortedArr(A, B);
        if(res == null)
            System.out.print("NO");
        else{
            for(int i = 0; i < res.length; i++){
                if(i == res.length - 1)
                    System.out.print(res[i]);
                else
                    System.out.print(res[i] + " ");
            }
        }
    }

    public static Integer[] sortedArr(Integer[] A, Integer[] B){
        int i = 0;
        Arrays.sort(B);
        if(A[0] > A[1]){
            i = 0;
            for(int j = B.length - 1; j >= 0; j--)
                if(B[j] < A[i + 1]){
                    A[i] = B[j];    // 这边只考虑了替换左边(i)那个值的情况，你看下case (A:[6 1 8 9 10], B:[7 7 7 7 7])就要去替换右边(i+1)值, 下面代码也有这个问题
                    return A;
                }
        }
        else if(A[A.length - 1] < A[A.length - 2]){
            i = A.length - 1;
            for(int j = B.length - 1; j >= 0; j--)
                if(B[j] > A[i - 1]){
                    A[i] = B[j];
                    return A;
                }
        }
        else{
            for(i = A.length - 2; i >= 1 ; i--)
                if(!(A[i] < A[i + 1] && A[i] > A[i - 1]))
                    break;
            for(int j = B.length - 1; j >= 0; j--)
                if(B[j] > A[i - 1] && B[j] < A[i + 1]){
                    A[i] = B[j];
                    return A;
                }
        }
        return null;
    }

}
