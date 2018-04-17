739. Daily Temperatures

Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

题意要求找出下一个比今天暖和的日子，要求出日期差。
我的思路一致在想把温度push进栈，维持一个递减栈，每当遇到比栈顶暖和的日子时，不断从栈中pop出温度。
这样存在一个问题，虽然能知道下一个暖和的温度，无法计算日期差。
看了别人的代码之后，他们把日期push栈，这样就可以解决这个问题了。
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int length=temperatures.size();
        vector<int> result(length,0);
        stack<int> s;
        for(int i=0;i<length;i++)
        {
            while(!s.empty()&&temperatures[s.top()]<temperatures[i])
            {
                result[s.top]=i-s.top();
                s.pop();
            }
            s.push(i);
        }
        return result;
    }
};
