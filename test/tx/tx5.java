package tx;

import java.util.Scanner;

// 用一个矩阵保存每对点的距离，每次找到最近的一对点，
// 它们最后的半径就是距离(一方已固定)或者它的一半，
// 之后更新矩阵，计算一对点距离时，如果一对点都已固定，不用考虑，当做正无穷；
// 如果只有一点固定，距离是（实际距离-固定点的圆半径-经过的时间），都不固定，距离是（实际距离-经过的时间）/2。
public class tx5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

    }

}