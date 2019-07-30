package pdd;
import javafx.util.Pair;

import java.util.*;

/**
 一共有N个待执行的任务，每个任务需要Pi的时间完成。同时每个任务之间存在一定的依赖关系。
 比如任务1可能依赖任务2和任务3，那么任务1必须在任务2和任务3完成之后执行
 多多鸡只有一个人，所以同时只能执行一个任务，同时在任务完成之前不能暂停切换去执行其他任务
 多多鸡希望最小化任务的平均返回时长。一个任务的返回时长的定义是任务执行完成时刻减去平台接收到该任务的时刻。
 在零时刻，所有N个任务都已经被平台接收
 请安排任务执行顺序，使得平均返回时长最小
 */
//输入
//  5 6（N：任务数量 ； M：M个任务以来关系）
//  1 2 1 1 1（第i个数表示第i个任务的处理时间Pi）
//  (M个依赖关系)
//  1 2
//  1 3
//  1 4
//  2 5
//  3 5
//  4 5
//输出
//  1 3 4 2 5
public class exam3 {
    //拓扑排序+优先队列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n + 1];
        int[] inDegree = new int[n + 1];//入度//拓扑排序
        List<Integer>[] dependence = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            dependence[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dependence[a].add(b);//依赖关系  可能一对多
            inDegree[b]++;
        }
        Queue<Pair> queue = new PriorityQueue<Pair>((o1,o2) -> {
            if(o1.getKey() == o2.getKey())//时间一样长的按原始的默认顺序
                return (int)o1.getValue() - (int)o2.getValue();
            else return (int)o1.getKey() - (int)o2.getKey();//任务时间短的优先
        });
        for (int i = 1; i <= n; i++) {//先存入入度为0的点
            if(inDegree[i] == 0)//入度为0的才存到队列中
                queue.add(new Pair(p[i], i));
        }
        int[] res = new int[n];
        int index = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            res[index++] = (int)pair.getValue();
            for(int d: dependence[(int)pair.getValue()]){
                if(--inDegree[d] == 0)//入度为0的加进优先队列
                    queue.add(new Pair(p[d], d));
            }
        }
        for (int i = 0; i < n; i++) {
            if(i == n - 1)
                System.out.print(res[i]);
            else
                System.out.print(res[i] + " ");
        }
    }

}
