package Offer;

/**正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegEx {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null)
            return false;
        return helper(str, pattern, 0, 0);
    }
    public boolean helper(char[] str, char[] pattern , int i, int j){
        if(i != str.length && j == pattern.length)
            return false;
        if(i == str.length && j == pattern.length)
            return true;
        if(j + 1 < pattern.length && pattern[j + 1] == '*'){
            if(i < str.length && (pattern[j] == '.' || pattern[j] == str[i]))
                return helper(str, pattern, i, j + 2) ||
                        helper(str, pattern, i + 1, j + 2) ||
                        helper(str, pattern, i + 1, j);
            else
                return helper(str, pattern, i, j + 2);
        }
        else if(i < str.length && (pattern[j] == '.' || pattern[j] == str[i]))
            return helper(str, pattern, i + 1, j + 1);
        return false;
    }
}
