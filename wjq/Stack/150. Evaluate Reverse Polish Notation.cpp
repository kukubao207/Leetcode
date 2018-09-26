150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


我的做法
终于碰到一个能秒杀的了 Orz....
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> s;
        int num=0;
        for(int i=0;i<tokens.size();i++)
        {
            if(isdigit(tokens[i][0])||isdigit(tokens[i][1]))
                s.push(stoi(tokens[i]));
            else
            {
                int num1=s.top();
                s.pop();
                int num2=s.top();
                s.pop();
                switch(tokens[i][0])
                {
                    case '+':s.push(num1+num2);break;
                    case '-':s.push(num2-num1);break;
                    case '*':s.push(num1*num2);break;
                    case '/':s.push(num2/num1);break;
                }
            }
        }
        return s.top();
    }
};
