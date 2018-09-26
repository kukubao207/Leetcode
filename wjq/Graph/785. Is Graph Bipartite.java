785. Is Graph Bipartite?

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.


Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

题意
给定一个图,判断该图的顶点能否被分成两个集合S和V,使得该图中所有的边都满足一个条件,
边的一个顶点在集合S中,另一个顶点在集合V中.

思路
DFS搜索整个图,给每一个图中顶点标记1和-1.
1代表集合S,-1代表集合V,如果所有标记都不会冲突,那说明这是一个满足题意的图.
标记的方法在于,对当前顶点标记1,则该顶点的所有相邻顶就标记为-1.
递归的边界条件就是 碰到一个顶点被标记过时,返回 顶点上的标记 和 当前想要做的标记 是否相等,相同说明不冲突,否则冲突.

代码
class Solution {
    public boolean isBipartite(int[][] graph) {
        int colors[] = new int[graph.length];
        Arrays.fill(colors,0);
        for(int i=0;i<graph.length;i++)
        {
            if(colors[i]==0&&!dfs(i,graph,1,colors))
                return false;
        }
        return true;
    }
    boolean dfs(int start,int[][] graph,int color,int[] colors){
        if(colors[start]!=0)
            return colors[start] == color;
        
        colors[start]=color;
        for(int i=0;i<graph[start].length;i++){
            if(dfs(graph[start][i],graph,-1*color,colors)==false)
                return false;
        }
        return true;
    }
}

最近刚开始写Java代码,非常不习惯,今天遇到一个坑点,标记一下,
在C++中的函数中,数组的传递可以是值传递,也可以是地址传递.
比如对于一个C++的函数
int setOne(int a[])
{
    a[0]=1;
}
在别的函数中调用setOne函数,对a数组进行修改,这里是值传递,不会影响原函数中a[0]的值,
而在Java中,就会影响原函数中a[0]的值了.

这是因为在Java中,当函数传递的基本数据类型(int,double,float)等时,是值传递,
如果函数传递不是基本数据类型,那就是引用传递,引用指向内存空间,那么对该引用指向的元素进行操作,
就相当于对内存空间里的元素的操作,则会影响原来的函数中的值.

java 使用值传参（pass_by_value）的方式来传递函数参数，只是值传递方式在处理原始数据类型参数与引用类型参数时候有不同，如果一个参数是原始数据类型，那么参数变量的值传递进去。如果是引用类型，是传进了引用变量的值（也就是说，只是将指向数据的引用的值给传进去了，也就是被调用的函数新建的空间放的是这个引用的值，那么也就是也指向了数组存在的内存），所以同样是值传递，引用类型的传入的当然是引用变量的值，指向了同一数组，那么函数内对数组进行的修改在函数退出后依旧是有效的。