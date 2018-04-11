class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        addPar(res,"",n,0);
        return res;
    }
    void addPar(vector<string> &s,string str,int n,int m)
    {
        if(n==0&m==0)
        {
            s.push_back(str);
            return;
        }
        if(m>0)
            addPar(s,str+")",n,m-1);
        if(n>0)
            addPar(s,str+"(",n-1,m+1);
    }
};
