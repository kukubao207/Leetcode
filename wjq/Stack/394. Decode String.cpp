394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

我的解法
这道题的解题思路在于，
遇到一个数字时，用num对数字进行统计，因为可能串中数字有很多位，最后统计完才能得到一个值num。
遇到一个字母时，用result对该字母进行统计，result中统计的结果是一个连续的字符串。
遇到一个[时，我们要把前面遇到的字符串压入字符串栈，把num压入数字栈中。
遇到一个]时，先弹出数字栈的值k，对当前[]那的字符串重复k倍,然后把字符串中的内容弹出，添加到当前字符串的左边。


class Solution {
public:

    string decodeString(string s) {
        stack<string> chars;
        stack<int> nums;
        string result;
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]>='0'&&s[i]<='9')
                num=num*10+s[i]-'0';
            else if(isalpha(s[i]))
                result+=s[i];
            else if(s[i]=='[')
            {
                nums.push(num);
                chars.push(result);
                num=0;
                result="";
            }
            else if(s[i]==']')
            {
                string temp=result;
                for(int i=0;i<nums.top()-1;i++)
                    result+=temp;
                result=chars.top()+result;
                nums.pop();
                chars.pop();
            }
        }

        return result;
    }
};


