140. Word Break II


        Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.
        Example 1:

        Input:
        s = "catsanddog"
        wordDict = ["cat", "cats", "and", "sand", "dog"]
        Output:
        [
        "cats and dog",
        "cat sand dog"
        ]
        Example 2:

        Input:
        s = "pineapplepenapple"
        wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
        Output:
        [
        "pine apple pen apple",
        "pineapple pen apple",
        "pine applepen apple"
        ]
        Explanation: Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input:
        s = "catsandog"
        wordDict = ["cats", "dog", "sand", "and", "cat"]
        Output:
        []


思路

DP+回溯
通过DP 记录每一个节点的前驱节点的下标
回溯法从后往前搜索下标构造
// 测试用例1
// c  a  t    s    a  n  d       d  o  g
// [] [] [0]  [0]  [] [] [3,4]   [] [] [7]


// 测试用例2
// 0 1 2 3   4 5 6 7 8    9 10 11    12 13 14 15 16
// p i n e   a p p l e    p e  n     a  p  p  l  e
//       [0]         [0,4]     [4,9]             [12]

// 12(11) ->  4(3)   ->0
//        ->  9(8)   ->0
//                   ->4(3)   ->0

class Solution {

    private List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<ArrayList<Integer>> index = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            index.add(new ArrayList<>());
        }
        for(int i=0;i<s.length();i++){
            if(wordDict.contains(s.substring(0,i+1))){
                index.get(i).add(0);
            }
            for(int j=0;j<i;j++){
                if(index.get(j).size()!=0&&wordDict.contains(s.substring(j+1,i+1))){
                    index.get(i).add(j+1);
                }
            }
        }
        dfs(s,new String(""),index,s.length()-1);
        return res;
    }
    public void dfs(String s,String temp,List<ArrayList<Integer>> index,int start){
        if(start==-1){
            res.add(temp);
            return;
        }
        List<Integer> idx = index.get(start);
        for(int i=0;i<idx.size();i++){
            int before = idx.get(i);
            String record = new String(temp);
            if(start==s.length()-1)
                temp=s.substring(before,start+1);
            else
                temp=s.substring(before,start+1)+ " "+temp;
            dfs(s,temp,index,before-1);
            temp = record;
        }
    }
}
