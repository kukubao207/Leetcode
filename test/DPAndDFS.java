import java.util.ArrayList;
import java.util.List;

public class DPAndDFS {
    public static void main(String[] args){
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = new ArrayList<>();
        for(String str:wordDict){
            list.add(str);
        }
        Solution.wordBreak(s,list);
    }
    public static class Solution {
        // c  a  t    s    a  n  d       d  o  g
        // [] [] [0]  [0]  [] [] [3,4]   [] [] [7]
        private static List<String> res = new ArrayList<>();
        public static List<String> wordBreak(String s, List<String> wordDict) {
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
                        index.get(i).add(j);
                    }
                }
            }
            dfs(s,new String(""),index,s.length()-1);
            return res;
        }
        public static void dfs(String s,String temp,List<ArrayList<Integer>> index,int start){
            List<Integer> idx = index.get(start);
            for(int i=0;i<idx.size();i++){
                int before = idx.get(i);
                if(before==0){
                    temp = temp + s.substring(before,start+1);
                    res.add(temp);
                    return;
                }
                temp = temp + " " + s.substring(before,start+1);
                dfs(s,temp,index,before-1);

            }
        }
    }

//     1    1        1           1


// 0 1 2 3   4 5 6 7 8    9 10 11    12 13 14 15 16
// p i n e   a p p l e    p e  n     a  p  p  l  e
//       [0]         [0,4]     [4,9]             [12]

// 12(11) ->  4(3)   ->0
//        ->  9(8)   ->0
//                   ->4(3)   ->0
}
