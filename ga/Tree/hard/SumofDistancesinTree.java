package Tree.hard;
import java.util.*;


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
    public static void main(String[] args){
        int[][] edges = new int[][]{{2,0}, {1,0}};
        System.out.print(sumOfDistancesInTree(3, edges));
    }
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

    //1.将无向连通图转换为多叉树形结构(无向)
    static Node[] nodes;
    static int[] subNodes;//每个节点的子节点的个数
    static int[] distance;
    static int K;
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        nodes = new Node[N];
        subNodes = new int[N];
        Arrays.fill(subNodes, 1);
        distance = new int[N];
        K = N;
        if (N == 1) {
            return new int[]{0};
        }
        for(int[] edge: edges){//转换为多叉树
            Node node1 = nodes[edge[0]];
            Node node2 = nodes[edge[1]];
            if(node1 == null){
                node1 = new Node(edge[0], new ArrayList<>());
                nodes[edge[0]] = node1;
            }
            if(node2 == null){
                node2 = new Node(edge[1], new ArrayList<>());
                nodes[edge[1]] = node2;
            }
            //这里应该构建无向树
            node1.children.add(node2);
            node2.children.add(node1);
        }
//        for(Node n: nodes){
//            System.out.println(n.val);
//            System.out.print("children:");
//            for(Node nn: n.children)
//                System.out.print(nn.val);
//            System.out.println();
//        }
        Node root = nodes[edges[0][0]];
        dfs1(root, null);
//        System.out.println(distance[root.val]);
//        System.out.println(Arrays.toString(subNodes));
        dfs2(root, null);
//        System.out.println(Arrays.toString(distance));
        return distance;
    }
    //求出以0为根的距离之和且求出了分别以i为根的子树结点数量和
    //子节点的个数=左子树的节点+右子树的节点+1
    //根的和=左子树的和+左子树的子节点+右子树的和+右子树的子节点
    //后序遍历
    public static void dfs1(Node node, Node pre){
        if(node == null)
            return;
        for(Node n: node.children){
            if(n != pre){
                dfs1(n, node);
                subNodes[node.val] +=  subNodes[n.val];
                distance[node.val] += distance[n.val] + subNodes[n.val];
            }
        }
    }

    public static void dfs2(Node node, Node pre){
        if(node == null)
            return;
        for(Node n: node.children){
            if( n != pre){
                distance[n.val] = distance[node.val]  - subNodes[n.val] + K - subNodes[n.val];
                dfs2(n, node);
            }
        }
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //2.将无向连通图转换为多叉树形结构(邻接表)
    List<HashSet<Integer>> graph;
    public int[] sumOfDistancesInTree1(int N, int[][] edges) {
        graph = new ArrayList<>();
        for(int i = 0; i < N; i++)
            graph.add(new HashSet<>());
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return distance;
    }

    public void dfs1(int node, int parent){
        for(int child: graph.get(node)){
            if(child != parent){
                dfs1(child, node);
                subNodes[node] += subNodes[child];
                distance[node] += distance[child] + subNodes[child];
            }
        }
    }
    public void dfs2(int node, int parent){
        for(int child: graph.get(node)){
            if(child != parent){
                distance[child] = distance[node] - subNodes[child] + K - subNodes[child];
                dfs2(child, node);
            }
        }
    }
}
