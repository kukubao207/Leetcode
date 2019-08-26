package yuanfudao;

import java.util.Scanner;

public class exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K =sc.nextInt();
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(compute(a, b, N ,M ,K));
    }

    public static int compute(String a, String b, int N, int M, int K) {
        int res = 0;
        int diff = 0 ;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }

        if (M == 1) {
            if (K == diff)
                return 1;
            else
                return 0;
        }
        if (K == 1) {
            if (M < diff)
                return 0;
            if (M == diff)
                return 1;

        }
        return res;
    }
}
