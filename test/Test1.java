import java.util.Scanner;

public class Test1 {
    public static int getMax(int A[]) {
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            max = Math.max(max, a);
        }
        return max;
    }

    public static int getSum(int A[]) {
        int sum = 0;
        for (int a : A)
            sum += a;
        return sum;
    }
    public static int binarySearch(int A[], int k) {
        int l = getMax(A);
        int r = getSum(A);

        while (l < r) {
            int mid = l + (r - l) / 2;
            int requiredWorker = getRequiredWorker(A, mid);
            if (requiredWorker <= k)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int getRequiredWorker(int A[], int maxTime) {
        int sum = 0, numWorker = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > maxTime) {
                sum = A[i];
                numWorker++;
            }
        }
        return numWorker;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int A[] = new int[n];
        for (int  i = 0; i < n; i++)
            A[i] = sc.nextInt();
        System.out.println(binarySearch(A, m));
    }
}
