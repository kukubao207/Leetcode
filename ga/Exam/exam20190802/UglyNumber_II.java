package Exam.exam20190802;

import java.util.ArrayList;

//264. Ugly Number II
//Write a program to find the n-th ugly number.
//
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//
//Example:
//
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//Note:
//
//1 is typically treated as an ugly number.
//n does not exceed 1690.
public class UglyNumber_II {
    public static void main(String[] args){
        test();
    }
    //1.超时了  555555555555555555
    //每个合数都可以写成几个质数（也可称为素数）相乘的形式
    public static int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        int times = 0;
        int i = 0;
        while(times < n){
            i++;
            if(isUglyNumber(i))
                times++;
        }
        return i;
    }

    public static boolean isUglyNumber(int n){
        if(n == 1)
            return true;
        while(n > 1){
            if(n % 2 == 0){
                n = n / 2;
                continue;
            }
            else if(n % 3 == 0){
                n = n / 3;
                continue;
            }
            else if(n % 5 ==0){
                n = n / 5;
                continue;
            }
            else
                return false;
        }
        return true;
    }

    public static void test(){
        int n = 10;
        System.out.println(nthUglyNumber(10));
    }

    //2.三指针法  剑指offer好像有
    //丑数一定会化成  现有丑数中的数与2或者3或者5相乘
    public int nthUglyNumber1(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        ArrayList<Integer> result = new ArrayList<>();//记录丑数数组
        result.add(1);
        int index2 = 0,index3 = 0,index5 = 0;//用来标记2、3、5类别中，选到哪一个数2该乘以谁？3该乘以谁？5该乘以谁？
        int count = 1;//用来记录丑数的个数
        while(count < n){
            int next = Math.min(Math.min(result.get(index2) * 2,result.get(index3) * 3),result.get(index5) * 5);
            result.add(next);
            if(next == result.get(index2) * 2)//最小的丑数对应的index才要+1
                index2++;
            if(next == result.get(index3) * 3)
                index3++;
            if(next == result.get(index5) * 5)
                index5++;
            count++;
        }
        return result.get(n - 1);
    }


}
