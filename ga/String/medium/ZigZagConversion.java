package String.medium;

/**
 * 6.将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);
 示例 1:

 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 示例 2:

 输入: s = "LEETCODEISHIRING", numRows = 4
 输出: "LDREOEIIECIHNTSG"
 解释:

 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G

 */

//按顺序遍历字符串 s；
//        res[i] += c： 把每个字符 c 填入对应行 Si
//        i += flag： 更新当前字符 c 对应的行索引；
//        flag = - flag： 在达到 Z字形转折点时，执行反向。

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        String[] strs = new String[numRows];
        for(int i = 0 ; i < numRows; i++)
            strs[i] = "";
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            strs[i] += c;
            if(i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        String res = "";
        for(String str : strs)
            res += str;
        return res;
    }
}
