package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 两个数组：数组A和数组B
 数组A： 一个几乎严格升序排序的数组（几乎的定义是只需改变其中一个数，即可满足完全升序排序）
 从数组B中选择一个最大的数，使得数组A是完全严格升序排列的
 */
public class exam1 {
    //测试用例：
    //A：6 2 3 4 5
    //B：7 1 2 3 4

    //A：6 2 8 9 10 11
    //B：1 2 3 7 6 8

    //A：5 9 8 11 15
    //B：2 3 4 6 10 20

    //A：5 9 8 11 15
    //B：1 2 3 4 6 7
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

    public static Integer[] sortedArr(Integer[] A, Integer[] B) {
        //a[i] > a[i+1] 先替换a[i+1]  不行再替换a[i]
        //a[i] < a[i-1] 先替换a[i]  不行再替换a[i-1]
        int i = 0;
        Arrays.sort(B);
        int condition = 0;
        for (i = 0; i < A.length; i++) {
            if (i + 1 < A.length && A[i] > A[i + 1]) {
                condition = 1;
                break;
            }
            if (i - 1 >= 0 && A[i] < A[i - 1]) {
                condition = 2;
                break;
            }
        }
        for (int j = B.length - 1; j >= 0; j--) {
            if (condition == 1) {
                if (B[j] > A[i] && ((i + 2 < A.length && B[j] < A[i + 2]) || i + 2 >= A.length)) {
                    A[i + 1] = B[j];
                    return A;
                }

                if (B[j] < A[i + 1]) {
                    A[i] = B[j];    // 这边只考虑了替换左边(i)那个值的情况，你看下case (A:[6 1 8 9 10], B:[7 7 7 7 7])就要去替换右边(i+1)值, 下面代码也有这个问题
                    return A;
                }
            }
            if (condition == 2) {
                if (B[j] > A[i - 1]) {
                    A[i] = B[j];
                    return A;
                }
                if (B[j] < A[i] && ((i - 2 >= 0 && B[j] > A[i - 2]) || i - 2 < 0)) {
                    A[i - 1] = B[j];
                    return A;
                }
            }
        }
        return null;
    }
}
