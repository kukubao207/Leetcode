package Offer;

/**剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    public int cutRope(int target) {
        if(target == 2)
            return 1;
        if(target == 3)
            return 2;
        int res = 1;
        int n3 = target / 3;
        int n2 = 0;
        int n = 1;
        if(target % 3 == 1){
            n3--;
            n2 = 2;
        }else if(target % 3 != 0){
            n = target % 3;
        }
        for(int i = 0; i < n3; i++)
            res *= 3;
        for(int i = 0; i < n2; i++)
            res *= 2;
        return res * n;
    }
}
