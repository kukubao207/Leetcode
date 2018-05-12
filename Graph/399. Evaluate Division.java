Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

题意
给定一系列的 (变量)x0/ (变量)y0 = (常量)z0 , y0/y1 = z1, ......
求解给定的一系列 x0/y1 .......

思路
通过给定的一系列恒等式构建一张图,
把x0/y0 = z0 转换成图中的两条边, x0 -> y0 ,权重为z0, y0 -> x0, 权重为 1/z0
求某个等式x0/y1就转换为,能否找到一条路径,从起点x0到终点y1上每条边权重的乘积.

class Solution {
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,ArrayList<String>> pairs=new HashMap<>();        //标记一个顶点所有连接的顶点
        HashMap<String,ArrayList<Double>> valuesPair=new HashMap<>();   //标记一个顶点和所有连接的顶点的边长
        
        //建图
        for(int i=0; i<equations.length; i++){
            String[] equation = equations[i];
            if(!pairs.containsKey(equation[0])){
                pairs.put(equation[0],new ArrayList<String>());
                valuesPair.put(equation[0],new ArrayList<Double>());
            }
            if(!pairs.containsKey(equation[1])){
                pairs.put(equation[1],new ArrayList<String>());
                valuesPair.put(equation[1],new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        //求解
        double[] res = new double[queries.length];
        for(int i=0;i<queries.length;i++){
            double temp=dfs(queries[i][0],queries[i][1],pairs,valuesPair,new HashSet<String>(),1.0);
            if(temp == 0.0)
                res[i]=-1.0;
            else
                res[i]=temp;
        }
        return res;
    }
    //深度优先搜索
    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> pairsValue,HashSet<String> set, double value) {
        if(set.contains(start))
            return 0.0;
        if(!pairs.containsKey(start))
            return 0.0;
        if(start.equals(end))
            return value;
        
        set.add(start);
        ArrayList<String> vertex = pairs.get(start);
        ArrayList<Double> weight = pairsValue.get(start);
        double temp=0.0;
        for(int i=0;i<vertex.size();i++){
            temp=dfs(vertex.get(i),end,pairs,pairsValue,set,value*weight.get(i));
            if(temp!=0.0)
                break;
        }
        return temp;
    }
}

