84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10

这道题没有做出来，网上看到一种借助栈的做法，代码很漂亮，但是解释都非常模糊，我看懂之后，决定仔细描述思路如下：

1、如果已知height数组是升序的，应该怎么做？

比如1,2,5,7,8

那么就是(1*5) vs. (2*4) vs. (5*3) vs. (7*2) vs. (8*1)

也就是max(height[i]*(size-i))

2、使用栈的目的就是构造这样的升序序列，按照以上方法求解。

但是height本身不一定是升序的，应该怎样构建栈？

比如2,1,5,6,2,3

（1）2进栈。s={2}, result = 0

（2）1比2小，不满足升序条件，因此将2弹出，并记录当前结果为2*1=2。

将2替换为1重新进栈。s={1,1}, result = 2

（3）5比1大，满足升序条件，进栈。s={1,1,5},result = 2

（4）6比5大，满足升序条件，进栈。s={1,1,5,6},result = 2

（5）2比6小，不满足升序条件，因此将6弹出，并记录当前结果为6*1=6。s={1,1,5},result = 6

2比5小，不满足升序条件，因此将5弹出，并记录当前结果为5*2=10（因为已经弹出的5,6是升序的）。s={1,1},result = 10

2比1大，将弹出的5,6替换为2重新进栈。s={1,1,2,2,2},result = 10

（6）3比2大，满足升序条件，进栈。s={1,1,2,2,2,3},result = 10

栈构建完成，满足升序条件，因此按照升序处理办法得到上述的max(height[i]*(size-i))=max{3*1, 2*2, 2*3, 2*4, 1*5, 1*6}=8<10

综上所述，result=10
该思路代码如下
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

简化版本
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
