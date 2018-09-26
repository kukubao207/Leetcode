84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10

�����û�������������Ͽ���һ�ֽ���ջ�������������Ư�������ǽ��Ͷ��ǳ�ģ�����ҿ���֮�󣬾�����ϸ����˼·���£�

1�������֪height����������ģ�Ӧ����ô����

����1,2,5,7,8

��ô����(1*5) vs. (2*4) vs. (5*3) vs. (7*2) vs. (8*1)

Ҳ����max(height[i]*(size-i))

2��ʹ��ջ��Ŀ�ľ��ǹ����������������У��������Ϸ�����⡣

����height����һ��������ģ�Ӧ����������ջ��

����2,1,5,6,2,3

��1��2��ջ��s={2}, result = 0

��2��1��2С��������������������˽�2����������¼��ǰ���Ϊ2*1=2��

��2�滻Ϊ1���½�ջ��s={1,1}, result = 2

��3��5��1������������������ջ��s={1,1,5},result = 2

��4��6��5������������������ջ��s={1,1,5,6},result = 2

��5��2��6С��������������������˽�6����������¼��ǰ���Ϊ6*1=6��s={1,1,5},result = 6

2��5С��������������������˽�5����������¼��ǰ���Ϊ5*2=10����Ϊ�Ѿ�������5,6������ģ���s={1,1},result = 10

2��1�󣬽�������5,6�滻Ϊ2���½�ջ��s={1,1,2,2,2},result = 10

��6��3��2������������������ջ��s={1,1,2,2,2,3},result = 10

ջ������ɣ�����������������˰���������취�õ�������max(height[i]*(size-i))=max{3*1, 2*2, 2*3, 2*4, 1*5, 1*6}=8<10

����������result=10
��˼·��������
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        int ret = 0;
        stack<int> stk;
        for(int i = 0; i < height.size(); i ++)
        {
            if(stk.empty() || stk.top() <= height[i])
                stk.push(height[i]);
            else
            {
                int count = 0;
                while(!stk.empty() && stk.top() > height[i])
                {
                    count ++;
                    ret = max(ret, stk.top()*count);
                    stk.pop();
                }
                while(count --)
                    stk.push(height[i]);
                stk.push(height[i]);
            }
        }
        int count = 1;
        while(!stk.empty())
        {
            ret = max(ret, stk.top()*count);
            stk.pop();
            count ++;
        }
        return ret;
    }
};

�򻯰汾
class Solution {
public:
    int largestRectangleArea(vector<int>& heights)
    {
        heights.push_back(0);
        int sz=heights.size();
        if(sz==1)
            return 0;
        if(sz==2)
            return heights[0];

        stack<int> s;
        int i=0,h=0,j=0,max_area=0;
        while(i<sz)
        {
            if(s.empty()||heights[s.top()]<=heights[i])
                s.push(i++);
            else
            {
                h=heights[s.top()];
                s.pop();
                j= s.empty()?-1:s.top();
                if(max_area<h*(i-j-1))
                    max_area=h*(i-j-1);
            }
        }
        return max_area;
    }
};
