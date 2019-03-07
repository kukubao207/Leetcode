12. Integer to Roman
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

        Example 1:

        Input: 3
        Output: "III"
        Example 2:

        Input: 4
        Output: "IV"
        Example 3:

        Input: 9
        Output: "IX"
        Example 4:

        Input: 58
        Output: "LVIII"
        Explanation: L = 50, V = 5, III = 3.
        Example 5:

        Input: 1994
        Output: "MCMXCIV"
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

数字转罗马数字
class Solution {
    public String intToRoman(int num) {
        String temp = "";
        int idx = 0;
        String[] str = {"I","V","X","L","C","D","M"};
        while(num!=0){
            int cur = num%10;
            if(cur<4&&cur>0){
                for(int i=0;i<cur;i++)
                    temp=str[idx] + temp;
            } else if(cur==4){
                temp = str[0+idx] + str[1+idx] + temp;
            } else if(cur>4&&cur<9){
                String t = str[1+idx];
                for(int i=0;i<cur-5;i++)
                    t += str[0+idx];
                temp = t + temp;
            } else if(cur==9){
                temp = str[0+idx]+str[2+idx] + temp;
            }
            num/=10;
            idx+=2;
        }
        return temp;
    }
}

其实可以总结出进制转换的一个规律
当int -> string 时
char []table = {'','','',......};
while(num!=0){
    int cur = num % 10;
    //处理具体的逻辑
    num/=10;
}