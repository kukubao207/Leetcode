166. Fraction to Recurring Decimal

        Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

        If the fractional part is repeating, enclose the repeating part in parentheses.

        Example 1:

        Input: numerator = 1, denominator = 2
        Output: "0.5"
        Example 2:

        Input: numerator = 2, denominator = 1
        Output: "2"
        Example 3:

        Input: numerator = 2, denominator = 3
        Output: "0.(6)"


题意
这道题让我们求解除法运算 ，有点类似于大数除法的感觉

无限循环小数用()标记一位就可以

思路
这种题主要是要考虑全所有case

首先，
一般先考虑正负号
然后把两个输入的数取绝对值
其次，
考虑整数部分，
最后也是最难的部分
考虑小数部分应该如何进行运算
什么时候判断重复出现了

模拟一下 1/6的过程
符号和整数部分计算完成后为 0.
剩下  1/6的过程
10/6 = 1    0.1
10%6 = 4

40/6 = 6    0.16
40%6 = 4   结束，因为4这个结果前一次出现过，


1234/9999

12340/9999 = 1
12340%9999 = 2341

23410/9999 = 2
23410%9999 = 3412

34120/9999 = 3
34120%9999 = 4123

41230/9999 = 4
41230%9999 = 1234 （与第一个1234重复，说明这里开始循环）

这题还有一个坑点
小数部分的运算时，不断增大乘以10，导致的int整数溢出，所以得用long来表示
比如这种 测试用例 1 / Integer.MIN_VALUE 这种case
会导致循环中  1 ->  10000000000 > Integer.MAX_VALUE ，溢出

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder("");
        //1.符号部分
        if(numerator<0&&denominator>0||(numerator>0&&denominator<0))
            sb.append("-");
        //2.整数部分
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num = num % den;
        if(num==0)
            return sb.toString();
        //3.小数部分
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        map.put(num,sb.length());
        while(num!=0){
            num*=10;
            sb.append(num/den);
            num%=den;
            if(!map.containsKey(num)){
                map.put(num,sb.length());
            }else{
                int index = map.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }
}
