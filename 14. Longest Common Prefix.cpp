#include <iostream>
using namespace std;
string longestCommonPrefix(vector<string>& strs)
{
    if(strs.size()==0)
        return "";
    int shortestStr=strs[0].size();
    for(int i=0;i<strs.size();i++)
        if(strs[i].size()<shortestStr)
            shortestStr=strs[i].size();

    string comPrefix="";
    int pos=0,numOfStr=strs.size();
    bool flag=true;
    while(pos<shortestStr)
    {
        for(int i=0;i<numOfStr;i++)
            if(strs[i][pos]!=strs[0][pos])
                flag=false;
        if(flag==false)
            break;
        comPrefix+=strs[0].substr(pos,1);
        pos++;
    }
    return comPrefix;
}
int main()
{
    return 0;
}
