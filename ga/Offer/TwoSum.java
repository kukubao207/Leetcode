package Offer;

import java.util.ArrayList;

//和为S的两个数字
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class TwoSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        int minX = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<Integer>(); ;
        while(i < j){
            int s = array[i] + array[j];
            if(s > sum){
                j--;
            }else if(s < sum){
                i++;
            }else{
                int x = array[i] * array[j];
                if(x < minX){
                    minX = x;
                    res = new ArrayList<Integer>();
                    res.add(array[i]);
                    res.add(array[j]);
                }
                i++;
                j--;
            }
        }
        return res;
    }
}
