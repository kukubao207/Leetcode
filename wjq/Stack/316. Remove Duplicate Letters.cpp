316. Remove Duplicate Letters

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

解题思路
核心思想是维持一个字符的递增栈。
每当遇到比栈顶元素小的字符，检查下字符串后部分是否还有该元素，
如果有的话，由于字符小的要排在前面，而且栈顶这个元素后面还能遇到，现在就先出栈吧。
继续检查栈顶元素，直到栈为空或栈顶已经比当前元素小为止。
最后当前元素入栈，标记该元素访问过了，再遇到，就不需要进行检查了。
(考虑abcabc，虽然第二个a比c小，但是不会做栈顶递增检查了，因为a已经在栈中，除非是来一个栈中没有的元素，才要判断的。)

class Solution {
public:
    string removeDuplicateLetters(string s) {
        if(s=="")
            return "";
        map<char,int> counter;
        map<char,bool> visited;
        string res="";
        for(int i=0;i<s.length();i++)
            counter[s[i]]++;
        for(int i=0;i<s.length();i++)
        {
            counter[s[i]]--;
            if(visited[s[i]])
                continue;
            while(!res.empty()&&res.back()>s[i]&&counter[res.back()]>0)
            {
                visited[res.back()]=false;
                res.pop_back();
            }
            res=res+s[i];
            visited[s[i]]=true;
        }
        return res;
    }
};



