332. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

题意
给出一些列的 [出发点,目的地]集合,求出遍历所有路径的一个路径,
要求:每到一个目的地,选择一下个目的地 应按照字符串字典序从小到大来选择.

思路
典型的欧拉回路问题,优先队列用来处理本题欧拉回路意外的逻辑.
深度优先搜索+优先队列(小根堆)

1.通过邻接表建图 Map<String, PriorityQueue<String>> graph;

2.每到一个节点,对该节点关联的所有点做以下操作
    从该节点对应的队列中(弹出)一个被关联的点,
    (弹出一个被关联的点就 相当于 删去一条图中的边,因为优先级队列的特性,
    每次删去的边(弹出的队头元素)都是字符串字典序最小的那条边),
    并递归该被关联的点.
如果该节点不再有任意一个关联的点(不再有可以访问的边),则把该点加入List的下标为0位置.
这样子每次回溯到上一层,只有上一层的节点不再有关联的点,才加入List下标为0的位置,最终就能得到一条欧拉路径.


代码
class Solution {
    Map<String,PriorityQueue<String>> graph = new HashMap<>();
    List<String> res = new ArrayList<String>();
    public List<String> findItinerary(String[][] tickets) {
        //build graph
        for(String[] ticket : tickets){
            graph.computeIfAbsent(ticket[0],k -> new PriorityQueue<String>()).offer(ticket[1]);
        }
        
        //欧拉回路
        dfs("JFK");
        return res;
    }
    void dfs(String start){
        while(graph.containsKey(start)&&!graph.get(start).isEmpty()){
            dfs(graph.get(start).poll());
        }
        res.add(0,start);
    }
}

整理一下优先队列的知识点
PriorityQueue 是一个优先队列,Java中优先队列底层由小根堆实现,
而小根堆具有以下性质
1.堆中某个结点的值总是不大于（或不小于）其父结点的值；
2.堆总是一棵完全二叉树。

对于插入offer(E e)、弹出poll()、删除remove()这类修改二叉树结构的操作,
由于需要调用siftUp或siftDown函数(自上而下调整父子节点),时间复杂度为O(log(n)).

对于删除或查找某个特定对象的remove(Object o)、contains(Object o)方法,
由于需要搜索整颗二叉树,时间复杂度为O(n).

对于peek(),element(),size()等查询操作,时间复杂度为O(1).

深入理解PriorityQueue
https://www.baidu.com/link?url=QJ1FBMeW3q2pCPcxBcucKEN7Tnz1jBoHrH20Q7-q2fkQp_fFYJfqCxqNJ51Ft97TkOqFbq5KgmydZ4eTHKdJ5a&wd=&eqid=a44d70b00007a4d0000000035af8260f
