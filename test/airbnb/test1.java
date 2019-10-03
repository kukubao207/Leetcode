package airbnb;

import java.util.*;

public class test1 {

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

    private static Map<String, Set<String>> ans = new HashMap<>();
    private static Map<String, List<String>> G = new HashMap<>();

    private static void dfs(String from) {
        if (ans.get(from).size() > 0) {
            return;
        }
        ans.get(from).add(from);
        for (String to : G.get(from)) {
            dfs(to);
            ans.get(from).addAll(ans.get(to));
        }
    }

    public static List<String> costsOfNodes(List<String> lines) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (lines == null || lines.size() == 0)
            return res;
        for (String line : lines) {
            String[] strs = line.split(",");
            for (String str : strs) {
                if (!ans.containsKey(str)) {
                    ans.put(str, new HashSet<>());
                }
                if (!G.containsKey(str)) {
                    G.put(str, new ArrayList<>());
                }
            }

            for (int j = 1; j < strs.length; ++j) {
                G.get(strs[j]).add(strs[0]);
            }
        }
        List<String> ms = new ArrayList<>();
        ms.addAll(ans.keySet());
        for (String m : ms) {
            dfs(m);
        }
        Collections.sort(ms);
        for (String m : ms) {
            res.add(m + "," + ans.get(m).size());
        }
        return res;
    }
}
