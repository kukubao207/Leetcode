package pdd20190728;

import java.util.*;

public class pdd3 {
    public static class Pair {
        int f, s;

        Pair() {
            f = 0;
            s = 0;
        }

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n + 1];
        int[] inDegree = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            ++inDegree[b];
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.f == o2.f) {
                    return o1.s - o2.s;
                } else {
                    return o1.f - o2.f;
                }
            }
        });
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(new Pair(p[i], i));
            }
        }
        int[] ans = new int[n];
        int id = 0;
        while (!q.isEmpty()) {
            Pair u = q.poll();
            ans[id++] = u.s;
            for (int v : g[u.s]) {
                if (--inDegree[v] == 0) {
                    q.add(new Pair(p[v], v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
            if (i < n - 1) {
                System.out.print(' ');
            }
        }

    }
}
