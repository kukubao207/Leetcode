import java.util.*;

public class Test {
    private static class TreeNode {
        int maxValue;
        List<TreeNode> child = new ArrayList<>();

    }

    public static void main(String[] args) {
        int numNodes = 6;
        int sourceNode = 4;
        ArrayList<ArrayList<Integer>> net = new ArrayList<>();
        int[][] network = {{4, 2, 10}, {4, 6, 20}, {4, 1, 30}, {1, 3, 50}, {1, 5, 80}};
        for (int i = 0; i < network.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < network[i].length; j++)
                temp.add(network[i][j]);
            net.add(temp);
        }
        System.out.println(calculateMaxOil(numNodes, sourceNode, net));
    }

    public static int calculateMaxOil(int numNodes, int sourceNode, ArrayList<ArrayList<Integer>> network) {
        int[][] g = new int[numNodes][numNodes];
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[i].length; j++)
                g[i][j] = -1;
        for (ArrayList<Integer> t : network) {
            g[t.get(0) - 1][t.get(1) - 1] = g[t.get(1) - 1][t.get(0) - 1] = t.get(2);
        }
        boolean[][] vis = new boolean[numNodes][numNodes];
        int res = maxToParent(g, sourceNode - 1, vis);
        return res;
    }

    public static int maxToParent(int[][] g, int from, boolean[][] vis) {
        int count = 0;
        for (int i = 0; i < g[from].length; i++) {
            if (g[from][i] != -1)
                count++;
        }
        if (count == 1) {
            return Integer.MAX_VALUE;
        }
        int curSum = 0;
        for (int to = 0; to < g[from].length; to++) {
            if (vis[from][to] == true || g[from][to] == -1)
                continue;
            vis[from][to] = vis[to][from] = true;
            int temp = maxToParent(g, to, vis);
            curSum += Math.min(temp, g[from][to]);
        }
        return curSum;

    }
}
