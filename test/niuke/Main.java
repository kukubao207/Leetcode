package niuke;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer m = sc.nextInt();
        Integer n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        solve(a, m, n);
    }

    public static void solve(int[][] a, int m, int n) {
        // 降序比较器
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        Map<Integer, Integer> count1 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i % 2; j < n; j += 2)
                count1.put(a[i][j], count1.getOrDefault(a[i][j], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(count1.entrySet());
        Collections.sort(list, valueComparator);


        Map<Integer, Integer> count2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = (i + 1) % 2; j < n; j += 2)
                count2.put(a[i][j], count2.getOrDefault(a[i][j], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<Map.Entry<Integer, Integer>>(count2.entrySet());
        Collections.sort(list2, valueComparator);


        if (list.get(0).getKey() != list2.get(0).getKey()) {
            System.out.println(m * n - list.get(0).getValue() - list2.get(0).getValue());
            return;
        } else {
            if (list.size() == 1 && list2.size() == 1) {
                System.out.println(m * n - Math.max(list.get(0).getValue(), list2.get(0).getValue()));
                return;
            } else if (list.size() != 1 && list2.size() != 1) {
                System.out.println(m * n - Math.max(list.get(0).getValue() + list2.get(1).getValue(), list.get(1).getValue() + list2.get(0).getValue()));
                return;
            } else if (list.size() == 1) {
                System.out.println(m * n - list.get(0).getValue() - list.get(1).getValue());
                return;
            } else if (list2.size() == 1) {
                System.out.println(m * n - list.get(1).getValue() - list.get(0).getValue());
                return;
            }
        }
    }

}
