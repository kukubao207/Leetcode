package Tree.hard;
import java.util.Arrays;
import java.util.List;


//834. Sum of Distances in Tree
//An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
//
//The ith edge connects nodes edges[i][0] and edges[i][1] together.
//
//Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
//
//Example 1:
//
//Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//Output: [8,12,6,10,10,10]
//Explanation:
//Here is a diagram of the given tree:
//  0
// / \
//1   2
//   /|\
//  3 4 5
//We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
//equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
//Note: 1 <= N <= 10000
public class SumofDistancesinTree {
    //以满二叉树为例
    //      1
    //     / \
    //   2    3
    //  / \  / \
    // 4  5 6  7
    //我们先将无向连通图转换为多叉树形结构  //或者转换成图结构
    //然后进行两次深度遍历
    //第一次深度遍历，记录其余节点到根节点的距离和distance(1)。同时记录每个节点的子节点的个数int[N] subNodes（包括自己）N = 7
    //第二次深度遍历，计算sum(2) = 10: 先将1和2之间的连线断开，2的联通节点的个数（不包含自己）conNodes[2] = subNodes[2] = 3, 1的联通节点的个数conNodes[1] = N - 3 = 4
    // distance(2) = distance(1) + conNodes[1] - conNodes[2] == 11....一直递归计算

    Node[] nodes;
    int[] subNodes;//每个节点的子节点的个数
    int[] distance;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        nodes = new Node[N];
        subNodes = new int[N];
        Arrays.fill(subNodes, 1);
        distance = new int[N];
        this.N = N;
        if (N == 1) {
            return new int[]{0};
        }
        for(int[] edge: edges){//转换为多叉树
            Node node1 = nodes[edge[0]];
            Node node2 = nodes[edge[1]];
            if(node1 == null){
                node1 = new Node(edge[0]);
                nodes[edge[0]] = node1;
            }
            if(node2 == null){
                node2 = new Node(edge[1]);
                nodes[edge[1]] = node2;
            }
            node1.children.add(node2);
        }
        Node root = nodes[edges[0][0]];
        dfs1(root);
        dfs2(root);
        return distance;
    }

    //求出以0为根的距离之和且求出了分别以i为根的子树结点数量和
    //子节点的个数=左子树的节点+右子树的节点+1
    //根的和=左子树的和+左子树的子节点+右子树的和+右子树的子节点
    //后序遍历
    public void dfs1(Node node){
        if(node == null)
            return;
        for(Node n: node.children){
            dfs1(n);
            subNodes[node.val] +=  subNodes[n.val];
            distance[node.val] += distance[n.val] + subNodes[n.val];
        }
    }

    public void dfs2(Node node){
        if(node == null)
            return;
        for(Node n: node.children){
            distance[n.val] = distance[node.val]  - subNodes[n.val] + N - subNodes[n.val];
            dfs2(n);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
    };




}
