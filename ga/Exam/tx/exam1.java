package Exam.tx;

import java.util.*;

/**
 *平面上有n个三角形 请问有几对全等三角形
 */
public class exam1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Triangle, Integer> map = new HashMap<>();//存放特定边长的三角形出现的次数
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();//输入三角形的三个点
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            Triangle t = new Triangle(x1, y1, x2, y2, x3, y3);
            int s1 = t.getSideSquare(x1, y1, x2, y2);
            int s2 = t.getSideSquare(x1, y1, x3, y3);
            int s3 = t.getSideSquare(x2, y2, x3, y3);
            int[] ss = new int[3];
            ss[0] = s1;
            ss[1] = s2;
            ss[2] = s3;
            Arrays.sort(ss);
            t.setSide(ss);
            map.put(t,  1 + map.getOrDefault(t, 0));
        }
        int sum = 0;
        for (Integer value : map.values()){
            if(value > 1)
                sum += value * (value - 1) / 2;
        }
        System.out.println(sum);
    }

    public static class Triangle{
        int x1, y1, x2, y2, x3, y3;
        int side1, side2, side3;//边长从小到大排序
        public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
        public int getSideSquare(int x1, int y1, int x2, int y2){
            return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        }

        public void setSide(int[] sides){
            this.side1 = sides[0];
            this.side2 = sides[1];
            this.side3 = sides[2];
        }

        @Override
        public boolean equals(Object o){
            if(this == o)
            {
                return true;
            }
            if(!(o instanceof Triangle))
            {
                return false;
            }
            Triangle tt = (Triangle) o;
            if(tt.side1 == side1 && tt.side2 == side2 && tt.side3 == side3)
                return true;
            else return false;
        }

        @Override
        public int hashCode(){
            int result = 17;
            result = 31 * side1 +  11 * side2  + side3;
            return result;
        }
    }
}
