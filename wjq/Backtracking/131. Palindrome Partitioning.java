131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
    ["aa","b"],
    ["a","a","b"]
]


class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(),0,s);
        return res;
    }
    public void dfs(List<String> temp,int start,String s){
        if(start==s.length()){
            res.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=start;i<s.length();i++){
            if(!isPalindrome(s.substring(start,i+1)))
                continue;
            temp.add(s.substring(start,i+1));
            dfs(temp,i+1,s);
            temp.remove(temp.size()-1);
        }
    }
    public boolean isPalindrome(String a){
        StringBuilder sb = new StringBuilder(a);
        return a.equals(sb.reverse().toString());
    }
}