171. Excel Sheet Column Number

        Given a column title as appear in an Excel sheet, return its corresponding column number.

        For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
        Example 1:

        Input: "A"
        Output: 1
        Example 2:

        Input: "AB"
        Output: 28
        Example 3:

        Input: "ZY"
        Output: 701

26进制转十进制 进制转换
class Solution {
    public int titleToNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        char a[] = sb.reverse().toString().toCharArray();
        int ans=0,mul=1;
        for(int i=0;i<a.length;i++){
            ans+=mul*(a[i]-'A'+1);
            mul*=26;
        }
        return ans;
    }
}