133. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/



题意
克隆一个图.

思路1
DFS递归利用Map完成构造.

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    Map<Integer,UndirectedGraphNode> map=new HashMap<>();
    private UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node==null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label);
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label,newNode);
        for(UndirectedGraphNode neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        
        return newNode;
    }
}

思路2
仅做搜索的BFS
public class Solution {
    public void cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.pop();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
做了克隆的BFS
就是在搜索的基础上,加入了HashMap,用来保存<标签,节点>的映射.
如果当前访问到的节点的标签不存在于map中,则说明该节点未被访问过,
对于未被访问过的节点,我们需要克隆一个新节点,同时把他加入map中,
对于访问过的节点,我们只需要从map中拿出对应该标签的节点,然后做一个链接(加入neighbors中).
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes
        
        map.put(newNode.label, newNode); //add first node to HashMap
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue
        
        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }
        
        return newNode;
    }
}

看一下别人写的文章
/*--详细的解释--*/
Clone a graph. Input is a Node pointer. Return the Node pointer of the cloned graph.

A graph is defined below:
struct Node {
    vector neighbors;
}

Hint:
There are two main ways to traverse a graph. Do you still remember them? Could you tell if the graph is directed or undirected?

Solution:
There are two main ways to traverse a graph: Breadth-first or Depth-first. Let’s try the Breadth-first approach first, which requires a queue. For the Depth-first approach, please see Clone Graph Part II.

How does the breadth-first traversal works? Easy, as we pop a node off the queue, we copy each of its neighbors, and push them to the queue.

A straight forward breadth-first traversal seemed to work. But some details are still missing. For example, how do we connect the nodes of the cloned graph?

Before we continue, we first need to make sure if the graph is directed or not. If you notice how Node is defined above, it is quite obvious that the graph is a directed graph. Why?

For example, A can have a neighbor called B. Therefore, we may traverse from A to B. An undirected graph implies that B can always traverse back to A. Is it true here? No, because whether B could traverse back to A depends if one of B’s neighbor is A.

The fact that B can traverse back to A implies that the graph may contain a cycle. You must take extra care to handle this case. Imagine that you finished implementing without considering this case, and later being pointed out by your interviewer that your code has an infinite loop, yuck!

Let’s analyze this further by using the below example:

重点来了!!!
A simple graph
1->2 2<-1

Assume that the starting point of the graph is A. First, you make a copy of node A (A2), and found that A has only one neighbor B. You make a copy of B (B2) and connects A2->B2 by pushing B2 as A2’s neighbor. Next, you find that B has A as neighbor, which you have already made a copy of. Here, we have to be careful not to make a copy of A again, but to connect B2->A2 by pushing A2 as B2’s neighbor. But, how do we know if a node has already been copied?

Easy, we could use a hash table! As we copy a node, we insert it into the table. If we later find that one of a node’s neighbor is already in the table, we do not make a copy of that neighbor, but to push its neighbor’s copy to its copy instead. Therefore, the hash table would need to store a mapping of key-value pairs, where the key is a node in the original graph and its value is the node’s copy.

Let’s implement the code!

typedef unordered_map<Node *, Node *> Map;

Node *clone(Node *graph) {
    if (graph==NULL)
        return NULL;

    Map map;
    queue<Node *> q;
    q.push(graph);

    Node *graphCopy = new Node();
    map[graph] = graphCopy;

    while (!q.empty()) {
        Node *node = q.front();
        q.pop();
        int n = node->neighbors.size();
        for (int i = 0; i < n; i++) {
            Node *neighbor = node->neighbors[i];
            // no copy exists
            if (map.find(neighbor) == map.end()) {
                Node *p = new Node();
                map[node]->neighbors.push_back(p);
                map[neighbor] = p;
                q.push(neighbor);
            } else {     // a copy already exists
                map[node]->neighbors.push_back(map[neighbor]);
        }
    }
}

return graphCopy;
}