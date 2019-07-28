package pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**

 */
public class exam3 {
    public static void main(String[] args) {
        //按照长度逆序排序 https://www.cnblogs.com/javahyj/p/5305331.html学习一下Java怎么逆序排序
        //然后输入到函数
    }

    //先按照length排序（从大到小）
    public int maxHeight(int[] length, int[] weight) {
        List<Integer> leftWeight = new ArrayList<Integer>();
        int n = length.length;
        int max = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            leftWeight.add(7 * weight[i]);
            max = 1;
            for(int j = i + 1; j < n; j++){
                for(Integer left: leftWeight){
                    if(weight[j] > left)
                        break;
                    else{
                        left = left - weight[j];
                    }
                }
                max++;
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
