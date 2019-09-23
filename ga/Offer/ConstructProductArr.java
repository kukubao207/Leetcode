package Offer;

/**构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class ConstructProductArr {
    public int[] multiply(int[] A) {
        if(A == null || A.length == 0)
            return new int[]{};
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[n];
        C[0] = 1;
        int[] D = new int[n];
        D[n - 1] = 1;
        for(int i = 1; i < n; i++)
            C[i] = C[i - 1] * A[i - 1];
        for(int i = n - 2; i >= 0; i--)
            D[i] = D[i + 1] * A[i + 1];
        for(int i = 0; i < n; i++)
            B[i] = C[i] * D[i];
        return B;
    }
}
