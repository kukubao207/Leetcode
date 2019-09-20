package Offer;

public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int a = 1;
        int b = 0;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }
}
