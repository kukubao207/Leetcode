package Exam.wy;

import java.util.Arrays;
import java.util.Scanner;

public class wangyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        for(int i = 0; i < t; i++){
            n = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            Arrays.sort(arr);
            if(arr[arr.length - 1] < arr[arr.length - 2] + arr[arr.length -3])
                System.out.println("YES");
            else
                System.out.println("NO");
        }



    }

}
