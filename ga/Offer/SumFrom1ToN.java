package Offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumFrom1ToN {
    public int Sum_Solution(int n) {

        boolean ans = (n > 0)&&((n += Sum_Solution(n - 1)) > 0);//短路原则
        return n;
    }
}
