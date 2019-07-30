package pdd;

import javafx.util.Pair;

import java.util.*;

/**
 搭积木游戏。有N个长方体积木，每个积木的高都是1，长宽都是L，重量为Wi
 用这些积木搭金字塔，金字塔的每一层是由且仅由一块积木组成，同时每一层的积木边长都严格比其下方的积木小
 每块积木只能承受自身重量的7倍，若超过7倍自重，搭建的金字塔会因此变得不稳定
 请计算，最高可以搭建一个多高的金字塔？
 */
public class exam4 {
    public static void main(String[] args) {
        //按照长度逆序排序 https://www.cnblogs.com/javahyj/p/5305331.html学习一下Java怎么逆序排序
        //nextInt自动去掉enter键
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] length = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++)
            length[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        //Pair<length,weight> 按照length从大到小排列，length相等的时候按weight从大到小
//        Queue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if(o1.getKey() == o2.getKey()){
//                    return (int)o2.getValue() - (int)o1.getValue();
//                }
//                else{
//                   return (int)o2.getKey() - (int)o1.getKey();
//                }
//            }
//        });
        Queue<Pair> queue = new PriorityQueue<Pair>((o1, o2) -> {return (int)o2.getKey() - (int)o1.getKey();});
        for(int i = 0 ; i < n; i++){
            queue.add(new Pair(length[i], weight[i]));
        }
        int i = 0;
        while(queue.size() > 0){
            Pair pair = queue.poll();
            length[i] = (int)pair.getKey();
            weight[i] = (int)pair.getValue();
            i++;
        }
//        System.out.print(Arrays.toString(length));
//        System.out.print(Arrays.toString(weight));
        //然后输入到函数

        System.out.print(maxHeight(length, weight, new ArrayList<>(), 0));
    }
    public static int maxHeight(int[] length, int[] weight, List<Integer> leftWeight, int start) {
        int n = length.length;
        if (start == n)
            return 0;
        for (int i = start; i < n; i++) {
            List tmp = leftWeight;
            for (int k = 0; k < leftWeight.size(); k++) {
                if (weight[i] > leftWeight.get(k) || (i - 1 >= 0 && length[i] >= length[i - 1])) {
                    leftWeight = tmp;
                    return maxHeight(length, weight, leftWeight, start + 1);
                } else {
                    leftWeight.set(k, leftWeight.get(k) - weight[i]);
                }
            }
            leftWeight.add(7 * weight[i]);
//            System.out.print(leftWeight);
            return Math.max(1 + maxHeight(length, weight, leftWeight, start + 1), maxHeight(length, weight, tmp, start + 1));
        }
        return -1;
    }

    //先按照length排序（从大到小）
    //这里有问题 可能满足条件的情况下，我依旧不选择这块积木
//    public static int maxHeight(int[] length, int[] weight) {
//        List<Integer> leftWeight = new ArrayList<Integer>();
//        int n = length.length;
//        int max = 0;
//        int res = 0;
//        boolean flag = true;
//        for(int i = 0; i < n; i++){
//            leftWeight.add(7 * weight[i]);
//            max = 1;
//            for(int j = i + 1; j < n; j++){
//                for(int k = 0; k < leftWeight.size(); k++){
//                    if(weight[j] > leftWeight.get(k)){
//                        flag = false;
//                        break;
//                    }
//                    else if(length[j] >= length[j - 1]){//排序以后有可能出现等于的情况
//                        flag = false;
//                        break;
//                    }
//                    else
//                        leftWeight.set(k, leftWeight.get(k) - weight[j]);
//                }
//                leftWeight.add(7 * weight[j]);
//                if(flag)
//                    max++;
//                flag = true;
//            }
//            res = Math.max(max, res);
//        }
//        return res;
//    }
}
