207. 拓扑排序(有向图判环)

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should
also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
Hints:

This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.

题意
给定一些列课程学习顺序,判断能否学完全部课程.
[[1,0],[0,1]] 想学1,要先学0,想学0,得先学1.他们二者循环依赖,因此无法学习0和1.
这题就是一个拓扑排序问题,也可以理解为一个有向图判环问题,
对于[1,0],我们构建一条边0->1,用所有的边组成一个图.
判断这个图中是否有环,若有环,则存在循环依赖.

dfs做法
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int color[] = new int[numCourses];
        Arrays.fill(color,0);
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList();
        }
        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        
        for(int i=0;i<numCourses;i++){
            if(color[i]==0){
                if(dfs(i,graph,color)==false)
                    return false;
            }
        }
        
        return true;
    }
    
    boolean dfs(int node,ArrayList[] graph,int color[]){
        if(color[node]!=0)
            return color[node]==2;
        color[node]=1;
        for(int i=0; i<graph[node].size();i++){
            if(dfs((int)graph[node].get(i),graph,color)==false)
                return false;
        }
        color[node]=2;
        return true;
    }
}

拓扑排序(非递归)做法 (维护一个inDegree入度数组)
1.建图,并计算所有顶点的入度.
2.查找所有入度为0的点,全部入队.
3.当队列不为空:
    弹出队头元素. (意思把该元素从图中删去)
    deleteNum++
    检查队头顶点关联的顶点 (把所有关联的顶点入度-1)
        如果该顶点入度-1==0
            该顶点入队.
4.判断deleteNum是否和该图的顶点数相同

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //1.build graph and compute the inDegree[]
        int []inDegree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int pre=prerequisites[i][1],to=prerequisites[i][0];
            inDegree[to]++;
            graph[pre].add(to);
        }
        
        //2.find the nodes whose indegree=0 and push them to queue.
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }
        
        //3.bfs
        int count=0;
        while(!queue.isEmpty()){
            int from = queue.poll();
            count++;
            for(int i=0;i<graph[from].size();i++){
                int to = (int)graph[from].get(i);
                inDegree[to]--;
                if(inDegree[to]==0){
                    queue.offer(to);
                }
            }
        }
        
        //4.check
        if(count==numCourses)
            return true;
        else
            return false;
    }
    
    
}

