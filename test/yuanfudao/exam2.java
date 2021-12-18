package yuanfudao;

import java.util.*;

public class exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int s = 0; s < n; s++) {
            int x = sc.nextInt();
            Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < x; i++) {
                q.offer(sc.nextInt());
            }
            System.out.println(compute(q, x));
        }
        sc.close();
    }

    public static int compute(Queue<Integer> q, int x) {
        if (x < 3)
            return 0;
        int res = 0, x1 = 0, x2 = 0, x3 = 0;
        do {
            x1 = q.poll();
            x2 = q.poll();
            x3 = q.poll();
//            System.out.println("x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3);
            if (x3 <= 0)
                break;
            res++;
            q.offer(x1 - 1);
            q.offer(x2 - 1);
            q.offer(x3 - 1);
        } while (true);
        return res;
    }

}
