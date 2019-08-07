package Exam.wy;

import java.util.*;

public class wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> tmp = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        dfs(pre, tmp, arr, 0);
//        for(Integer list: tmp)
//            System.out.print(list + " ");

    }
    public static void dfs(List<Integer> pre, List<Integer> tmp, int[] arr, int start){
        if(tmp.size() == arr.length){
            pre = tmp;
            System.out.print(tmp);
            return;
        }
        for(int i = start; i < arr.length; i++){
            int j = tmp.size();
            if((arr[i] + arr[j]) % 2 != 0){
                if(!pre.isEmpty() && tmp.get(i) < pre.get(i)){
                    tmp.add(arr[i]);
                    dfs(pre, tmp, arr, i +1);
                    tmp.remove(tmp.size() - 1);
                }
            }else{
                tmp.add(arr[j]);
                dfs(pre, tmp, arr, i +1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
//1 3 7 4 10
//2 1 5 8 9

//1 3 4 7 1
//2 1 5 8 9