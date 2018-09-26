316. Remove Duplicate Letters

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

����˼·
����˼����ά��һ���ַ��ĵ���ջ��
ÿ��������ջ��Ԫ��С���ַ���������ַ����󲿷��Ƿ��и�Ԫ�أ�
����еĻ��������ַ�С��Ҫ����ǰ�棬����ջ�����Ԫ�غ��滹�����������ھ��ȳ�ջ�ɡ�
�������ջ��Ԫ�أ�ֱ��ջΪ�ջ�ջ���Ѿ��ȵ�ǰԪ��СΪֹ��
���ǰԪ����ջ����Ǹ�Ԫ�ط��ʹ��ˣ����������Ͳ���Ҫ���м���ˡ�
(����abcabc����Ȼ�ڶ���a��cС�����ǲ�����ջ����������ˣ���Ϊa�Ѿ���ջ�У���������һ��ջ��û�е�Ԫ�أ���Ҫ�жϵġ�)

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



