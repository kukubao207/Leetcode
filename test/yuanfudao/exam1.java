package yuanfudao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(a[i]) > m)
                continue;
            System.out.print(a[i] + " ");
        }
        sc.close();
    }
}
