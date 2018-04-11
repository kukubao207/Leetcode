class Solution {
public:
    int strStr(string haystack, string needle)
    {
        int hL=haystack.length(),nL=needle.length();
        if(nL==0)
            return 0;
        for(int i=0;i<hL-nL+1;i++)
        {
            int j=0;
            for(;j<nL;j++)
                if(haystack[i+j]!=needle[j])
                    break;
            if(j==nL)
                return i;
        }
        return -1;
    }
};
