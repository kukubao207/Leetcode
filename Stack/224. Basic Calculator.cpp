224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

����1��

����˼·��
���㺬��+ - ( ) �������ַ�����
��������һ���ص㣬����Ҫ˼������������ʱ��Ҫ����ʲô��������������ʱ��ʲô�������ٱ����ˡ�
��������ֻ��Ҫ��������������ʱ��ǰ�÷���λ���ɣ�
1.����������ʱ������ǰ�÷���λsign�������������Ŷ�������㣬��������sign�йء�
2.����������ʱ����ζ��������Ŷ����������ϣ����԰�֮ǰpush��ջ�ķ���λsign pop��ȥ�ˡ�
3.��������ʱ�������ֱ�����num�����Ｔ�ɡ�
4.�����ӺŻ��߼���ʱ��ֱ���÷��ź�������һ�����㣬��������ӵ�result�С�
    4.1.�����ʱ����ջ��Ϊ�գ���˵����ǰ�ķ������㴦��ĳ�������һ�����ļ��㲻���뵱ǰ�ķ����йأ�����ջ�������йء�
    4.2.�����ʱ����ջΪ�գ���˵����ǰ�ķ������㲻��ĳ�������һ�����ļ���ֻ�͵�ǰ�ķ����йء�

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


����2��
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
