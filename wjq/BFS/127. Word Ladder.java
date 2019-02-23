127. Word Ladder

        Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

        Only one letter can be changed at a time.
        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
        Note:

        Return 0 if there is no such transformation sequence.
        All words have the same length.
        All words contain only lowercase alphabetic characters.
        You may assume no duplicates in the word list.
        You may assume beginWord and endWord are non-empty and are not the same.
        Example 1:

        Input:
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        Output: 5

        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.
        Example 2:

        Input:
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log"]

        Output: 0

        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


BFS思路
class Solution {
    public int ans = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord))
            return 0;
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
                for(int i=0;i<each.length();i++){
                    char[] each_char = each.toCharArray();
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