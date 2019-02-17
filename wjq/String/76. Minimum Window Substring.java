76. Minimum Window Substring

        Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

        Example:

        Input: S = "ADOBECODEBANC", T = "ABC"
        Output: "BANC"
        Note:

        If there is no such window in S that covers all characters in T, return the empty string "".
        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


思路
双指针 结合 HashMap

class Solution {
    public String minWindow(String s, String t) {
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<t.length();i++)
            m.put(t.substring(i,i+1),m.getOrDefault(t.substring(i,i+1),0)+1);
        int begin=0,end=0,head=0;
        int d=Integer.MAX_VALUE;
        int counter = t.length();
        while(end<s.length()){
            String end_str = s.substring(end,end+1);
            if(m.getOrDefault(end_str,0)>0)
                counter--;
            m.put(end_str,m.getOrDefault(end_str,0)-1);
            end++;
            while(counter==0){
                String begin_str = s.substring(begin,begin+1);
                if(end-begin<d){
                    d= end - (head=begin);
                }
                if(m.getOrDefault(begin_str,0)==0){
                    counter++;
                }
                m.put(begin_str,m.getOrDefault(begin_str,0)+1);
                begin++;
            }
        }
        return d==Integer.MAX_VALUE?"":s.substring(head,head+d);
    }
}

找子串问题的模板
int findSubstring(string s){
    vector<int> map(128,0);
    int counter; // check whether the substring is valid
    int begin=0, end=0; //two pointers, one point to tail and one  head
    int d; //the length of substring
    for() {
        /* initialize the hash map here */
    }
    while(end<s.size()){
        if(map[s[end++]]-- ?){
            /* modify counter here */
        }
        while(/* counter condition */){
            /* update d here if finding minimum*/
            //increase begin to make it invalid/valid again
            if(map[s[begin++]]++ ?){
                /*modify counter here*/
            }
        }
        /* update d here if finding maximum*/
    }
    return d;
}