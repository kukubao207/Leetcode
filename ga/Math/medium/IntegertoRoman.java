package Math.medium;
//12. Integer to Roman
//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//Example 1:
//
//Input: 3
//Output: "III"
//Example 2:
//
//Input: 4
//Output: "IV"
//Example 3:
//
//Input: 9
//Output: "IX"
//Example 4:
//
//Input: 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
//Example 5:
//
//Input: 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                s.append("M");
                num -= 1000;
            }else if (num >= 900) {
                s.append("CM");
                num -= 900;
            }else if (num >= 500) {
                s.append("D");
                num -= 500;
            }else if (num >= 400) {
                s.append("CD");
                num -= 400;
            }else if (num >= 100) {
                s.append("C");
                num -= 100;
            }else if (num >= 90) {
                s.append("XC");
                num -= 90;
            }else if (num >= 50) {
                s.append("L");
                num -= 50;
            }else if (num >= 40) {
                s.append("XL");
                num -= 40;
            }else if (num >= 10) {
                s.append("X");
                num -= 10;
            } else if (num >= 9) {
                s.append("IX");
                num -= 9;
            } else if (num >= 5) {
                s.append("V");
                num -= 5;
            } else if (num >= 4) {
                s.append("IV");
                num -= 4;
            } else if (num >= 1) {
                s.append("I");
                num -= 1;
            }
        }
        return s.toString();
    }
    public String intToRoman1(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                res += romans[i];
                num -= nums[i];
            }
        }
        return res;
    }

}
