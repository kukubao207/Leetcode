310. Minimum Height Trees

For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

0
|
1
/ \
2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

0  1  2
\ | /
3
|
4
|
5
return [3, 4]

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.


题意
给定一个无向图,找出满足要求的节点,使得以这些节点为根节点时,该图作为树具有最小的高度.

思路
从节点0开始搜索,BFS算法求出最远的那个节点(即最后一层的元素中的任意一个),方便起见,直接用最后一层最后一个出队的元素.
从第一次BFS最远的节点开始,再次BFS搜索整个图,找出最远的节点,并保存从 第一次BFS的最远节点到 第二次BFS的最远节点 的路径.
如果该路径上节点个数为奇数,直接返回该路径中间的节点,
如果该路径上节点个数为偶数,则返回该路径中间的两个节点.

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //边界情况处理
        List<Integer> list = new ArrayList<>();
        if(edges.length==0)
        {
            List<Integer> l = new ArrayList<>();
            l.add(0);
            return l;
        }
        
        //建图
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        //通过两次BFS求出图中最长的路径(其实只是求出了前驱节点数组)
        int []prev = new int[n];
        Arrays.fill(prev,-1);
        int endNode1=bfs(0,graph,prev);
        Arrays.fill(prev,-1);
        int endNode2=bfs(endNode1,graph,prev);
        
        //通过prev[]前驱节点数组求出该路径
        List<Integer> path = new ArrayList<>();
        int temp = endNode2;
        while(temp!=endNode1){
            path.add(temp);
            temp=prev[temp];
        }
        path.add(endNode1);
        
        //求出该路径的中心点.
        list.add(path.get(path.size()/2));
        if(path.size()%2==0)
            list.add(path.get(path.size()/2-1));
        return list;
        
    }
    int bfs(int start,Map<Integer, ArrayList<Integer>> graph,int prev[]){
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        prev[start]=start;
        int cur = start;
        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int i=0;i<graph.get(cur).size();i++){
                int to = graph.get(cur).get(i);
                if(prev[to]==-1){
                    queue.offer(to);
                    prev[to]=cur;
                }
            }
        }
        return cur;
    }
}

别人的思路
OK. Let's stop here and look at our problem.

Our problem want us to find the minimum height trees and return their root labels. First we can think about a simple case -- a path graph.
题意要求我们去找出最小高度的树并返回他的根节点.我们先考虑简单的情况,只有一条路径的图.

For a path graph of n nodes, find the minimum height trees is trivial. Just designate the middle point(s) as roots.
对于图中的n个节点,找出最小高度的树非常简单.只要把路径中间的点作为根即可.

Despite its triviality, let design a algorithm to find them.
即使这非常简单,我们也要设计一个算法来找到中间的根节点.

Suppose we don't know n, nor do we have random access of the nodes. We have to traversal. It is very easy to get the idea of two pointers. One from each end and move at the same speed. When they meet or they are one step away, (depends on the parity of n), we have the roots we want.
假设我们不知道n,也不知道下一个访问的节点是谁,我们需要搜索.因此我们需要通过双指针进行搜索,从该路径的两边以同样的速度向中间运动,
只要他们相遇或者只差一步,那就停止运动,指针停的位置就是我们要找的根节点.

This gives us a lot of useful ideas to crack our real problem.
现在给出一些有用的想法来解决我们真实的问题

For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves). We let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two pointers meet or one step away we then find the roots.
对于一棵树,我们可以做一些一样的事,我们从每一个度为1的节点(叶子节点)开始,让这些指针以同样的速度运动,当两个指针相遇时,我们只保存他们其中之一,直到最后个两个指针相遇或者只差一步,我们就找到了根节点.

It is easy to see that the last two pointers are from the two ends of the longest path in the graph.
最后两个相遇的指针一定是从图中最远的一条路径的头尾开始的.

The actual implementation is similar to the BFS topological sort. Remove the leaves, update the degrees of inner vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!
算法的实现非常与拓扑排序非常相似,删除叶子节点,更新里面的节点的度数,再删除新的叶子节点,直到最后只剩下两个或一个节点.这就是我们要的根节点.

The time complexity and space complexity are both O(n).
时间复杂度和空间复杂度均为O(n)

Note that for a tree we always have V = n, E = n-1.


public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1)
        return Collections.singletonList(0);

    List<Set<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; ++i)
        adj.add(new HashSet<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; ++i)
        if (adj.get(i).size() == 1)
            leaves.add(i);
    while (n > 2) {
        n -= leaves.size();                             //从n个节点中删去叶子节点
        List<Integer> newLeaves = new ArrayList<>();    //初始化新叶子节点集合
        for (int i : leaves) {                          //对于每个删掉的叶子节点i
            int j = adj.get(i).iterator().next();       //令j= i的邻接表中某h个节点的编号
            adj.get(j).remove(i);                       //从j节点的邻接表中删除i
            if (adj.get(j).size() == 1)                 //如果删掉i之后 j的邻接表为1,把j加入新叶子节点集合
                newLeaves.add(j);
        }
        leaves = newLeaves;                             //更新叶子节点集合
    }
    return leaves;
}


根据别人的思路改成我的版本

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);
        
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        //求出当前叶子节点集合
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1)
                leaves.add(i);
        }
        
        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i : leaves){
                int j=graph.get(i).get(0);                         //既然是叶子节点,邻接表中只有一个元素j
                graph.get(j).remove(graph.get(j).indexOf(i));      //从j元素的邻接表中删除i
                if(graph.get(j).size()==1)
                    newLeaves.add(j);
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}
