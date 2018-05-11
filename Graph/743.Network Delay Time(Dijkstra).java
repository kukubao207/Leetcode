743. Network Delay Time

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.

题意
求出网络延迟(从点到所有点的最短距离的最大值)

思路
Dijkstra算法求解源点到所有点的最短距离,在最短距离中求出最大值.

class Solution {
    int G[][] = new int[105][105];
    int []dist = new int[105];
    boolean []s = new boolean[105];
    public int networkDelayTime(int[][] times, int N, int K) {
        build(times);
        dijkstra(K,N);
        int LongestTime=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            if(dist[i]>LongestTime)
                LongestTime=dist[i];
        }
        return LongestTime==2147483647 ? -1 : LongestTime;
    }
    void build(int[][] times)
    {
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(s,false);
        for(int i=0;i<G.length;i++)
            Arrays.fill(G[i],Integer.MAX_VALUE);
        for(int i=0;i<times.length;i++){
            int from=times[i][0];
            int to=times[i][1];
            int weight=times[i][2];
            G[from][to]=weight;
        }
        
    }
    void dijkstra(int v,int N){
        for(int i=1;i<=N;i++)
            dist[i]=G[v][i];
        s[v]=true;
        dist[v]=0;
        for(int i=2;i<=N;i++){
            int minDist=Integer.MAX_VALUE;
            int minIndex=0;
            for(int j=1;j<=N;j++){
                if(s[j]==false&&dist[j]<minDist){
                    minDist=dist[j];
                    minIndex=j;
                }
            }
            s[minIndex]=true;
            for(int j=1;j<=N;j++){
                if(s[j]==false&&G[minIndex][j]!=Integer.MAX_VALUE&&dist[minIndex]+G[minIndex][j]<dist[j]){
                    dist[j]=dist[minIndex]+G[minIndex][j];
                }
            }
        }
    }
}