import com.sun.corba.se.impl.orb.ParserTable;

import java.util.*;

public class Tianjixian {

    public static void main(String[] args) {
        int[][] buildings = {{1, 2, 1}, {1, 2, 2}, {1, 2, 3}};
        System.out.println(getSkyline(buildings));
//        List<int[]> res = getSkyline(buildings);
//        for (int[]a : res) {
//            System.out.println(a[0] + "," + a[1]);
//        }
    }

    private static class Line {
        int x;
        int y;
        boolean isStartLine;

        Line(int x, int y, boolean isStartLine) {
            this.x = x;
            this.y = y;
            this.isStartLine = isStartLine;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            lines.add(new Line(buildings[i][0], buildings[i][2], true));
            lines.add(new Line(buildings[i][1], buildings[i][2], false));
        }
        Collections.sort(lines, (a, b) -> {
            if (a.x == b.x)
                return b.y - a.y;
            return a.x - b.x;
        });
        Queue<Integer> height = new PriorityQueue<>((a, b) -> (b - a));
        height.offer(0);
        int prev = 0;
        for (Line line : lines) {
            if (line.isStartLine) {
                height.offer(line.y);
            } else {
                height.remove(line.y);
            }
            int cur = height.peek();
            if (prev != cur) {
                List<Integer> temp = new ArrayList<>();
                temp.add(line.x);
                temp.add(cur);
                res.add(temp);
                prev = cur;
            }
        }
        return res;
    }
//
//    public static List<int[]> getSkyline(int[][] buildings) {
//        List<int[]> res = new ArrayList<>();
//        List<int[]> height = new ArrayList<>();     // height list to store all buildings' heights
//        for (int[] b : buildings) {
//            height.add(new int[]{b[0], - b[2]});    // start of a building, height stored as negtive
//            height.add(new int[]{b[1], b[2]});      // end of a building, height stored as positive
//        }
//        Collections.sort(height, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));     // sort the height list
//
//        // a pq that stores all the encountered buildings' heights in descending order
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//        pq.offer(0);
//        int preMax = 0;
//
//        for (int[] h : height) {
//            if (h[1] < 0) {     // h[1] < 0, that means it meets a new building, so add it to pq
//                pq.offer(-h[1]);
//            } else {            // h[1] >=0, that means it has reached the end of the building, so remove it from pq
//                pq.remove(h[1]);
//            }
//
//            // the current max height in all encountered buildings
//            int curMax = pq.peek();
//            // if the max height is different from the previous one, that means a critical point is met, add to result list
//            if (curMax != preMax) {
//                res.add(new int[]{h[0], curMax});
//                preMax = curMax;
//            }
//        }
//        return res;
//    }
}
