package qskj;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exam1 {
    private static String process(String num1, String num2){
        String[] counts = num1.split(" ");
        List<Integer> list = new ArrayList<>();
        int[] value = new int[]{1, 5, 10, 20, 50, 100};
        int i = 0;
        for(String c: counts){
            int count = Integer.parseInt(c);
            while(count > 0){
                list.add(value[i]);
                count--;
            }
            i++;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(list, Integer.parseInt(num2), res, tmp, 0, 0);
        int result = 0;
        for(List<Integer> l: res){
            result += l.size();
        }
        if(result == 0)
            return  -1 + "";
        else
            return result + "";
    }
    public static void dfs(List<Integer> list, int num, List<List<Integer>> res, List<Integer> tmp, int sum, int start){
        if(sum == num)
            res.add(new ArrayList<>(tmp));
        else if(sum > num)
            return;
        int lastUsed = Integer.MIN_VALUE;
        for(int i = start; i < list.size(); i++){
            if(list.get(i) < num && list.get(i) != lastUsed){
                tmp.add(list.get(i));
                dfs(list, num, res, tmp, sum + list.get(i), i + 1);
                lastUsed = tmp.get(tmp.size() - 1);
                tmp.remove(tmp.size()  - 1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String strValueSequence = sc.nextLine();
        String strChangeNum = sc.nextLine();
        String sum = process(strValueSequence, strChangeNum);
        System.out.println(sum);
    }
}
