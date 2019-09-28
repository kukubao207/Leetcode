package Graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 图的dfs
 * DFS就是利用递归+回溯，直到递归到没有相邻节点可以访问了，就向上回溯。
 */
public class DFS {
    public static void main(String[] args) {
        //构造各顶点
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('v');
        list_u.add('x');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('y');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('x');
        LinkedList<Character> list_x = new LinkedList<Character>();

        //构造图
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('u', list_u);
        graph.put('v', list_v);
        graph.put('y', list_y);
        graph.put('x', list_x);

        HashMap<Character, Boolean> visited = new HashMap<Character, Boolean>();
        //遍历的起始点
        char start = 'u';
        //调用深度优先遍历方法
        dfs(graph, visited, start);
    }
    private static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited,
                              char start) {
        if (!visited.containsKey(start)) {
            System.out.println("element: " + start );// 记录节点
            visited.put(start, true);
            for (char c : graph.get(start)) {
                if (!visited.containsKey(c)) {
                    dfs(graph, visited, c);// 递归访问其邻近节点
                }
            }
        }
    }
}
