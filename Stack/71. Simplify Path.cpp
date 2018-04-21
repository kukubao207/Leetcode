71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.

Corner Cases:





Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

我的思路
class Solution {
public:
    string simplifyPath(string path) {
        int len=path.length();
        stack<string> s;
        for(int i=0;i<len;i++)
        {
            if(path[i]=='/')
                continue;

            string temp="";
            while(path[i]!='/'&&i<len)
            {
                temp+=path.substr(i,1);
                i++;
            }
            i--;

            if(temp==".."&&!s.empty())
                s.pop();
            else if(temp!="."&&temp!=".."&&temp!="")
                s.push(temp);
        }
        string res="";
        bool flag=s.empty();
        while(!s.empty())
        {
            res="/"+s.top()+res;
            s.pop();
        }
        return flag?"/":res;
    }
};
别人的思路
class Solution {
public:
    string simplifyPath(string path)
    {
        string res, tmp;
        vector<string> stk;
        stringstream ss(path);
        while(getline(ss,tmp,'/'))
        {
            if (tmp == "" or tmp == ".")
                continue;
            if (tmp == ".." and !stk.empty())
                stk.pop_back();
            else if (tmp != "..")
                stk.push_back(tmp);
        }
        for(auto str : stk)
            res += "/"+str;
        return res.empty() ? "/" : res;
    }
};

