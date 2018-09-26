402. Remove K Digits

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be �� k.
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


�ҵ�˼·
ά��һ������ջ��һ��������ջ��Ԫ��С�ģ����ϵ�����Ԫ��ֱ��kΪ0.
���һ�α�����k��0��˵�����б���ĵ����Էǳ��ã�ֻ������k��Ԫ�ز��ǵ������еģ���ʱ��ֻҪ��ջ������Ԫ��ֱ��kΪ0�Ϳ��ԡ�
���һ�α�����i��û�е���num.length(),˵��k�Ѿ���0�ˣ���ɾ��Ԫ���Ѿ�ɾ���ˣ�ֻҪ�Ѻ����Ԫ��push��ջ���ɡ�
�߽�������"00100"��"0000"������Ԫ��Ҫȥ��ǰ���㡣
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
���˵�����
˼·һ�£������뾫��
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
