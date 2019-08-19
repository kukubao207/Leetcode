package yitukeji;

public class test1 {
    //给一个升序数组a，给一个升序数组b，给一个数字k，从a和b中分别挑一个数，使得和小于k，求这样的组合的个数。
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] a = {1, 3, 6};
        int[] b = {2, 7};
        System.out.println(num(a, b, 6));
        System.out.println(num(a, b, 8));
        System.out.println(num(a, b, 10));
        System.out.println(num(a, b, 15));
    }

    // O(n) 解法
    public static int num(int[] a, int b[], int k) {
        int[] c = new int[b.length];
        int cIdx = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > k)
                break;
            c[cIdx++] = k - b[i];
        }

        int res = 0;
        int aIdx = 0;
        cIdx = cIdx - 1;
        while (cIdx >= 0 && aIdx < a.length) {
            while (aIdx < a.length && a[aIdx] <= c[cIdx]) {
                aIdx++;
            }
            if (aIdx == a.length) {
                while(cIdx>=0) {
                    res += aIdx;
                    cIdx--;
                }
                return res;
            }
            res += aIdx;
            cIdx--;
        }
        return res;
    }
}
