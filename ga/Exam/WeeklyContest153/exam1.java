package Exam.WeeklyContest153;

import java.util.Scanner;

/**
 *
 */
public class exam1 {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        int[] distance = new int[]{1, 2, 3, 4};
        int start = 0;
        int destination = 3;
        System.out.print(distanceBetweenBusStops(distance, start, destination));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int i = start;
        int sum = 0;
        while(i != destination){
            sum += distance[i];
            i = (i + 1) % n;
        }
        int m = 0;
        for(int j = 0; j < n; j++)
            m += distance[j];
       return Math.min(sum, m - sum);
    }
}
