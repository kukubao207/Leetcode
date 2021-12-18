package yitukeji;

import java.util.*;

/**
 *
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Triangle, Integer> map = new HashMap<>();//存放特定边长的三角形出现的次数
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            int z1 = sc.nextInt();
            int z2 = sc.nextInt();
            Triangle t = new Triangle(x1, x2, y1, y2, z1, z2);
            map.put(t, 1 + map.getOrDefault(t, 0));
        }
        int sum = 0;

        for (Integer value : map.values()) {
            if (value > 1)
                sum += value * (value - 1) / 2;
        }
        System.out.println(sum);
        sc.close();
    }

    public static class Triangle {
        int[] sides = new int[3];

        public Triangle(int x1, int x2, int y1, int y2, int z1, int z2) {
            sides[0] = getSideSquare(x1, x2, y1, y2);
            sides[1] = getSideSquare(x1, x2, z1, z2);
            sides[2] = getSideSquare(y1, y2, z1, z2);
            Arrays.sort(sides);
        }

        public int getSideSquare(int x1, int x2, int y1, int y2) {
            return (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Triangle)) {
                return false;
            }
            Triangle tt = (Triangle) o;
            return tt.sides[0] == sides[0] && tt.sides[1] == sides[1] && tt.sides[2] == sides[2];
        }

        @Override
        public int hashCode() {
            int result = 17;
            result += 31 * sides[0];
            result += 31 * sides[1];
            result += 31 * sides[2];
            return result;
        }
    }
}
