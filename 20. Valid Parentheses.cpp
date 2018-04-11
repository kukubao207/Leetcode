class Solution {
public:
    bool isValid(string s) {
        int j=0;
        stack<char> sta;
        while(j<s.length())
        {
            if(s[j]=='('||s[j]=='{'||s[j]=='[')
                sta.push(s[j]);
            else
                if(sta.empty())
                    return false;
                else if((sta.top()=='('&&s[j]==')')||(sta.top()=='{'&&s[j]=='}')||(sta.top()=='['&&s[j]==']'))
                    sta.pop();
                else
                    return false;
            j++;
        }
        return sta.empty();
    }
};
