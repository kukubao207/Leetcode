224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

做法1：

解题思路：
运算含有+ - ( ) 这样的字符串。
这类题有一个特点，我们要思考遇到左括号时需要保存什么量，遇到右括号时有什么量不必再保存了。
在这道题里，只需要保存遇见左括号时的前置符号位即可，
1.遇到左括号时，保存前置符号位sign，对于下面括号对里的运算，都会和这个sign有关。
2.遇到右括号时，意味着这个括号对里的运算完毕，可以把之前push进栈的符号位sign pop出去了。
3.遇到数字时，把数字保存在num变量里即可。
4.遇到加号或者减号时，直接用符号和数字做一次运算，将结果增加到result中。
    4.1.如果此时符号栈不为空，那说明当前的符号运算处在某括号里，下一个数的计算不仅与当前的符号有关，还与栈顶符号有关。
    4.2.如果此时符号栈为空，那说明当前的符号运算不在某括号里，下一个数的计算只和当前的符号有关。

class Solution {
public:
    int calculate(string s) {
        int num=0,result=0,sign=1;
        stack<int> st;
        for(int i=0;i<s.length();i++)
        {
            char c=s[i];
            if(c==' ')
                continue;
            if(c>='0'&&c<='9')
                num=num*10+c-'0';
            else if(c=='+'||c=='-')
            {
                result+=sign*num;
                num=0;
                if(!st.empty())
                    sign=st.top()*(c=='+'?1:-1);
                else
                    sign= (c=='+')?1:-1;
            }
            else if(c=='(')
                st.push(sign);
            else if(c==')')
                st.pop();
        }
        result+=sign*num;
        return result;
    }
};


做法2：
public static int calculate(String s) {
	int len = s.length(), sign = 1, result = 0;
	Stack<Integer> stack = new Stack<Integer>();
	for (int i = 0; i < len; i++)
	{
		if (Character.isDigit(s.charAt(i)))
        {
			int sum = s.charAt(i) - '0';
			while (i + 1 < len && Character.isDigit(s.charAt(i + 1)))
			{
				sum = sum * 10 + s.charAt(i + 1) - '0';
				i++;
			}
			result += sum * sign;
		}
		else if (s.charAt(i) == '+')
			sign = 1;
		else if (s.charAt(i) == '-')
			sign = -1;
		else if (s.charAt(i) == '(') {
			stack.push(result);
			stack.push(sign);
			result = 0;
			sign = 1;
		}
		else if (s.charAt(i) == ')') {
			result = result * stack.pop() + stack.pop();
		}

	}
	return result;
}
