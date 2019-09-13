package Exam.WeeklyContest153;

public class exam3 {
    public static void main(String[] args) {
        int[] a = {1, -2, 0, 3};
        System.out.println(maximumSum(a));
        int[] b = {1,-2,-2,3};
        System.out.println(maximumSum(b));
        int[] c = {-1,-1,-1,-1};
        System.out.println(maximumSum(c));


    }

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int left[] = new int[n];
        left[0] = arr[0];
        int DoNotDeleteMax = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1] + arr[i], arr[i]);
            DoNotDeleteMax = Math.max(DoNotDeleteMax, left[i]);
        }

        int right[] = new int[n];
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1] + arr[i], arr[i]);
        }

        int DeleteOneMax = Math.max(right[1], left[n - 2]);
        for (int i = 1; i < n - 1; i++) {
            DeleteOneMax = Math.max(DeleteOneMax, left[i - 1] + right[i + 1]);
        }
        return Math.max(DoNotDeleteMax, DeleteOneMax);
    }
}
