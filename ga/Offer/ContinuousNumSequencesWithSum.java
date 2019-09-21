package Offer;

import java.util.ArrayList;

//和为S的连续正数序列
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
public class ContinuousNumSequencesWithSum {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int small = 1;
        int big = 2;
        int n = 3;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(small <= (sum - 1) / 2){
            if(n < sum){
                big++;
                n += big;
            }else if(n > sum){
                n -= small;
                small++;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = small; i <= big; i++)
                    list.add(i);
                res.add(list);
                big++;
                n += big;
            }
        }
        return res;
    }

}
