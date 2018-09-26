685. Redundant Connection II

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root)

for which all other nodes are descendants of this node, plus every node has exactly one parent,

except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct

values 1, 2, ..., N), with one additional directed edge added. The added edge has two different

vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that

represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If

there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

题意
给定N个结点N条边的有向图，把一条边去掉使之成为一颗树。
这个问题和无向图去环的不同点在于，看一个例子来说明吧。
对于[3,1],[2,1],[1,4],[4,2]来说，最后一个出现的导致环的边是[4,2]
但如果我们删掉的是[4,2]这条边，会发现[3,1],[2,1]这两条边导致了一个问题，结点1有两个父亲3和2，
这与树的定义是违背的，树的每一个节点只有一个父亲，根节点没有父亲。
因此如果对于某个节点有两个父亲结点，那么必须删除这两条边之一，谁在环里删谁，都不在环里删第二个。
在这个例子里，要被删除的边是[2,1].

[1,2],[1,3],[2,3] 这个边集没有环，但3有两个父亲结点1和2，因此我们删除第二个边[2,3]

思路
1.首先要考虑的是，是否出现了某个节点，拥有两个父亲结点。
如果有的话，把这个结点和两个父亲节点对应的边保存下来，记为candA,candB,同时把第二个边设成无效边(默认删除后面的边嘛)。
2.应用并查集搜索有效边。
    搜索到有效边的两个结点有共同父亲，说明该树出现了环，该树不合理。
        判断candA是否为空
            若candA为空，返回现在的边edge[i]。
            若candA不为空，则直接返回candA。
    没有搜索到有效边的两个结点有共同父亲，说明不把candB加入时整个图时合法的树，返回candB。

代码
class Solution {
public:
    int parent[2005];
    int find(int x)
    {
        while(x!=parent[x])
            x=parent[x];
        return x;
    }
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {

        vector<int> res,candA,candB;
        if(edges.empty())
            return res;

        //find if one node has two parent,and save the two edge.
        for(int i=0;i<2005;i++)
            parent[i]=0;
        for(int i=0;i<edges.size();i++)
        {
            if(parent[edges[i][1]]==0)
                parent[edges[i][1]]=edges[i][0];
            else
            {
                candA={parent[edges[i][1]],edges[i][1]};
                candB=edges[i];
                edges[i][1]=0;      //set the second edge invalid.
            }
        }

        //union-find
        for(int i=0;i<2005;i++)
            parent[i]=i;
        for(int i=0;i<edges.size();i++)
        {
            if(edges[i][1]==0)
                continue;
            int u=find(edges[i][0]),v=find(edges[i][1]);
            if(u==v)
            {
                if(candA.empty())
                    return edges[i];
                return candA;
            }
            else
                parent[v]=u;
        }
        return candB;
    }
};

