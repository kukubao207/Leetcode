package Exam.WeeklyContest153;

public class exam1 {
    public static void main(String[] args) {
        int []distance = {1,2,3,4};
        int s = 0;
        int e = 2;
        System.out.println(distanceBetweenBusStops(distance, s, e));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int a = 0, s = start;
        while (s != destination) {
            a += distance[s];
            s = (s + 1) % distance.length;
        }
        int b = 0, e = destination;
        while (e != start) {
            b += distance[e];
            e = (e + 1) % distance.length;
        }
        return Math.min(a, b);
    }
}
