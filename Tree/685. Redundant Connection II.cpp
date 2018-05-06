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

����
����N�����N���ߵ�����ͼ����һ����ȥ��ʹ֮��Ϊһ������
������������ͼȥ���Ĳ�ͬ�����ڣ���һ��������˵���ɡ�
����[3,1],[2,1],[1,4],[4,2]��˵�����һ�����ֵĵ��»��ı���[4,2]
���������ɾ������[4,2]�����ߣ��ᷢ��[3,1],[2,1]�������ߵ�����һ�����⣬���1����������3��2��
�������Ķ�����Υ���ģ�����ÿһ���ڵ�ֻ��һ�����ף����ڵ�û�и��ס�
����������ĳ���ڵ����������׽�㣬��ô����ɾ����������֮һ��˭�ڻ���ɾ˭�������ڻ���ɾ�ڶ�����
����������Ҫ��ɾ���ı���[2,1].

[1,2],[1,3],[2,3] ����߼�û�л�����3���������׽��1��2���������ɾ���ڶ�����[2,3]

˼·
1.����Ҫ���ǵ��ǣ��Ƿ������ĳ���ڵ㣬ӵ���������׽�㡣
����еĻ�������������������׽ڵ��Ӧ�ı߱�����������ΪcandA,candB,ͬʱ�ѵڶ����������Ч��(Ĭ��ɾ������ı���)��
2.Ӧ�ò��鼯������Ч�ߡ�
    ��������Ч�ߵ���������й�ͬ���ף�˵�����������˻�������������
        �ж�candA�Ƿ�Ϊ��
            ��candAΪ�գ��������ڵı�edge[i]��
            ��candA��Ϊ�գ���ֱ�ӷ���candA��
    û����������Ч�ߵ���������й�ͬ���ף�˵������candB����ʱ����ͼʱ�Ϸ�����������candB��

����
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

