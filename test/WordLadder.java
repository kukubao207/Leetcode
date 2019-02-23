import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args){
        List<String> list= new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        String beginWord="hit";
        String endWord="cog";
        int res = Solution.ladderLength(beginWord,endWord,list);
    }
    public static class Solution {
        public static int ans = Integer.MAX_VALUE;
        public static int ladderLength(String beginWord, String endWord, List<String> wordList){
            Set<String> reached = new HashSet<>();
            Set<String> not_reached = new HashSet<>();
            for(String s:wordList){
                not_reached.add(s);
            }
            not_reached.add(endWord);
            reached.add(beginWord);
            int dist = 1;
            while(!reached.contains(endWord)){
                Set<String> toAdd = new HashSet<>();
                for(String each:reached){
                    char[] each_char = each.toCharArray();
                    for(int i=0;i<each.length();i++){
                        for(char c='a';c<='z';c++){
                            each_char[i]=c;
                            String temp = new String(each_char);
                            if(not_reached.contains(temp)){
                                toAdd.add(temp);
                                not_reached.remove(temp);
                            }
                        }
                    }
                }
                if(toAdd.size()==0)
                    return 0;
                dist++;
                reached = toAdd;
            }
            return dist;
        }
    }
}
