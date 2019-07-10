package Tree.hard;
//685. Redundant Connection II
//In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
//
//The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
//
//The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
//
//Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
//
//Example 1:
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given directed graph will be like this:
//  1
// / \
//v   v
//2-->3
//Example 2:
//Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//Output: [4,1]
//Explanation: The given directed graph will be like this:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
//Note:
//The size of the input 2D-array will be between 3 and 1000.
//Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
public class RedundantConnectionII {
    //有向图
    //684题给的是无向图，只需要删掉组成环的最后一条边即可，检测环就行了。
    // 这题给的是有向图，就复杂多了，有三种情况存在，
    // 1.（连接叶子与根节点,此时构成回路,所有点的入度为1）有环，无入度2的节点（比如例子2是有环，但是没有入度为2的结点）——删除最后一个形成环的边
    // 2.（两个非根节点相连，入度为2的节点的两个父亲都可以追溯到根节点）无环，有入度2的节点（比如例子1就是无环，但是有入度为2的结点3）——删除最后一条使得入度大于1的边
    // 3.（两个非根节点相连，入度为2的节点的一个父亲可以追溯祖先到根节点,另一个父亲追溯祖先陷入循环回路））既有环，又有入度2的节点——先试探将2的边删除后剩下的边会不会成环，不成环则2的边为所求，否则删除入度大于1节点的第一条边

    // 1.没有入度为 2 的点：则一定有首尾相接的圈（意思是箭头方向全是一致，全是顺时针或者逆时针），此时可以按照无向图的情形处理，删除最后出现的多余的边。
    // 2.有入度为 2 的点 c，两条边先后出现的顺序是 [a,c] 和 [b,c]：在边集中去掉 [b,c]，判断剩下的边集中是否存在圈： a. 如果存在圈，则删掉 [a,c]。 b. 不存在圈，则删掉 [b,c].
    //时间复杂度O(3m)
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inCount = new int[n + 1];//记录入度
        int[] pre = new int[n + 1];//记录上一级
        int[] cycleEdge = null;  //形成环的边
        int[] secondEdge = null;  //使得节点入度为2的边
        int node = 0;  //入度的2的节点
        for(int i = 0; i <= n; i++)
            pre[i] = i;
        for(int[] edge : edges){
            int root1 = findRoot(edge[0], pre);
            int root2 = findRoot(edge[1], pre);
            if (root1 == root2) {//成环
                cycleEdge = edge;
            }else{
                pre[root1] = root2;
            }
            inCount[edge[1]] += 1;
            //入度大于1
            if(inCount[edge[1]] > 1){
                secondEdge = edge;
                node = edge[1];
            }
        }
        // 如果有环，但是没有入度为2的节点，说明cycleEdge这条边为多余的
        if (cycleEdge != null && node == 0) {
            return cycleEdge;
        }else if (cycleEdge == null && node != 0) {
            // 如果没有环，但是有入度为2的节点，说明secondEdge这条边是多余的
            return secondEdge;
        }else{//入度为2的话就两种删除的边的可能性
            // 既有环又有入度为2的节点，第二次遍历，看看去掉secondEdge那条边后，剩下的边是否成环
            // 如果剩下的边不成环，说明secondEdge这条边是既是导致入度为2的边，也是导致形成环的边，需要删除
            for (int i = 0; i < pre.length; i++) {
                //pre清空
                pre[i] = i;
            }
            boolean cycle = false;
            for(int[] edge: edges){
                if(edge != secondEdge){
                    int root1 = findRoot(edge[0], pre);
                    int root2 = findRoot(edge[1], pre);
                    if(root1 == root2){//成环，跳出循环
                        cycle = true;
                        break;
                    }
                    pre[root1] = root2;
                }
            }
            if(!cycle)
                return secondEdge;
            // 剩下的边成环，说明secondEdge这条边不是环上的边，需要第三次遍历，找到第一个连接到node的边，这条边肯定也在环上
            for(int[] edge: edges){
                if(edge[1] == node)
                    return edge;
            }
        }
        return null;
    }
    //找到它的祖先
    private int findRoot(int x, int[] pre){
        while(x != pre[x])
            x = pre[x];
        return x;
    }

}
