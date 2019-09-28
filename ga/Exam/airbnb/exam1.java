package Exam.airbnb;

import java.util.*;

/**
 *邻接表 Map<String, Set<String>> / Map<String, LinkedList<String>>
 邻接矩阵 int[][]  + Map<String, Integer> (把字符串从String映射到Int)
 */
public class exam1 {
    public static void main(String[] args) {
        //1. build graph
        List<String> l = new ArrayList<>();
        l.add("A,E,N,S");
        l.add("S,H,N");
        l.add("E,N");
        l.add("H");
        l.add("N");
        System.out.println(costsOfNodes(l));
    }

    //构造图
    static HashMap<String, LinkedList<String>> graph = new HashMap<>();
    static HashMap<String, Integer> ans = new HashMap<>();
    static int count = 0;

    public static List<String> costsOfNodes(List<String> lines) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (lines == null || lines.size() == 0)
            return res;
        for(String line: lines){
            String[] str = line.split(",");
            graph.put(str[0], new LinkedList<>());
        }
        for(String line: lines){
            String[] str = line.split(",");
            for(int i = 1; i <str.length; i++){
               graph.get(str[i]).add(str[0]);
            }
        }
        for(String s: graph.keySet()){
            count = 0;
            HashMap<String, Boolean> vis = new HashMap<>();
            dfs(graph, vis, s, s);
        }
        Object[] key_arr = ans.keySet().toArray();
        Arrays.sort(key_arr);
        for  (Object key : key_arr) {
            String r = key + "," + ans.get(key);
            res.add(r);
        }
        return res;
    }


    public static void dfs(HashMap<String, LinkedList<String>> graph, HashMap<String, Boolean> vis, String start, String key){
        if(!vis.containsKey(start)){
            vis.put(start, true);
            ans.put(key, ++count);
            for(String s: graph.get(start)){
                if(!vis.containsKey(s)){
                    dfs(graph, vis, s, key);
                }
            }
        }
    }


}
