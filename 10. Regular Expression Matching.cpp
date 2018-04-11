#include <iostream>
using namespace std;

//s和p是完全相同的字符串时才能返回True
bool isMatch(string s, string p) {
    if(p.empty())
        return s.empty();
    bool first_match=(!s.empty()&&(s[0]==p[0]||p[0]=='.'));
    if(p.length()==1)
    {
        if(s.length()>1)
            return false;
        if(s.length()==1)
            return first_match;
    }
    if(p[1]=='*')
        return (first_match && isMatch(s.substr(1),p))||isMatch(s,p.substr(2));
    else if(p[1]!='*')
        return first_match && isMatch(s.substr(1),p.substr(1));
}
int main()
{
    return 0;
}
