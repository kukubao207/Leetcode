402. Remove K Digits

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


我的思路
维护一个递增栈，一旦遇到比栈顶元素小的，不断弹出该元素直到k为0.
如果一次遍历后k比0大，说明序列本身的递增性非常好，只有少于k个元素不是递增排列的，这时候只要从栈顶弹出元素直到k为0就可以。
如果一次遍历后i还没有到达num.length(),说明k已经到0了，该删的元素已经删完了，只要把后面的元素push进栈即可。
边界条件是"00100"、"0000"这样的元素要去掉前导零。
class Solution {
public:
    string removeKdigits(string num, int k) {
        stack<int> s;
        int i=0;
        for(;i<num.length()&&k>0;i++)
        {
            while(!s.empty()&&s.top()>(num[i]-'0')&&k>0)
            {
                s.pop();
                k--;
            }
            s.push(num[i]-'0');
        }
        while(!s.empty()&&k>0)
        {
            s.pop();
            k--;
        }
        while(i<num.length())
        {
            s.push(num[i]-'0');
            i++;
        }
        string res="";
        while(!s.empty())
        {
            res=to_string(s.top())+res;
            s.pop();
        }
        i=0;
        for(;i<res.length();i++)
        {
            if(res[i]!='0')
                return res.substr(i);
        }
        return (res==""||i==res.length())?"0":res;
    }
};
别人的做法
思路一致，但代码精简
class Solution {
public:
    string removeKdigits(string num, int k) {
        string result;
        auto it = num.begin();
        int keep = num.size() - k;
        while (k > 0 && it != num.end())
        {
            while (!result.empty() && result.back() > *it && k > 0)
            {
                result.pop_back();
                k --;
            }
            result.push_back(*it);
            it ++;
        }

        result += string(it, num.end());
        result = result.substr(0, keep);
        it = result.begin();
        while (it != result.end() && *it == '0')
            it ++;
        result = string(it, result.end());
        return result.empty() ? "0" : result;
    }
};
