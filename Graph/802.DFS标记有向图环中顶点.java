802. Find Eventual Safe States

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Note:

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].

题意
给定以邻接表表示的图(图中可能有顶点不可达),找出"安全"的顶点,
图中环路上的顶点均"不安全",非环路上的顶点均"安全".

思路
通过DFS和标记法结合搜索整个图.
0表示未访问过的顶点,
1表示安全的顶点,
2表示环路上的顶点
递归的思路在于,每当遇到一个顶点,先给该顶点标记为2,
如果该顶点的邻接顶点递归结果均返回true,
那说明所有邻接顶点都是安全顶点,
那这时候自身也就是安全顶点了,
在递归完子节点后并子节点均"安全"后,
标志该顶点为1,并返回true.
递归的边界条件是,如果一个顶点身上的标记不为0,说明该顶点被访问过,
如果该顶点标记的是1,返回true,标记的是2,返回false.

class Solution {
    //0 represent unvisited,1 represnt safe,2 represent not safe.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,0);
        for(int i=0;i<graph.length;i++)
            if(color[i]==0)
                dfs(graph,color,i);
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<graph.length;i++)
            if(color[i]==1)
                res.add(i);
        Collections.sort(res);
        return res;
    }
    boolean dfs(int[][] graph,int[] color,int start){
        if(color[start]!=0)
            return color[start]==1;
        color[start]=2;
        for(int to : graph[start]){
            if(dfs(graph,color,to)==false)
                return false;
        }
        color[start]=1;
        return true;
    }
}