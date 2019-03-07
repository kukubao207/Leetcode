17. Letter Combinations of a Phone Number

        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


        Example:

        Input: "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        Note:

        Although the above answer is in lexicographical order, your answer could be in any order you want.


就是求Combinations ，和求Permutations差不多。
class Solution {

    public List<String> letterCombinations(String digits) {
        //1. empty digits
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;

        //2.
        res.add(new String(""));
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<digits.length();i++){
            String s = str[digits.charAt(i)-'0'];
            List<String> new_res = new ArrayList<>();
            for(String ss:res){
                for(int j=0;j<s.length();j++){
                    new_res.add(ss + s.charAt(j));
                }
            }
            res = new_res;
        }
        return res;
    }

}

class Solution {
    private String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        //1. empty digits
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;

        //2. dfs
        dfs(new String(""),0,res,digits);
        return res;
    }

    public void dfs(String temp,int pos,List<String> res,String digits){
        if(pos==digits.length()){
            res.add(new String(temp));
            return;
        }
        String s = str[digits.charAt(pos)-'0'];
        for(int i=0;i<s.length();i++){
            dfs(temp+s.charAt(i),pos+1,res,digits);
        }
    }
}