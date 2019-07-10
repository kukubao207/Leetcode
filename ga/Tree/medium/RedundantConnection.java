package Tree.medium;
//684. Redundant Connection
//In this problem, a tree is an undirected graph that is connected and has no cycles.
//
//The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
//
//The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
//
//Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
//
//Example 1:
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given undirected graph will be like this:
//  1
// / \
//2 - 3
//Example 2:
//Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//Output: [1,4]
//Explanation: The given undirected graph will be like this:
//5 - 1 - 2
//    |   |
//    4 - 3
//Note:
//The size of the input 2D-array will be between 3 and 1000.
//Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
//
//Update (2017-09-26):
//We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
public class RedundantConnection {

//    此题使用并查集比较容易解决。
//    并查集通过寻找祖先来判断是不是同一路,每个节点不关心根节点是谁，只关心上一级

//    对于同一棵树的所有节点来说，都拥有共同的祖先节点。
//    因此，判断冗余连接的条件即为，判断新加入的边，两个节点是否有共同的祖先。
//   （1）如果有共同的祖先，则说明这条边是冗余的边；（说明已经形成树结构了）
//   （2）如果没有共同的祖先，则说明这两条边并未加入树中，因此进行合并操作。

//    循环边的记录，获取最后出现的冗余边，就是答案。
    //时间复杂度O(n*n)
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] pre = new int[n + 1];//节点的上一级
        int[] res = new int[2];
        //每个pre节点初始化为自己
        // 节点的上一级为自己
        // 只有root节点的上一级才是自己
        for(int i = 0;i <= n;i++){//1,2,...,n
            pre[i] = i;
        }
        for(int[] arr: edges){
            int root1 = findRoot(arr[0], pre);
            int root2 = findRoot(arr[1], pre);
            //arr边的两个节点arr[0],arr[1]有共同的根节点，说明在一个树结构中，此时这条边不能加入，否则会形成环，因此这条边需要删去
            if(root1 == root2){
                res[0] = arr[0];
                res[1] = arr[1];
            }
            else{
//                pre[arr[0]] = arr[1];//连接两条边
                pre[root1] = root2;//根节点相连才可以
            }
        }
        return res;
    }
    //寻找该节点的根节点
    public int findRoot(int x, int[] pre){
        while(pre[x] != x)
            x = pre[x];
        return x;
    }

}
