package Exam.Hulu;

import java.util.Scanner;

/**
 *
 */
public class exam2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();
        int[] p = new int[n];
        int result = getSum(arr, p, n, 0);
        System.out.print(result);
    }
    public static int getSum(int[] arr, int[] p, int n, int sum){
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j)
                    p[j] = arr[i];
                else if(i + 1 == j)
                    p[j] = Math.max(arr[i], arr[j]);
                else
                    p[j] = Math.max(p[j - 1], arr[j]);
                sum = sum % 1000000007 + p[j] % 1000000007;
            }
        }
        return sum;
    }
}
