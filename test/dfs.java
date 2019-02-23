import java.util.ArrayList;
import java.util.List;

public class dfs {
    public static void main(String[] args){
        List<String> list= new ArrayList<>();
        list.add("hot");
        //list.add("dot");
        list.add("dog");
        //list.add("lot");
        //list.add("log");
        //list.add("cog");
        String beginWord="hot";
        String endWord="dog";
        int res = Solution.ladderLength(beginWord,endWord,list);
        System.out.println(res);
    }
    public static class Solution {
        public static int ans = Integer.MAX_VALUE;
        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord))
                return 0;
            //build graph
            if(!wordList.contains(beginWord)){
                wordList.add(0,beginWord);
            }
            int[][] graph = new int[wordList.size()][wordList.size()];
            for(int i=0;i<wordList.size();i++){
                for(int j=i+1;j<wordList.size();j++){
                    if(canBuild(wordList.get(i),wordList.get(j))){
                        graph[i][j]=1;
                        graph[j][i]=1;
                    }
                }
            }
            boolean[] vis = new boolean[wordList.size()];
            dfs(graph,vis,wordList.indexOf(beginWord),wordList.indexOf(endWord),1);
            //bfs graph
            return ans==Integer.MAX_VALUE?0:ans;
        }
        public static boolean canBuild(String a,String b){
            int count = 0;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i))
                    count++;
                if(count>=2)
                    return false;
            }
            return true;
        }
        public static void dfs(int[][] graph,boolean[] vis,int start,int end,int depth){
            vis[start]=true;
            if(start==end){
                ans=Math.min(depth,ans);
                return ;
            }
            for(int i=0;i<graph[0].length;i++){
                if(graph[start][i]==0||vis[i]==true)
                    continue;
                dfs(graph,vis,i,end,depth+1);
                vis[i]=false;
            }
        }
    }
}
